package services.interfaces;

import javax.ejb.Local;

import entities.PurchaseOrder;

@Local
public interface PurchaseOrderServiceLocal extends IService<PurchaseOrder> {

}
