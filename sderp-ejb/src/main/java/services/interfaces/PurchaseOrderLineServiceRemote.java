package services.interfaces;

import javax.ejb.Remote;

import entities.PurchaseOrderLine;

@Remote
public interface PurchaseOrderLineServiceRemote extends IService<PurchaseOrderLine> {

}
