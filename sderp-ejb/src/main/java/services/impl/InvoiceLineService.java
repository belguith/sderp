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

import entities.InvoiceLine;
import services.interfaces.InvoiceLineServiceLocal;
import services.interfaces.InvoiceLineServiceRemote;

/**
 * Session Bean implementation class InvoiceLineService
 */
@Stateless
@LocalBean
public class InvoiceLineService implements InvoiceLineServiceRemote, InvoiceLineServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public InvoiceLineService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public InvoiceLine create(InvoiceLine t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public InvoiceLine find(Integer id) {
		return this.em.find(InvoiceLine.class, id);
	}

	@Override
	public InvoiceLine update(InvoiceLine t) {
		return (InvoiceLine) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		InvoiceLine a = this.em.find(InvoiceLine.class, id);
		this.em.remove(a);
	}

	@Override
	public List<InvoiceLine> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<InvoiceLine> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<InvoiceLine> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<InvoiceLine> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<InvoiceLine> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
