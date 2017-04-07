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

import entities.Journal;
import services.interfaces.JournalServiceLocal;
import services.interfaces.JournalServiceRemote;

/**
 * Session Bean implementation class JournalService
 */
@Stateless
@LocalBean
public class JournalService implements JournalServiceRemote, JournalServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public JournalService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Journal create(Journal t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public Journal find(Integer id) {
		return this.em.find(Journal.class, id);
	}

	@Override
	public Journal update(Journal t) {
		return (Journal) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		Journal a = this.em.find(Journal.class, id);
		this.em.remove(a);
	}

	@Override
	public List<Journal> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<Journal> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<Journal> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<Journal> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<Journal> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
