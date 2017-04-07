package services.interfaces;

import javax.ejb.Remote;

import entities.SaleOrderLine;

@Remote
public interface SaleOrderLineServiceRemote extends IService<SaleOrderLine> {

}
