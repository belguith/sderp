package services.interfaces;

import java.util.List;
import java.util.Map;

public interface IService<T> {

	public T create(T t);

	public T find(Class type, Object id);

	public T update(T t);

	public void delete(Class type, Object id);

	public List<T> findWithNamedQuery(String queryName);

	public List<T> findWithNamedQuery(String queryName, int resultLimit);

	public List<T> findWithNamedQuery(String namedQueryName, Map parameters);

	public List<T> findWithNamedQuery(String namedQueryName, Map parameters, int resultLimit);

	public List<T> findByNativeQuery(String sql, Class type);

}