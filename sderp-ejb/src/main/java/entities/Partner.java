package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the partner database table.
 * 
 */
@Entity
@NamedQuery(name="Partner.findAll", query="SELECT p FROM Partner p")
public class Partner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Boolean active;

	private String city;

	private String country;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private Double credit;

	private Boolean customer;

	private Double debit;

	private String email;

	private String fax;
	
	@Lob
	private String image;

	@Lob
	@Column(name="image_medium")
	private String imageMedium;

	@Column(name="is_company")
	private Boolean isCompany;

	private String mobile;

	private String name;

	private String phone;

	@Column(name="purchase_deals")
	private Integer purchaseDeals;

	@Column(name="sale_deals")
	private Integer saleDeals;

	private String street;

	private Boolean supplier;

	private String website;

	//bi-directional many-to-one association to DeliveryOrder
	@OneToMany(mappedBy="partner", fetch=FetchType.EAGER)
	private List<DeliveryOrder> deliveryOrders;

	//bi-directional many-to-one association to DeliveryOrderLine
	@OneToMany(mappedBy="partner", fetch=FetchType.EAGER)
	private List<DeliveryOrderLine> deliveryOrderLines;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="partner", fetch=FetchType.EAGER)
	private List<Invoice> invoices;

	//bi-directional many-to-one association to InvoiceLine
	@OneToMany(mappedBy="partner", fetch=FetchType.EAGER)
	private List<InvoiceLine> invoiceLines;

	//bi-directional many-to-one association to JournalEntry
	@OneToMany(mappedBy="partner", fetch=FetchType.EAGER)
	private List<JournalEntry> journalEntries;

	//bi-directional many-to-one association to JournalItem
	@OneToMany(mappedBy="partner", fetch=FetchType.EAGER)
	private List<JournalItem> journalItems;

	//bi-directional many-to-one association to Account
	@ManyToOne
	private Account accountPayable;

	//bi-directional many-to-one association to Account
	@ManyToOne
	private Account accountReceivable;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="partner", fetch=FetchType.EAGER)
	private List<Payment> payments;

	//bi-directional many-to-one association to PurchaseOrder
	@OneToMany(mappedBy="partner", fetch=FetchType.EAGER)
	private List<PurchaseOrder> purchaseOrders;

	//bi-directional many-to-one association to SaleOrder
	@OneToMany(mappedBy="partner", fetch=FetchType.EAGER)
	private List<SaleOrder> saleOrders;

	public Partner() {
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

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Double getCredit() {
		return this.credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Boolean getCustomer() {
		return this.customer;
	}

	public void setCustomer(Boolean customer) {
		this.customer = customer;
	}

	public Double getDebit() {
		return this.debit;
	}

	public void setDebit(Double debit) {
		this.debit = debit;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	public Boolean getIsCompany() {
		return this.isCompany;
	}

	public void setIsCompany(Boolean isCompany) {
		this.isCompany = isCompany;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPurchaseDeals() {
		return this.purchaseDeals;
	}

	public void setPurchaseDeals(Integer purchaseDeals) {
		this.purchaseDeals = purchaseDeals;
	}

	public Integer getSaleDeals() {
		return this.saleDeals;
	}

	public void setSaleDeals(Integer saleDeals) {
		this.saleDeals = saleDeals;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Boolean getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Boolean supplier) {
		this.supplier = supplier;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<DeliveryOrder> getDeliveryOrders() {
		return this.deliveryOrders;
	}

	public void setDeliveryOrders(List<DeliveryOrder> deliveryOrders) {
		this.deliveryOrders = deliveryOrders;
	}

	public DeliveryOrder addDeliveryOrder(DeliveryOrder deliveryOrder) {
		getDeliveryOrders().add(deliveryOrder);
		deliveryOrder.setPartner(this);

		return deliveryOrder;
	}

	public DeliveryOrder removeDeliveryOrder(DeliveryOrder deliveryOrder) {
		getDeliveryOrders().remove(deliveryOrder);
		deliveryOrder.setPartner(null);

		return deliveryOrder;
	}

	public List<DeliveryOrderLine> getDeliveryOrderLines() {
		return this.deliveryOrderLines;
	}

	public void setDeliveryOrderLines(List<DeliveryOrderLine> deliveryOrderLines) {
		this.deliveryOrderLines = deliveryOrderLines;
	}

	public DeliveryOrderLine addDeliveryOrderLine(DeliveryOrderLine deliveryOrderLine) {
		getDeliveryOrderLines().add(deliveryOrderLine);
		deliveryOrderLine.setPartner(this);

		return deliveryOrderLine;
	}

	public DeliveryOrderLine removeDeliveryOrderLine(DeliveryOrderLine deliveryOrderLine) {
		getDeliveryOrderLines().remove(deliveryOrderLine);
		deliveryOrderLine.setPartner(null);

		return deliveryOrderLine;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setPartner(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setPartner(null);

		return invoice;
	}

	public List<InvoiceLine> getInvoiceLines() {
		return this.invoiceLines;
	}

	public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}

	public InvoiceLine addInvoiceLine(InvoiceLine invoiceLine) {
		getInvoiceLines().add(invoiceLine);
		invoiceLine.setPartner(this);

		return invoiceLine;
	}

	public InvoiceLine removeInvoiceLine(InvoiceLine invoiceLine) {
		getInvoiceLines().remove(invoiceLine);
		invoiceLine.setPartner(null);

		return invoiceLine;
	}

	public List<JournalEntry> getJournalEntries() {
		return this.journalEntries;
	}

	public void setJournalEntries(List<JournalEntry> journalEntries) {
		this.journalEntries = journalEntries;
	}

	public JournalEntry addJournalEntry(JournalEntry journalEntry) {
		getJournalEntries().add(journalEntry);
		journalEntry.setPartner(this);

		return journalEntry;
	}

	public JournalEntry removeJournalEntry(JournalEntry journalEntry) {
		getJournalEntries().remove(journalEntry);
		journalEntry.setPartner(null);

		return journalEntry;
	}

	public List<JournalItem> getJournalItems() {
		return this.journalItems;
	}

	public void setJournalItems(List<JournalItem> journalItems) {
		this.journalItems = journalItems;
	}

	public JournalItem addJournalItem(JournalItem journalItem) {
		getJournalItems().add(journalItem);
		journalItem.setPartner(this);

		return journalItem;
	}

	public JournalItem removeJournalItem(JournalItem journalItem) {
		getJournalItems().remove(journalItem);
		journalItem.setPartner(null);

		return journalItem;
	}

	public Account getAccountPayable() {
		return this.accountPayable;
	}

	public void setAccountPayable(Account accountPayable) {
		this.accountPayable = accountPayable;
	}

	public Account getAccountReceivable() {
		return this.accountReceivable;
	}

	public void setAccountReceivable(Account accountReceivable) {
		this.accountReceivable = accountReceivable;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setPartner(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setPartner(null);

		return payment;
	}

	public List<PurchaseOrder> getPurchaseOrders() {
		return this.purchaseOrders;
	}

	public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder) {
		getPurchaseOrders().add(purchaseOrder);
		purchaseOrder.setPartner(this);

		return purchaseOrder;
	}

	public PurchaseOrder removePurchaseOrder(PurchaseOrder purchaseOrder) {
		getPurchaseOrders().remove(purchaseOrder);
		purchaseOrder.setPartner(null);

		return purchaseOrder;
	}

	public List<SaleOrder> getSaleOrders() {
		return this.saleOrders;
	}

	public void setSaleOrders(List<SaleOrder> saleOrders) {
		this.saleOrders = saleOrders;
	}

	public SaleOrder addSaleOrder(SaleOrder saleOrder) {
		getSaleOrders().add(saleOrder);
		saleOrder.setPartner(this);

		return saleOrder;
	}

	public SaleOrder removeSaleOrder(SaleOrder saleOrder) {
		getSaleOrders().remove(saleOrder);
		saleOrder.setPartner(null);

		return saleOrder;
	}

}