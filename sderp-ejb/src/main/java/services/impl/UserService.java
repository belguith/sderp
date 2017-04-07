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

import entities.User;
import services.interfaces.UserServiceLocal;
import services.interfaces.UserServiceRemote;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceRemote, UserServiceLocal {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User create(User t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public User find(Integer id) {
		return this.em.find(User.class, id);
	}

	@Override
	public User update(User t) {
		return (User) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		User a = this.em.find(User.class, id);
		this.em.remove(a);
	}

	@Override
	public List<User> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<User> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<User> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<User> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<User> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

	@Override
	public User logIn(String userName) {

		User user = null;
		String jpql = "SELECT u FROM User u WHERE u.login = :param1";
		Query query = em.createQuery(jpql);
		query.setParameter("param1", userName);
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("User Not found");
		}

		return user;
	}
}
