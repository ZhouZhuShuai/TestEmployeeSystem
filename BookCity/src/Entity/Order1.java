package Entity;

import java.sql.Timestamp;
import java.util.List;

public class Order1 {
	private int id;
	private String order_no;
	private int user_id;
	private Integer payment;
	private int order1_product_count;
	private Adress adress;
	private Timestamp payment_time;
	private List<Order2> order2List;
	
	public List<Order2> getOrder2List() {
		return order2List;
	}
	public void setOrder2List(List<Order2> order2List) {
		this.order2List = order2List;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Integer getPayment() {
		return payment;
	}
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
	public int getOrder1_product_count() {
		return order1_product_count;
	}
	public void setOrder1_product_count(int order1_product_count) {
		this.order1_product_count = order1_product_count;
	}
	
	public Timestamp getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(Timestamp payment_time2) {
		this.payment_time = payment_time2;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	

}
