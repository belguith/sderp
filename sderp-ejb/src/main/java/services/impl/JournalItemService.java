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

import entities.JournalItem;
import services.interfaces.JournalItemServiceLocal;
import services.interfaces.JournalItemServiceRemote;

/**
 * Session Bean implementation class JournalItemService
 */
@Stateless
@LocalBean
public class JournalItemService implements JournalItemServiceRemote, JournalItemServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public JournalItemService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public JournalItem create(JournalItem t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public JournalItem find(Integer id) {
		return this.em.find(JournalItem.class, id);
	}

	@Override
	public JournalItem update(JournalItem t) {
		return (JournalItem) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		JournalItem a = this.em.find(JournalItem.class, id);
		this.em.remove(a);
	}

	@Override
	public List<JournalItem> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<JournalItem> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<JournalItem> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<JournalItem> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<JournalItem> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
