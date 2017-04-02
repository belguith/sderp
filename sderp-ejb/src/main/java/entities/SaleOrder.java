package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sale_order database table.
 * 
 */
@Entity
@Table(name="sale_order")
@NamedQuery(name="SaleOrder.findAll", query="SELECT s FROM SaleOrder s")
public class SaleOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Byte active;

	@Column(name="amount_tax")
	private Double amountTax;

	@Column(name="amount_total")
	private Double amountTotal;

	@Column(name="amount_untaxed")
	private Double amountUntaxed;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name="delivery_created")
	private Byte deliveryCreated;

	private Integer discount;

	@Column(name="invoice_method")
	private String invoiceMethod;

	private String name;

	@Lob
	private String notes;

	private Byte paid;

	private Byte shipped;

	private String state;

	private Double unpaid;

	//bi-directional many-to-one association to DeliveryOrder
	@OneToMany(mappedBy="saleOrder", fetch=FetchType.EAGER)
	private List<DeliveryOrder> deliveryOrders;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="saleOrder", fetch=FetchType.EAGER)
	private List<Invoice> invoices;

	//bi-directional many-to-one association to Partner
	@ManyToOne
	private Partner partner;

	//bi-directional many-to-one association to SaleOrderLine
	@OneToMany(mappedBy="saleOrder", fetch=FetchType.EAGER)
	private List<SaleOrderLine> saleOrderLines;

	public SaleOrder() {
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

	public Byte getDeliveryCreated() {
		return this.deliveryCreated;
	}

	public void setDeliveryCreated(Byte deliveryCreated) {
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

	public Byte getPaid() {
		return this.paid;
	}

	public void setPaid(Byte paid) {
		this.paid = paid;
	}

	public Byte getShipped() {
		return this.shipped;
	}

	public void setShipped(Byte shipped) {
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
		deliveryOrder.setSaleOrder(this);

		return deliveryOrder;
	}

	public DeliveryOrder removeDeliveryOrder(DeliveryOrder deliveryOrder) {
		getDeliveryOrders().remove(deliveryOrder);
		deliveryOrder.setSaleOrder(null);

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
		invoice.setSaleOrder(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setSaleOrder(null);

		return invoice;
	}

	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public List<SaleOrderLine> getSaleOrderLines() {
		return this.saleOrderLines;
	}

	public void setSaleOrderLines(List<SaleOrderLine> saleOrderLines) {
		this.saleOrderLines = saleOrderLines;
	}

	public SaleOrderLine addSaleOrderLine(SaleOrderLine saleOrderLine) {
		getSaleOrderLines().add(saleOrderLine);
		saleOrderLine.setSaleOrder(this);

		return saleOrderLine;
	}

	public SaleOrderLine removeSaleOrderLine(SaleOrderLine saleOrderLine) {
		getSaleOrderLines().remove(saleOrderLine);
		saleOrderLine.setSaleOrder(null);

		return saleOrderLine;
	}

}