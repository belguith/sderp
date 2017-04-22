package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the purchase_order database table.
 * 
 */
@Entity
@Table(name="purchase_order")
@NamedQuery(name="PurchaseOrder.findAll", query="SELECT p FROM PurchaseOrder p")
public class PurchaseOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Boolean active;

	@Column(name="amount_tax")
	private Double amountTax;

	@Column(name="amount_total")
	private Double amountTotal;

	@Column(name="amount_untaxed")
	private Double amountUntaxed;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name="delivery_created")
	private Boolean deliveryCreated;

	private Integer discount;

	@Column(name="invoice_method")
	private String invoiceMethod;

	private String name;

	@Lob
	private String notes;

	private Boolean paid;

	private String reference;

	private Boolean shipped;

	private String state;

	private Double unpaid;

	//bi-directional many-to-one association to DeliveryOrder
	@OneToMany(mappedBy="purchaseOrder", fetch=FetchType.EAGER)
	private List<DeliveryOrder> deliveryOrders;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="purchaseOrder", fetch=FetchType.EAGER)
	private List<Invoice> invoices;

	//bi-directional many-to-one association to Partner
	@ManyToOne
	private Partner partner;

	//bi-directional many-to-one association to PurchaseOrderLine
	@OneToMany(mappedBy="purchaseOrder", fetch=FetchType.EAGER)
	private List<PurchaseOrderLine> purchaseOrderLines;

	public PurchaseOrder() {
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

	public Double getAmountTax() {
		return this.amountTax;
	}

	public void setAmountTax(Double amountTax) {
		this.amountTax = amountTax;
	}

	public Double getAmountTotal() {
		return this.amountTotal;
	}

	public void setAmountTotal(Double amountTotal) {
		this.amountTotal = amountTotal;
	}

	public Double getAmountUntaxed() {
		return this.amountUntaxed;
	}

	public void setAmountUntaxed(Double amountUntaxed) {
		this.amountUntaxed = amountUntaxed;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getDeliveryCreated() {
		return this.deliveryCreated;
	}

	public void setDeliveryCreated(Boolean deliveryCreated) {
		this.deliveryCreated = deliveryCreated;
	}

	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getInvoiceMethod() {
		return this.invoiceMethod;
	}

	public void setInvoiceMethod(String invoiceMethod) {
		this.invoiceMethod = invoiceMethod;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Boolean getPaid() {
		return this.paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Boolean getShipped() {
		return this.shipped;
	}

	public void setShipped(Boolean shipped) {
		this.shipped = shipped;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getUnpaid() {
		return this.unpaid;
	}

	public void setUnpaid(Double unpaid) {
		this.unpaid = unpaid;
	}

	public List<DeliveryOrder> getDeliveryOrders() {
		return this.deliveryOrders;
	}

	public void setDeliveryOrders(List<DeliveryOrder> deliveryOrders) {
		this.deliveryOrders = deliveryOrders;
	}

	public DeliveryOrder addDeliveryOrder(DeliveryOrder deliveryOrder) {
		getDeliveryOrders().add(deliveryOrder);
		deliveryOrder.setPurchaseOrder(this);

		return deliveryOrder;
	}

	public DeliveryOrder removeDeliveryOrder(DeliveryOrder deliveryOrder) {
		getDeliveryOrders().remove(deliveryOrder);
		deliveryOrder.setPurchaseOrder(null);

		return deliveryOrder;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setPurchaseOrder(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setPurchaseOrder(null);

		return invoice;
	}

	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public List<PurchaseOrderLine> getPurchaseOrderLines() {
		return this.purchaseOrderLines;
	}

	public void setPurchaseOrderLines(List<PurchaseOrderLine> purchaseOrderLines) {
		this.purchaseOrderLines = purchaseOrderLines;
	}

	public PurchaseOrderLine addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		getPurchaseOrderLines().add(purchaseOrderLine);
		purchaseOrderLine.setPurchaseOrder(this);

		return purchaseOrderLine;
	}

	public PurchaseOrderLine removePurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		getPurchaseOrderLines().remove(purchaseOrderLine);
		purchaseOrderLine.setPurchaseOrder(null);

		return purchaseOrderLine;
	}

}