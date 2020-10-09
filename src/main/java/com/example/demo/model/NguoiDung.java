package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "nguoidung")
public class NguoiDung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name ="manguoidung")
	private long maNguoiDung;
	@Column(name = "email")
	private String email;
	@Column(name = "matkhau")
	private String matKhau;
	@Column(name = "tennguoidung")
	private String tenNguoiDung;
	@Column(name = "anh")
	private String anh;
	@Column(name = "sodienthoai")
	private String soDienThoai;
	@Column(name = "sodienthoai1")
	private String soDienThoai1;
	@Column(name = "diachi")
	private String diaChi;
	@Column(name = "mavaitro")
	private String maVaiTro;
	@Column(name = "trangthai")
	private String trangThai;

	public NguoiDung(String email, String matKhau, String maVaiTro, String trangThai ){
		this.email = email;
		this.matKhau = matKhau;
		this.maVaiTro = maVaiTro;
		this.trangThai = trangThai;
	}

	public NguoiDung(String email, String matKhau, String tenNguoiDung, String soDienThoai, String soDienThoai1, String diaChi, String maVaiTro, String trangThai){
		this.email= email;
		this.matKhau = matKhau;
		this.tenNguoiDung= tenNguoiDung;
		this.soDienThoai = soDienThoai;
		this.soDienThoai1 = soDienThoai1;
		this.diaChi = diaChi;
		this.maVaiTro = maVaiTro;
		this.trangThai = trangThai;
	}
	public NguoiDung(Long maNguoiDung, String email, String matKhau, String tenNguoiDung, String soDienThoai, String soDienThoai1, String diaChi, String maVaiTro, String trangThai){
		this.maNguoiDung = maNguoiDung;
		this.email= email;
		this.matKhau = matKhau;
		this.tenNguoiDung= tenNguoiDung;
		this.soDienThoai = soDienThoai;
		this.soDienThoai1 = soDienThoai1;
		this.diaChi = diaChi;
		this.maVaiTro = maVaiTro;
		this.trangThai = trangThai;
	}
	public NguoiDung(){

	}

	public long getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(long maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMaVaiTro() {
		return maVaiTro;
	}

	public void setMaVaiTro(String maVaiTro) {
		this.maVaiTro = maVaiTro;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getSoDienThoai1() {
		return soDienThoai1;
	}

	public void setSoDienThoai1(String soDienThoai1) {
		this.soDienThoai1 = soDienThoai1;
	}
}
