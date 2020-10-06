package com.example.demo.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "sanbong")
public class SanBong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "masanbong")
	private long maSanBong;
	@Column(name = "tensanbong")
	private String tenSanbong;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maquan")
	private Quan quan;

	@Column(name = "diachi")
	private String diaChi;
	@Column(name = "giaca")
	private int giaCa;


	@Column(name = "thoigianmo")
	private String thoigianmo;

	@Column(name = "thoigiandong")
	private String thoigiandong;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manguoidung")
	private NguoiDung nguoiDung;

	@Column(name = "kinhdo")
	private float kinhDo;
	@Column(name = "vido")
	private float viDo;

	@Column(name = "anhsanbong")
	private String anhSanBong;
	@Column(name = "khuyenmai")
	private float khuyenMai;
	@Column(name = "trangthai")
	private String trangThai;





	public long getMaSanBong() {
		return maSanBong;
	}

	public void setMaSanBong(long maSanBong) {
		this.maSanBong = maSanBong;
	}

	public String getTenSanbong() {
		return tenSanbong;
	}

	public void setTenSanbong(String tenSanbong) {
		this.tenSanbong = tenSanbong;
	}

	public Quan getQuan() {
		return quan;
	}

	public void setQuan(Quan quan) {
		this.quan = quan;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getGiaCa() {
		return giaCa;
	}

	public void setGiaCa(int giaCa) {
		this.giaCa = giaCa;
	}

	public String getThoigianmo() {
		return thoigianmo;
	}

	public void setThoigianmo(String thoigianmo) {
		this.thoigianmo = thoigianmo;
	}

	public String getThoigiandong() {
		return thoigiandong;
	}

	public void setThoigiandong(String thoigiandong) {
		this.thoigiandong = thoigiandong;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public float getKinhDo() {
		return kinhDo;
	}

	public void setKinhDo(float kinhDo) {
		this.kinhDo = kinhDo;
	}

	public float getViDo() {
		return viDo;
	}

	public void setViDo(float viDo) {
		this.viDo = viDo;
	}

	public String getAnhSanBong() {
		return anhSanBong;
	}

	public void setAnhSanBong(String anhSanBong) {
		this.anhSanBong = anhSanBong;
	}

	public float getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(float khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
}
