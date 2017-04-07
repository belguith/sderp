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

import entities.InvoiceTax;
import services.interfaces.InvoiceTaxServiceLocal;
import services.interfaces.InvoiceTaxServiceRemote;

/**
 * Session Bean implementation class InvoiceTaxService
 */
@Stateless
@LocalBean
public class InvoiceTaxService implements InvoiceTaxServiceRemote, InvoiceTaxServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public InvoiceTaxService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public InvoiceTax create(InvoiceTax t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public InvoiceTax find(Integer id) {
		return this.em.find(InvoiceTax.class, id);
	}

	@Override
	public InvoiceTax update(InvoiceTax t) {
		return (InvoiceTax) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		InvoiceTax a = this.em.find(InvoiceTax.class, id);
		this.em.remove(a);
	}

	@Override
	public List<InvoiceTax> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<InvoiceTax> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<InvoiceTax> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<InvoiceTax> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<InvoiceTax> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
