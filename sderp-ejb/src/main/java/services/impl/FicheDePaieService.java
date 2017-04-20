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

import entities.FicheDePaie;
import services.interfaces.FicheDePaieServiceLocal;
import services.interfaces.FicheDePaieServiceRemote;

/**
 * Session Bean implementation class FicheDePaieService
 */
@Stateless
@LocalBean
public class FicheDePaieService implements FicheDePaieServiceRemote, FicheDePaieServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public FicheDePaieService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public FicheDePaie create(FicheDePaie t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public FicheDePaie find(Integer id) {
		return this.em.find(FicheDePaie.class, id);
	}

	@Override
	public FicheDePaie update(FicheDePaie t) {
		return (FicheDePaie) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		FicheDePaie a = this.em.find(FicheDePaie.class, id);
		this.em.remove(a);
	}

	@Override
	public List<FicheDePaie> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<FicheDePaie> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<FicheDePaie> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<FicheDePaie> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<FicheDePaie> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FicheDePaie> findAllFichesByEmployeeId(Integer employeeId) {

		return em.createQuery("SELECT f FROM FicheDePaie f WHERE f.employee.id = :param", FicheDePaie.class)
				.setParameter("param", employeeId).getResultList();
	}
}
