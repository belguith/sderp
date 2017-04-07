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

import entities.Partner;
import services.interfaces.PartnerServiceLocal;
import services.interfaces.PartnerServiceRemote;

/**
 * Session Bean implementation class PartnerService
 */
@Stateless
@LocalBean
public class PartnerService implements PartnerServiceRemote, PartnerServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public PartnerService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Partner create(Partner t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public Partner find(Integer id) {
		return this.em.find(Partner.class, id);
	}

	@Override
	public Partner update(Partner t) {
		return (Partner) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		Partner a = this.em.find(Partner.class, id);
		this.em.remove(a);
	}

	@Override
	public List<Partner> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<Partner> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<Partner> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<Partner> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<Partner> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}
}
