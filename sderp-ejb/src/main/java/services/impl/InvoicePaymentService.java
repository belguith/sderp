package services.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.InvoicePayment;
import services.interfaces.InvoicePaymentServiceLocal;
import services.interfaces.InvoicePaymentServiceRemote;

/**
 * Session Bean implementation class InvoicePaymentService
 */
@Stateless
@LocalBean
public class InvoicePaymentService implements InvoicePaymentServiceRemote, InvoicePaymentServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public InvoicePaymentService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public InvoicePayment create(InvoicePayment t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public InvoicePayment find(Integer id) {
		return this.em.find(InvoicePayment.class, id);
	}

	@Override
	public InvoicePayment update(InvoicePayment t) {
		return (InvoicePayment) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		InvoicePayment a = this.em.find(InvoicePayment.class, id);
		this.em.remove(a);
	}

	@Override
	public List<InvoicePayment> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<InvoicePayment> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<InvoicePayment> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<InvoicePayment> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<InvoicePayment> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
