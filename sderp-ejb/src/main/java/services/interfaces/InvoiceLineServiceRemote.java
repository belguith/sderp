package services.interfaces;

import javax.ejb.Remote;

import entities.InvoiceLine;

@Remote
public interface InvoiceLineServiceRemote extends IService<InvoiceLine> {

}
