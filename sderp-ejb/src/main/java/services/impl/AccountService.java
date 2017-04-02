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

import entities.Account;
import services.interfaces.AccountServiceLocal;
import services.interfaces.AccountServiceRemote;

/**
 * Session Bean implementation class AccountService
 */
@Stateless
@LocalBean
public class AccountService implements AccountServiceRemote, AccountServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public AccountService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Account create(Account t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public Account find(Integer id) {
		return this.em.find(Account.class, id);
	}

	@Override
	public Account update(Account t) {
		return (Account) this.em.merge(t);
	}

	@Override
	public void delete(Integer id) {
		Account a = this.em.find(Account.class, id);
		this.em.remove(a);
	}

	@Override
	public List<Account> findWithNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List<Account> findWithNamedQuery(String queryName, Integer resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@Override
	public List<Account> findWithNamedQuery(String namedQueryName, Map parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List<Account> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit) {
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
	public List<Account> findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}
