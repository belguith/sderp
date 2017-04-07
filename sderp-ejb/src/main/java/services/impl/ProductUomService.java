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

import entities.ProductUom;
import services.interfaces.ProductUomServiceLocal;
import services.interfaces.ProductUomServiceRemote;

/**
 * Session Bean implementation class ProductUomService
 */
@Stateless
@LocalBean
public class ProductUomService implements ProductUomServiceRemote, ProductUomServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ProductUomService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ProductUom create(ProductUom t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public ProductUom find(Integer id) {
		return this.em.find(ProductUom.class, id);
	}

	@Override
	public ProductUom update(ProductUom t) {
		return (ProductUom) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		ProductUom a = this.em.find(ProductUom.class, id);
		this.em.remove(a);
	}

	@Override
	public List<ProductUom> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<ProductUom> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<ProductUom> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<ProductUom> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<ProductUom> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
