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

import entities.PurchaseOrderLine;
import services.interfaces.PurchaseOrderLineServiceLocal;
import services.interfaces.PurchaseOrderLineServiceRemote;

/**
 * Session Bean implementation class PurchaseOrderLineService
 */
@Stateless
@LocalBean
public class PurchaseOrderLineService implements PurchaseOrderLineServiceRemote, PurchaseOrderLineServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public PurchaseOrderLineService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PurchaseOrderLine create(PurchaseOrderLine t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public PurchaseOrderLine find(Integer id) {
		return this.em.find(PurchaseOrderLine.class, id);
	}

	@Override
	public PurchaseOrderLine update(PurchaseOrderLine t) {
		return (PurchaseOrderLine) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		PurchaseOrderLine a = this.em.find(PurchaseOrderLine.class, id);
		this.em.remove(a);
	}

	@Override
	public List<PurchaseOrderLine> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<PurchaseOrderLine> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<PurchaseOrderLine> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<PurchaseOrderLine> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<PurchaseOrderLine> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
