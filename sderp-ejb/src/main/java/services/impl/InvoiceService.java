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

import entities.Invoice;
import services.interfaces.InvoiceServiceLocal;
import services.interfaces.InvoiceServiceRemote;

/**
 * Session Bean implementation class InvoiceService
 */
@Stateless
@LocalBean
public class InvoiceService implements InvoiceServiceRemote, InvoiceServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public InvoiceService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Invoice create(Invoice t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public Invoice find(Integer id) {
		return this.em.find(Invoice.class, id);
	}

	@Override
	public Invoice update(Invoice t) {
		return (Invoice) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		Invoice a = this.em.find(Invoice.class, id);
		this.em.remove(a);
	}

	@Override
	public List<Invoice> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<Invoice> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<Invoice> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<Invoice> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<Invoice> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
