package services.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.IService;

/**
 * Session Bean implementation class Service
 */
@Stateless
@Local(IService.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class Service implements ServiceRemote, ServiceLocal {

	@PersistenceContext
	EntityManager em;

	@Override
	public Object create(Object t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public Object find(Class type, Object id) {
		return (Object) this.em.find(type, id);
	}

	@Override
	public Object update(Object t) {
		return (Object) this.em.merge(t);
	}

	@Override
	public void delete(Class type, Object id) {
		Object ref = this.em.getReference(type, id);
		this.em.remove(ref);
	}

	@Override
	public List<Object> findWithNamedQuery(String namedQueryName) {
		return this.em.createNamedQuery(namedQueryName).getResultList();
	}

	@Override
	public List<Object> findWithNamedQuery(String queryName, int resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<Object> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<Object> findWithNamedQuery(String namedQueryName, Map parameters, int resultLimit) {
		Set<Entry> rawParameters = parameters.entrySet();
		Query query = this.em.createNamedQuery(namedQueryName);
		if (resultLimit > 0)
			query.setMaxResults(resultLimit);
		for (Entry entry : rawParameters) {
			query.setParameter(entry.getKey().toString(), entry.getValue());
		}
		return query.getResultList();
	}

	public List findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
