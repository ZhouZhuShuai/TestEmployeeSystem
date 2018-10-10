package Entity;

public class Order2 {
	private int id;
	private int order1_id;
	private Product product;
	private int order2_xiaoji;
	private int order2_product_count;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder1_id() {
		return order1_id;
	}
	public void setOrder1_id(int order1_id) {
		this.order1_id = order1_id;
	}
	public int getOrder2_xiaoji() {
		return order2_xiaoji;
	}
	public void setOrder2_xiaoji(int order2_xiaoji) {
		this.order2_xiaoji = order2_xiaoji;
	}
	public int getOrder2_product_count() {
		return order2_product_count;
	}
	public void setOrder2_product_count(int order2_product_count) {
		this.order2_product_count = order2_product_count;
	}
	
}
