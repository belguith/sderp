package services.interfaces;

import java.util.List;
import java.util.Map;

public interface IService<T> {

	public T create(T t);

	public T find(Integer id);

	public T update(T t);

	public void delete( Integer id);

	public List<T> findWithNamedQuery(String queryName);

	public List<T> findWithNamedQuery(String queryName, Integer resultLimit);

	public List<T> findWithNamedQuery(String namedQueryName, Map parameters);

	public List<T> findWithNamedQuery(String namedQueryName, Map parameters, Integer resultLimit);

	public List<T> findByNativeQuery(String sql, Class type);

	

}