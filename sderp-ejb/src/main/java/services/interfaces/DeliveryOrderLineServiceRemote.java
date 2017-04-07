package services.interfaces;

import javax.ejb.Remote;

import entities.DeliveryOrderLine;

@Remote
public interface DeliveryOrderLineServiceRemote extends IService<DeliveryOrderLine> {

}
