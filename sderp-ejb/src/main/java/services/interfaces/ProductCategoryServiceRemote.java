package services.interfaces;

import javax.ejb.Remote;

import entities.ProductCategory;

@Remote
public interface ProductCategoryServiceRemote extends IService<ProductCategory> {

}
