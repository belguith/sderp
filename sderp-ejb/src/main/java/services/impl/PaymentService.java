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

import entities.Payment;
import services.interfaces.PaymentServiceLocal;
import services.interfaces.PaymentServiceRemote;

/**
 * Session Bean implementation class Payment
 */
@Stateless
@LocalBean
public class PaymentService implements PaymentServiceRemote, PaymentServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public PaymentService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Payment create(Payment t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public Payment find(Integer id) {
		return this.em.find(Payment.class, id);
	}

	@Override
	public Payment update(Payment t) {
		return (Payment) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		Payment a = this.em.find(Payment.class, id);
		this.em.remove(a);
	}

	@Override
	public List<Payment> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<Payment> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<Payment> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<Payment> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<Payment> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
