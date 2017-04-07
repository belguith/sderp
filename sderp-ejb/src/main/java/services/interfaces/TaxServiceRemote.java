package services.interfaces;

import javax.ejb.Remote;

import entities.Tax;

@Remote
public interface TaxServiceRemote extends IService<Tax> {

}
