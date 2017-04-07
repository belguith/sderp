package services.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.DeliveryOrder;
import services.interfaces.DeliveryOrderServiceLocal;
import services.interfaces.DeliveryOrderServiceRemote;

/**
 * Session Bean implementation class DeliveryOrder
 */
@Stateless
@LocalBean
public class DeliveryOrderService implements DeliveryOrderServiceRemote, DeliveryOrderServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public DeliveryOrderService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DeliveryOrder create(DeliveryOrder t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public DeliveryOrder find(Integer id) {
		return this.em.find(DeliveryOrder.class, id);
	}

	@Override
	public DeliveryOrder update(DeliveryOrder t) {
		return (DeliveryOrder) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		DeliveryOrderService a = this.em.find(DeliveryOrderService.class, id);
		this.em.remove(a);
	}

	@Override
	public List<DeliveryOrder> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<DeliveryOrder> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<DeliveryOrder> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<DeliveryOrder> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
		Set<Entry> rawParameters = parameters.entrySet();
		Query query = this.em.createNamedQuery(namedQueryName);
		if (resultLimit > 0)
			query.setMaxResults(resultLimit);
		for (Entry entry : rawParameters) {
			query.setParameter(entry.getKey().toString(), entry.getValue());
		}
		return query.getResultList();
	}

	@Override
	public List<DeliveryOrder> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
