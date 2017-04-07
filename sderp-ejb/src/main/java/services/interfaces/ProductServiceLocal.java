package services.interfaces;

import javax.ejb.Local;

import entities.Product;

@Local
public interface ProductServiceLocal extends IService<Product> {

}
