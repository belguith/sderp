package services.interfaces;

import javax.ejb.Local;

import entities.Employee;

@Local
public interface EmployeeServiceLocal extends IService<Employee> {

}
