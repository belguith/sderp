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

import entities.JournalEntry;
import services.interfaces.JournalEntryServiceLocal;
import services.interfaces.JournalEntryServiceRemote;

/**
 * Session Bean implementation class JournalEntryService
 */
@Stateless
@LocalBean
public class JournalEntryService implements JournalEntryServiceRemote, JournalEntryServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public JournalEntryService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public JournalEntry create(JournalEntry t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public JournalEntry find(Integer id) {
		return this.em.find(JournalEntry.class, id);
	}

	@Override
	public JournalEntry update(JournalEntry t) {
		return (JournalEntry) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		JournalEntry a = this.em.find(JournalEntry.class, id);
		this.em.remove(a);
	}

	@Override
	public List<JournalEntry> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<JournalEntry> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<JournalEntry> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<JournalEntry> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<JournalEntry> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
