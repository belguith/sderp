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

import entities.PurchaseOrder;
import services.interfaces.PurchaseOrderServiceLocal;
import services.interfaces.PurchaseOrderServiceRemote;

/**
 * Session Bean implementation class PurchaseOrderService
 */
@Stateless
@LocalBean
public class PurchaseOrderService implements PurchaseOrderServiceRemote, PurchaseOrderServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public PurchaseOrderService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PurchaseOrder create(PurchaseOrder t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public PurchaseOrder find(Integer id) {
		return this.em.find(PurchaseOrder.class, id);
	}

	@Override
	public PurchaseOrder update(PurchaseOrder t) {
		return (PurchaseOrder) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		PurchaseOrder a = this.em.find(PurchaseOrder.class, id);
		this.em.remove(a);
	}

	@Override
	public List<PurchaseOrder> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<PurchaseOrder> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<PurchaseOrder> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<PurchaseOrder> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<PurchaseOrder> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}
}
