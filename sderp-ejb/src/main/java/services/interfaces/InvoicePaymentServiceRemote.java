package services.interfaces;

import javax.ejb.Remote;

import entities.InvoicePayment;

@Remote
public interface InvoicePaymentServiceRemote extends IService<InvoicePayment> {

}
