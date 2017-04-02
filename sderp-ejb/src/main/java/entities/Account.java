package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Byte active;

	private String code;

	private String name;

	private String title;

	private String type;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="account", fetch=FetchType.EAGER)
	private List<Invoice> invoices;

	//bi-directional many-to-one association to InvoiceLine
	@OneToMany(mappedBy="account", fetch=FetchType.EAGER)
	private List<InvoiceLine> invoiceLines;

	//bi-directional many-to-one association to InvoiceTax
	@OneToMany(mappedBy="account", fetch=FetchType.EAGER)
	private List<InvoiceTax> invoiceTaxs;

	//bi-directional many-to-one association to JournalItem
	@OneToMany(mappedBy="account", fetch=FetchType.EAGER)
	private List<JournalItem> journalItems;

	//bi-directional many-to-one association to Partner
	@OneToMany(mappedBy="accountPayable", fetch=FetchType.EAGER)
	private List<Partner> partnersPayable;

	//bi-directional many-to-one association to Partner
	@OneToMany(mappedBy="accountReceivable", fetch=FetchType.EAGER)
	private List<Partner> partnersReceivable;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="account", fetch=FetchType.EAGER)
	private List<Payment> payments;

	public Account() {
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setAccount(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setAccount(null);

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
		invoiceLine.setAccount(this);

		return invoiceLine;
	}

	public InvoiceLine removeInvoiceLine(InvoiceLine invoiceLine) {
		getInvoiceLines().remove(invoiceLine);
		invoiceLine.setAccount(null);

		return invoiceLine;
	}

	public List<InvoiceTax> getInvoiceTaxs() {
		return this.invoiceTaxs;
	}

	public void setInvoiceTaxs(List<InvoiceTax> invoiceTaxs) {
		this.invoiceTaxs = invoiceTaxs;
	}

	public InvoiceTax addInvoiceTax(InvoiceTax invoiceTax) {
		getInvoiceTaxs().add(invoiceTax);
		invoiceTax.setAccount(this);

		return invoiceTax;
	}

	public InvoiceTax removeInvoiceTax(InvoiceTax invoiceTax) {
		getInvoiceTaxs().remove(invoiceTax);
		invoiceTax.setAccount(null);

		return invoiceTax;
	}

	public List<JournalItem> getJournalItems() {
		return this.journalItems;
	}

	public void setJournalItems(List<JournalItem> journalItems) {
		this.journalItems = journalItems;
	}

	public JournalItem addJournalItem(JournalItem journalItem) {
		getJournalItems().add(journalItem);
		journalItem.setAccount(this);

		return journalItem;
	}

	public JournalItem removeJournalItem(JournalItem journalItem) {
		getJournalItems().remove(journalItem);
		journalItem.setAccount(null);

		return journalItem;
	}

	public List<Partner> getPartnersPayable() {
		return this.partnersPayable;
	}

	public void setPartnersPayable(List<Partner> partnersPayable) {
		this.partnersPayable = partnersPayable;
	}

	public Partner addPartnersPayable(Partner partnersPayable) {
		getPartnersPayable().add(partnersPayable);
		partnersPayable.setAccountPayable(this);

		return partnersPayable;
	}

	public Partner removePartnersPayable(Partner partnersPayable) {
		getPartnersPayable().remove(partnersPayable);
		partnersPayable.setAccountPayable(null);

		return partnersPayable;
	}

	public List<Partner> getPartnersReceivable() {
		return this.partnersReceivable;
	}

	public void setPartnersReceivable(List<Partner> partnersReceivable) {
		this.partnersReceivable = partnersReceivable;
	}

	public Partner addPartnersReceivable(Partner partnersReceivable) {
		getPartnersReceivable().add(partnersReceivable);
		partnersReceivable.setAccountReceivable(this);

		return partnersReceivable;
	}

	public Partner removePartnersReceivable(Partner partnersReceivable) {
		getPartnersReceivable().remove(partnersReceivable);
		partnersReceivable.setAccountReceivable(null);

		return partnersReceivable;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setAccount(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setAccount(null);

		return payment;
	}

}