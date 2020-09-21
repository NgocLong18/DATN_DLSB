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
@Table(name = "sanbong")
public class SanBong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "masanbong")
	private long maSanBong;
	@Column(name = "tensanbong")
	private String tenSanbong;
	@Column(name = "maquan")
	private int maQuan;
	@Column(name = "diachi")
	private String diaChi;
	@Column(name = "giaca")
	private int giaCa;
	@Column(name = "magiatheogio")
	private int maGiaTheoGio;
	@Column(name = "manguoidung")
	private int maNguoiDung;
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

	public int getMaQuan() {
		return maQuan;
	}

	public void setMaQuan(int maQuan) {
		this.maQuan = maQuan;
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

	public int getMaGiaTheoGio() {
		return maGiaTheoGio;
	}

	public void setMaGiaTheoGio(int maGiaTheoGio) {
		this.maGiaTheoGio = maGiaTheoGio;
	}

	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
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

	@Override
	public String toString() {
		return "SanBong [maSanBong=" + maSanBong + ", tenSanbong=" + tenSanbong + ", maQuan=" + maQuan + ", diaChi="
				+ diaChi + ", giaCa=" + giaCa + ", maGiaTheoGio=" + maGiaTheoGio + ", maNguoiDung=" + maNguoiDung
				+ ", kinhDo=" + kinhDo + ", viDo=" + viDo + ", anhSanBong=" + anhSanBong + ", khuyenMai=" + khuyenMai
				+ ", trangThai=" + trangThai + "]";
	}

}
