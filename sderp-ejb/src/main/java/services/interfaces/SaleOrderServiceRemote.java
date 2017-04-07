package services.interfaces;

import javax.ejb.Remote;

import entities.SaleOrder;

@Remote
public interface SaleOrderServiceRemote extends IService<SaleOrder> {

}
