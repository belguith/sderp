package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product_uom_category database table.
 * 
 */
@Entity
@Table(name="product_uom_category")
@NamedQuery(name="ProductUomCategory.findAll", query="SELECT p FROM ProductUomCategory p")
public class ProductUomCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to ProductUom
	@OneToMany(mappedBy="productUomCategory", fetch=FetchType.EAGER)
	private List<ProductUom> productUoms;

	public ProductUomCategory() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductUom> getProductUoms() {
		return this.productUoms;
	}

	public void setProductUoms(List<ProductUom> productUoms) {
		this.productUoms = productUoms;
	}

	public ProductUom addProductUom(ProductUom productUom) {
		getProductUoms().add(productUom);
		productUom.setProductUomCategory(this);

		return productUom;
	}

	public ProductUom removeProductUom(ProductUom productUom) {
		getProductUoms().remove(productUom);
		productUom.setProductUomCategory(null);

		return productUom;
	}

}