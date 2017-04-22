package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Boolean active;

	@Column(name="default_code")
	private String defaultCode;

	private String description;

	@Lob
	private String image;

	@Lob
	@Column(name="image_medium")
	private String imageMedium;

	private Double lenght;

	private String name;

	@Column(name="purchase_ok")
	private Boolean purchaseOk;

	@Column(name="purchase_price")
	private Double purchasePrice;

	@Column(name="sale_ok")
	private Boolean saleOk;

	@Column(name="sale_price")
	private Double salePrice;

	private Double volume;

	private Double weight;

	//bi-directional many-to-one association to DeliveryOrderLine
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<DeliveryOrderLine> deliveryOrderLines;

	//bi-directional many-to-one association to Inventory
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<Inventory> inventories;

	//bi-directional many-to-one association to InvoiceLine
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<InvoiceLine> invoiceLines;

	//bi-directional many-to-one association to JournalItem
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<JournalItem> journalItems;

	//bi-directional many-to-one association to ProductCategory
	@ManyToOne
	@JoinColumn(name="categ_id")
	private ProductCategory productCategory;

	//bi-directional many-to-one association to ProductUom
	@ManyToOne
	@JoinColumn(name="uom_id")
	private ProductUom productUom;

	//bi-directional many-to-one association to PurchaseOrderLine
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<PurchaseOrderLine> purchaseOrderLines;

	//bi-directional many-to-one association to SaleOrderLine
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<SaleOrderLine> saleOrderLines;

	public Product() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDefaultCode() {
		return this.defaultCode;
	}

	public void setDefaultCode(String defaultCode) {
		this.defaultCode = defaultCode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageMedium() {
		return this.imageMedium;
	}

	public void setImageMedium(String imageMedium) {
		this.imageMedium = imageMedium;
	}

	public Double getLenght() {
		return this.lenght;
	}

	public void setLenght(Double lenght) {
		this.lenght = lenght;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getPurchaseOk() {
		return this.purchaseOk;
	}

	public void setPurchaseOk(Boolean purchaseOk) {
		this.purchaseOk = purchaseOk;
	}

	public Double getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Boolean getSaleOk() {
		return this.saleOk;
	}

	public void setSaleOk(Boolean saleOk) {
		this.saleOk = saleOk;
	}

	public Double getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Double getVolume() {
		return this.volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public List<DeliveryOrderLine> getDeliveryOrderLines() {
		return this.deliveryOrderLines;
	}

	public void setDeliveryOrderLines(List<DeliveryOrderLine> deliveryOrderLines) {
		this.deliveryOrderLines = deliveryOrderLines;
	}

	public DeliveryOrderLine addDeliveryOrderLine(DeliveryOrderLine deliveryOrderLine) {
		getDeliveryOrderLines().add(deliveryOrderLine);
		deliveryOrderLine.setProduct(this);

		return deliveryOrderLine;
	}

	public DeliveryOrderLine removeDeliveryOrderLine(DeliveryOrderLine deliveryOrderLine) {
		getDeliveryOrderLines().remove(deliveryOrderLine);
		deliveryOrderLine.setProduct(null);

		return deliveryOrderLine;
	}

	public List<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public Inventory addInventory(Inventory inventory) {
		getInventories().add(inventory);
		inventory.setProduct(this);

		return inventory;
	}

	public Inventory removeInventory(Inventory inventory) {
		getInventories().remove(inventory);
		inventory.setProduct(null);

		return inventory;
	}

	public List<InvoiceLine> getInvoiceLines() {
		return this.invoiceLines;
	}

	public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}

	public InvoiceLine addInvoiceLine(InvoiceLine invoiceLine) {
		getInvoiceLines().add(invoiceLine);
		invoiceLine.setProduct(this);

		return invoiceLine;
	}

	public InvoiceLine removeInvoiceLine(InvoiceLine invoiceLine) {
		getInvoiceLines().remove(invoiceLine);
		invoiceLine.setProduct(null);

		return invoiceLine;
	}

	public List<JournalItem> getJournalItems() {
		return this.journalItems;
	}

	public void setJournalItems(List<JournalItem> journalItems) {
		this.journalItems = journalItems;
	}

	public JournalItem addJournalItem(JournalItem journalItem) {
		getJournalItems().add(journalItem);
		journalItem.setProduct(this);

		return journalItem;
	}

	public JournalItem removeJournalItem(JournalItem journalItem) {
		getJournalItems().remove(journalItem);
		journalItem.setProduct(null);

		return journalItem;
	}

	public ProductCategory getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public ProductUom getProductUom() {
		return this.productUom;
	}

	public void setProductUom(ProductUom productUom) {
		this.productUom = productUom;
	}

	public List<PurchaseOrderLine> getPurchaseOrderLines() {
		return this.purchaseOrderLines;
	}

	public void setPurchaseOrderLines(List<PurchaseOrderLine> purchaseOrderLines) {
		this.purchaseOrderLines = purchaseOrderLines;
	}

	public PurchaseOrderLine addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		getPurchaseOrderLines().add(purchaseOrderLine);
		purchaseOrderLine.setProduct(this);

		return purchaseOrderLine;
	}

	public PurchaseOrderLine removePurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		getPurchaseOrderLines().remove(purchaseOrderLine);
		purchaseOrderLine.setProduct(null);

		return purchaseOrderLine;
	}

	public List<SaleOrderLine> getSaleOrderLines() {
		return this.saleOrderLines;
	}

	public void setSaleOrderLines(List<SaleOrderLine> saleOrderLines) {
		this.saleOrderLines = saleOrderLines;
	}

	public SaleOrderLine addSaleOrderLine(SaleOrderLine saleOrderLine) {
		getSaleOrderLines().add(saleOrderLine);
		saleOrderLine.setProduct(this);

		return saleOrderLine;
	}

	public SaleOrderLine removeSaleOrderLine(SaleOrderLine saleOrderLine) {
		getSaleOrderLines().remove(saleOrderLine);
		saleOrderLine.setProduct(null);

		return saleOrderLine;
	}

}