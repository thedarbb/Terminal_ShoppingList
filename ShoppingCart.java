import java.io.Serializable;
import java.math.BigDecimal;

public class ShoppingCart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String item;
	private BigDecimal price;
	private int qty;
	
	public ShoppingCart(String item, BigDecimal price, int qty) {
		super();
		this.item = item;
		this.price = price;
		this.qty = qty;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String toString(){
		return "Item: " + item + " Price: " + price + " Quantity: " + qty;
	}
	
}
