package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the oders database table.
 * 
 */
@Entity
@Table(name="oders")
@NamedQuery(name="Oder.findAll", query="SELECT o FROM Oder o")
public class Oder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany
	@JoinColumn(name="cart_id")
	private List<Cart> cart;

	private String status;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Oder() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public double getSumMoney() {
		double sum = 0;
		for(int i = 0; i < this.cart.size(); i++) {
			sum += this.cart.get(i).getSoLuong() * this.getCart().get(i).getProduct().getDonGia();
		}
		return sum;
	}

}