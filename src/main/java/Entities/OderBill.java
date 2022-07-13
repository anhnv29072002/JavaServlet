package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the oder_bill database table.
 * 
 */
@Entity
@Table(name = "oder_bill")
@NamedQuery(name = "OderBill.findAll", query = "SELECT o FROM OderBill o")
public class OderBill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "don_gia")
	private double donGia;

	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "so_luong")
	private int soLuong;

	private String status;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "ngay_dat")
	private Date ngayDat;

	public OderBill() {
	}

	public OderBill(Product product, User user, String status, int soLuong, double donGia, Date ngayDat) {
		super();
		this.donGia = donGia;
		this.product = product;
		this.soLuong = soLuong;
		this.status = status;
		this.user = user;
		this.ngayDat = ngayDat;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDonGia() {
		return this.donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

}