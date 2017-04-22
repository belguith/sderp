package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tax database table.
 * 
 */
@Entity
@NamedQuery(name="Tax.findAll", query="SELECT t FROM Tax t")
public class Tax implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Boolean active;

	private Double amount;

	private String name;

	private Double percent;

	@Column(name="type_tax_use")
	private String typeTaxUse;

	//bi-directional many-to-one association to InvoiceLine
	@OneToMany(mappedBy="tax", fetch=FetchType.EAGER)
	private List<InvoiceLine> invoiceLines;

	//bi-directional many-to-one association to InvoiceTax
	@OneToMany(mappedBy="tax", fetch=FetchType.EAGER)
	private List<InvoiceTax> invoiceTaxs;

	//bi-directional many-to-one association to JournalItem
	@OneToMany(mappedBy="tax", fetch=FetchType.EAGER)
	private List<JournalItem> journalItems;

	//bi-directional many-to-one association to PurchaseOrderLine
	@OneToMany(mappedBy="tax", fetch=FetchType.EAGER)
	private List<PurchaseOrderLine> purchaseOrderLines;

	//bi-directional many-to-one association to SaleOrderLine
	@OneToMany(mappedBy="tax", fetch=FetchType.EAGER)
	private List<SaleOrderLine> saleOrderLines;

	public Tax() {
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

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPercent() {
		return this.percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

	public String getTypeTaxUse() {
		return this.typeTaxUse;
	}

	public void setTypeTaxUse(String typeTaxUse) {
		this.typeTaxUse = typeTaxUse;
	}

	public List<InvoiceLine> getInvoiceLines() {
		return this.invoiceLines;
	}

	public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}

	public InvoiceLine addInvoiceLine(InvoiceLine invoiceLine) {
		getInvoiceLines().add(invoiceLine);
		invoiceLine.setTax(this);

		return invoiceLine;
	}

	public InvoiceLine removeInvoiceLine(InvoiceLine invoiceLine) {
		getInvoiceLines().remove(invoiceLine);
		invoiceLine.setTax(null);

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
		invoiceTax.setTax(this);

		return invoiceTax;
	}

	public InvoiceTax removeInvoiceTax(InvoiceTax invoiceTax) {
		getInvoiceTaxs().remove(invoiceTax);
		invoiceTax.setTax(null);

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
		journalItem.setTax(this);

		return journalItem;
	}

	public JournalItem removeJournalItem(JournalItem journalItem) {
		getJournalItems().remove(journalItem);
		journalItem.setTax(null);

		return journalItem;
	}

	public List<PurchaseOrderLine> getPurchaseOrderLines() {
		return this.purchaseOrderLines;
	}

	public void setPurchaseOrderLines(List<PurchaseOrderLine> purchaseOrderLines) {
		this.purchaseOrderLines = purchaseOrderLines;
	}

	public PurchaseOrderLine addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		getPurchaseOrderLines().add(purchaseOrderLine);
		purchaseOrderLine.setTax(this);

		return purchaseOrderLine;
	}

	public PurchaseOrderLine removePurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		getPurchaseOrderLines().remove(purchaseOrderLine);
		purchaseOrderLine.setTax(null);

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
		saleOrderLine.setTax(this);

		return saleOrderLine;
	}

	public SaleOrderLine removeSaleOrderLine(SaleOrderLine saleOrderLine) {
		getSaleOrderLines().remove(saleOrderLine);
		saleOrderLine.setTax(null);

		return saleOrderLine;
	}

}