package services.interfaces;

import javax.ejb.Remote;

import entities.Employee;

@Remote
public interface EmployeeServiceRemote extends IService<Employee>{

}
