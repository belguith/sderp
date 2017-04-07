package services.interfaces;

import javax.ejb.Remote;

import entities.PurchaseOrder;

@Remote
public interface PurchaseOrderServiceRemote extends IService<PurchaseOrder> {

}
