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

import entities.Inventory;
import services.interfaces.InventoryServiceLocal;
import services.interfaces.InventoryServiceRemote;

/**
 * Session Bean implementation class InventoryService
 */
@Stateless
@LocalBean
public class InventoryService implements InventoryServiceRemote, InventoryServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public InventoryService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Inventory create(Inventory t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public Inventory find(Integer id) {
		return this.em.find(Inventory.class, id);
	}

	@Override
	public Inventory update(Inventory t) {
		return (Inventory) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		Inventory a = this.em.find(Inventory.class, id);
		this.em.remove(a);
	}

	@Override
	public List<Inventory> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<Inventory> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<Inventory> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<Inventory> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<Inventory> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}
}
