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

import entities.ProductCategory;
import services.interfaces.ProductCategoryServiceLocal;
import services.interfaces.ProductCategoryServiceRemote;

/**
 * Session Bean implementation class ProductCategoryService
 */
@Stateless
@LocalBean
public class ProductCategoryService implements ProductCategoryServiceRemote, ProductCategoryServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ProductCategoryService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ProductCategory create(ProductCategory t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public ProductCategory find(Integer id) {
		return this.em.find(ProductCategory.class, id);
	}

	@Override
	public ProductCategory update(ProductCategory t) {
		return (ProductCategory) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		ProductCategory a = this.em.find(ProductCategory.class, id);
		this.em.remove(a);
	}

	@Override
	public List<ProductCategory> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<ProductCategory> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<ProductCategory> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<ProductCategory> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<ProductCategory> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
