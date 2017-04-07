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

import entities.ProductUomCategory;
import services.interfaces.ProductUomCategoryServiceLocal;
import services.interfaces.ProductUomCategoryServiceRemote;

/**
 * Session Bean implementation class ProductUomCategoryService
 */
@Stateless
@LocalBean
public class ProductUomCategoryService implements ProductUomCategoryServiceRemote, ProductUomCategoryServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ProductUomCategoryService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ProductUomCategory create(ProductUomCategory t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public ProductUomCategory find(Integer id) {
		return this.em.find(ProductUomCategory.class, id);
	}

	@Override
	public ProductUomCategory update(ProductUomCategory t) {
		return (ProductUomCategory) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		ProductUomCategory a = this.em.find(ProductUomCategory.class, id);
		this.em.remove(a);
	}

	@Override
	public List<ProductUomCategory> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<ProductUomCategory> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<ProductUomCategory> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<ProductUomCategory> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<ProductUomCategory> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
