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

import entities.Tax;
import services.interfaces.TaxServiceLocal;
import services.interfaces.TaxServiceRemote;

/**
 * Session Bean implementation class TaxService
 */
@Stateless
@LocalBean
public class TaxService implements TaxServiceRemote, TaxServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public TaxService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Tax create(Tax t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public Tax find(Integer id) {
		return this.em.find(Tax.class, id);
	}

	@Override
	public Tax update(Tax t) {
		return (Tax) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		Tax a = this.em.find(Tax.class, id);
		this.em.remove(a);
	}

	@Override
	public List<Tax> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<Tax> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<Tax> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<Tax> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<Tax> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}
}
