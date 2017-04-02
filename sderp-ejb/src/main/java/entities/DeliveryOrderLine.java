package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the delivery_order_line database table.
 * 
 */
@Entity
@Table(name="delivery_order_line")
@NamedQuery(name="DeliveryOrderLine.findAll", query="SELECT d FROM DeliveryOrderLine d")
public class DeliveryOrderLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Byte active;

	private Double price;

	private Double quantity;

	private Double reserved;

	private String state;

	private String type;

	private String uom;

	//bi-directional many-to-one association to DeliveryOrder
	@ManyToOne
	@JoinColumn(name="delivery_id")
	private DeliveryOrder deliveryOrder;

	//bi-directional many-to-one association to Partner
	@ManyToOne
	private Partner partner;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public DeliveryOrderLine() {
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

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getReserved() {
		return this.reserved;
	}

	public void setReserved(Double reserved) {
		this.reserved = reserved;
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

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public DeliveryOrder getDeliveryOrder() {
		return this.deliveryOrder;
	}

	public void setDeliveryOrder(DeliveryOrder deliveryOrder) {
		this.deliveryOrder = deliveryOrder;
	}

	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}