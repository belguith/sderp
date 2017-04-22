package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the delivery_order database table.
 * 
 */
@Entity
@Table(name="delivery_order")
@NamedQuery(name="DeliveryOrder.findAll", query="SELECT d FROM DeliveryOrder d")
public class DeliveryOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Boolean active;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name="delivery_method")
	private String deliveryMethod;

	private String name;

	private String origin;

	private String state;

	private String type;

	//bi-directional many-to-one association to DeliveryOrder
	@ManyToOne
	@JoinColumn(name="back_order_id")
	private DeliveryOrder backOrder;

	//bi-directional many-to-one association to DeliveryOrder
	@OneToMany(mappedBy="backOrder", fetch=FetchType.EAGER)
	private List<DeliveryOrder> deliveryOrders;

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

	//bi-directional many-to-one association to DeliveryOrderLine
	@OneToMany(mappedBy="deliveryOrder", fetch=FetchType.EAGER)
	private List<DeliveryOrderLine> deliveryOrderLines;

	public DeliveryOrder() {
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

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDeliveryMethod() {
		return this.deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DeliveryOrder getBackOrder() {
		return this.backOrder;
	}

	public void setBackOrder(DeliveryOrder backOrder) {
		this.backOrder = backOrder;
	}

	public List<DeliveryOrder> getDeliveryOrders() {
		return this.deliveryOrders;
	}

	public void setDeliveryOrders(List<DeliveryOrder> deliveryOrders) {
		this.deliveryOrders = deliveryOrders;
	}

	public DeliveryOrder addDeliveryOrder(DeliveryOrder deliveryOrder) {
		getDeliveryOrders().add(deliveryOrder);
		deliveryOrder.setBackOrder(this);

		return deliveryOrder;
	}

	public DeliveryOrder removeDeliveryOrder(DeliveryOrder deliveryOrder) {
		getDeliveryOrders().remove(deliveryOrder);
		deliveryOrder.setBackOrder(null);

		return deliveryOrder;
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

	public List<DeliveryOrderLine> getDeliveryOrderLines() {
		return this.deliveryOrderLines;
	}

	public void setDeliveryOrderLines(List<DeliveryOrderLine> deliveryOrderLines) {
		this.deliveryOrderLines = deliveryOrderLines;
	}

	public DeliveryOrderLine addDeliveryOrderLine(DeliveryOrderLine deliveryOrderLine) {
		getDeliveryOrderLines().add(deliveryOrderLine);
		deliveryOrderLine.setDeliveryOrder(this);

		return deliveryOrderLine;
	}

	public DeliveryOrderLine removeDeliveryOrderLine(DeliveryOrderLine deliveryOrderLine) {
		getDeliveryOrderLines().remove(deliveryOrderLine);
		deliveryOrderLine.setDeliveryOrder(null);

		return deliveryOrderLine;
	}

}