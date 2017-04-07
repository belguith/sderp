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

import entities.DeliveryOrderLine;
import services.interfaces.DeliveryOrderLineServiceLocal;
import services.interfaces.DeliveryOrderLineServiceRemote;

/**
 * Session Bean implementation class DeliveryOrderLineService
 */
@Stateless
@LocalBean
public class DeliveryOrderLineService implements DeliveryOrderLineServiceRemote, DeliveryOrderLineServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public DeliveryOrderLineService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DeliveryOrderLine create(DeliveryOrderLine t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public DeliveryOrderLine find(Integer id) {
		return this.em.find(DeliveryOrderLine.class, id);
	}

	@Override
	public DeliveryOrderLine update(DeliveryOrderLine t) {
		return (DeliveryOrderLine) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		DeliveryOrderLine a = this.em.find(DeliveryOrderLine.class, id);
		this.em.remove(a);
	}

	@Override
	public List<DeliveryOrderLine> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<DeliveryOrderLine> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<DeliveryOrderLine> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<DeliveryOrderLine> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<DeliveryOrderLine> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}
}
