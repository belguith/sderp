package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
public class Invoice implements Serializable {
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

	@Lob
	private String comment;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String name;

	private String number;

	private String origin;

	private String reference;

	private Double residual;

	private String state;

	@Column(name="supplier_invoice_number")
	private String supplierInvoiceNumber;

	private String type;

	//bi-directional many-to-one association to Account
	@ManyToOne
	private Account account;

	//bi-directional many-to-one association to Journal
	@ManyToOne
	private Journal journal;

	//bi-directional many-to-one association to JournalEntry
	@ManyToOne
	@JoinColumn(name="entry_id")
	private JournalEntry journalEntry;

	//bi-directional many-to-one association to Partner
	@ManyToOne
	private Partner partner;

	//bi-directional many-to-one association to PurchaseOrder
	@ManyToOne
	@JoinColumn(name="purchase_id")
	private PurchaseOrder purchaseOrder;

	//bi-directional many-to-one association to SaleOrder
	@ManyToOne
	@JoinColumn(name="sale_id")
	private SaleOrder saleOrder;

	//bi-directional many-to-one association to InvoiceLine
	@OneToMany(mappedBy="invoice", fetch=FetchType.EAGER)
	private List<InvoiceLine> invoiceLines;

	//bi-directional many-to-one association to InvoicePayment
	@OneToMany(mappedBy="invoice", fetch=FetchType.EAGER)
	private List<InvoicePayment> invoicePayments;

	//bi-directional many-to-one association to InvoiceTax
	@OneToMany(mappedBy="invoice", fetch=FetchType.EAGER)
	private List<InvoiceTax> invoiceTaxs;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="invoice", fetch=FetchType.EAGER)
	private List<Payment> payments;

	public Invoice() {
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

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Double getResidual() {
		return this.residual;
	}

	public void setResidual(Double residual) {
		this.residual = residual;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSupplierInvoiceNumber() {
		return this.supplierInvoiceNumber;
	}

	public void setSupplierInvoiceNumber(String supplierInvoiceNumber) {
		this.supplierInvoiceNumber = supplierInvoiceNumber;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Journal getJournal() {
		return this.journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	public JournalEntry getJournalEntry() {
		return this.journalEntry;
	}

	public void setJournalEntry(JournalEntry journalEntry) {
		this.journalEntry = journalEntry;
	}

	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public PurchaseOrder getPurchaseOrder() {
		return this.purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public SaleOrder getSaleOrder() {
		return this.saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	public List<InvoiceLine> getInvoiceLines() {
		return this.invoiceLines;
	}

	public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}

	public InvoiceLine addInvoiceLine(InvoiceLine invoiceLine) {
		getInvoiceLines().add(invoiceLine);
		invoiceLine.setInvoice(this);

		return invoiceLine;
	}

	public InvoiceLine removeInvoiceLine(InvoiceLine invoiceLine) {
		getInvoiceLines().remove(invoiceLine);
		invoiceLine.setInvoice(null);

		return invoiceLine;
	}

	public List<InvoicePayment> getInvoicePayments() {
		return this.invoicePayments;
	}

	public void setInvoicePayments(List<InvoicePayment> invoicePayments) {
		this.invoicePayments = invoicePayments;
	}

	public InvoicePayment addInvoicePayment(InvoicePayment invoicePayment) {
		getInvoicePayments().add(invoicePayment);
		invoicePayment.setInvoice(this);

		return invoicePayment;
	}

	public InvoicePayment removeInvoicePayment(InvoicePayment invoicePayment) {
		getInvoicePayments().remove(invoicePayment);
		invoicePayment.setInvoice(null);

		return invoicePayment;
	}

	public List<InvoiceTax> getInvoiceTaxs() {
		return this.invoiceTaxs;
	}

	public void setInvoiceTaxs(List<InvoiceTax> invoiceTaxs) {
		this.invoiceTaxs = invoiceTaxs;
	}

	public InvoiceTax addInvoiceTax(InvoiceTax invoiceTax) {
		getInvoiceTaxs().add(invoiceTax);
		invoiceTax.setInvoice(this);

		return invoiceTax;
	}

	public InvoiceTax removeInvoiceTax(InvoiceTax invoiceTax) {
		getInvoiceTaxs().remove(invoiceTax);
		invoiceTax.setInvoice(null);

		return invoiceTax;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setInvoice(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setInvoice(null);

		return payment;
	}

}