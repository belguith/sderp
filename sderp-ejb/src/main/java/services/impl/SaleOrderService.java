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

import entities.SaleOrder;
import services.interfaces.SaleOrderServiceLocal;
import services.interfaces.SaleOrderServiceRemote;

/**
 * Session Bean implementation class SaleOrderService
 */
@Stateless
@LocalBean
public class SaleOrderService implements SaleOrderServiceRemote, SaleOrderServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public SaleOrderService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SaleOrder create(SaleOrder t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public SaleOrder find(Integer id) {
		return this.em.find(SaleOrder.class, id);
	}

	@Override
	public SaleOrder update(SaleOrder t) {
		return (SaleOrder) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		SaleOrder a = this.em.find(SaleOrder.class, id);
		this.em.remove(a);
	}

	@Override
	public List<SaleOrder> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<SaleOrder> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<SaleOrder> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<SaleOrder> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<SaleOrder> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
