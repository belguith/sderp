package services.interfaces;

import javax.ejb.Remote;

import entities.Payment;

@Remote
public interface PaymentServiceRemote extends IService<Payment> {

}
