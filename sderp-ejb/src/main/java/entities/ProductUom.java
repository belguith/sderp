package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product_uom database table.
 * 
 */
@Entity
@Table(name="product_uom")
@NamedQuery(name="ProductUom.findAll", query="SELECT p FROM ProductUom p")
public class ProductUom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Byte active;

	private Integer decimals;

	private String name;

	//bi-directional many-to-one association to JournalItem
	@OneToMany(mappedBy="productUom", fetch=FetchType.EAGER)
	private List<JournalItem> journalItems;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productUom", fetch=FetchType.EAGER)
	private List<Product> products;

	//bi-directional many-to-one association to ProductUomCategory
	@ManyToOne
	@JoinColumn(name="category_id")
	private ProductUomCategory productUomCategory;

	public ProductUom() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Byte getActive() {
		return this.active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public Integer getDecimals() {
		return this.decimals;
	}

	public void setDecimals(Integer decimals) {
		this.decimals = decimals;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<JournalItem> getJournalItems() {
		return this.journalItems;
	}

	public void setJournalItems(List<JournalItem> journalItems) {
		this.journalItems = journalItems;
	}

	public JournalItem addJournalItem(JournalItem journalItem) {
		getJournalItems().add(journalItem);
		journalItem.setProductUom(this);

		return journalItem;
	}

	public JournalItem removeJournalItem(JournalItem journalItem) {
		getJournalItems().remove(journalItem);
		journalItem.setProductUom(null);

		return journalItem;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductUom(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductUom(null);

		return product;
	}

	public ProductUomCategory getProductUomCategory() {
		return this.productUomCategory;
	}

	public void setProductUomCategory(ProductUomCategory productUomCategory) {
		this.productUomCategory = productUomCategory;
	}

}