package Dao;

import java.util.ArrayList;
import java.util.List;

import Entities.Cart;
import Entities.Product;

public class CartDao {

	private List<Cart> lstCart;

	public CartDao() {
		this.lstCart = new ArrayList<Cart>();
	}

	public List<Cart> getAll() {
		return lstCart;
	}

	public void setLstCart(List<Cart> lstCart) {
		this.lstCart = lstCart;
	}

	public void insert(Cart c) {
		this.lstCart.add(c);
	}

	public void update(Cart c) {
		for (int i = 0; i < this.lstCart.size(); i++) {
			if (this.lstCart.get(i).getProduct().getId() == c.getProduct().getId()) {
				this.lstCart.set(i, c);
			}
		}
	}

	public Cart findById(Product p) {
		for (Cart cart : this.lstCart) {
			if (cart.getProduct().getId() == p.getId()) {
				return cart;
			}
		}
		return null;
	}

	public void delete(Product p) {
		Cart cart = this.findById(p);
		if (cart != null) {
			this.lstCart.remove(cart);
		}
	}

}
