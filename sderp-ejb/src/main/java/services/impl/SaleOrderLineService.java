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

import entities.SaleOrderLine;
import services.interfaces.SaleOrderLineServiceLocal;
import services.interfaces.SaleOrderLineServiceRemote;

/**
 * Session Bean implementation class SaleOrderLineService
 */
@Stateless
@LocalBean
public class SaleOrderLineService implements SaleOrderLineServiceRemote, SaleOrderLineServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public SaleOrderLineService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SaleOrderLine create(SaleOrderLine t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public SaleOrderLine find(Integer id) {
		return this.em.find(SaleOrderLine.class, id);
	}

	@Override
	public SaleOrderLine update(SaleOrderLine t) {
		return (SaleOrderLine) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		SaleOrderLine a = this.em.find(SaleOrderLine.class, id);
		this.em.remove(a);
	}

	@Override
	public List<SaleOrderLine> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<SaleOrderLine> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<SaleOrderLine> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<SaleOrderLine> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<SaleOrderLine> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}
}
