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
@Table(name = "khach_sanbong")
public class KhachSanBong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="makhach_sanbong")
	private long maKhach_sanbong;
	@Column(name = "manguoidung")
	private int maNguoiDung;
	@Column(name = "masanbong")
	private int maSanBong;
	@Column(name = "thoigian")
	private String thoiGian;
	@Column(name = "thanhtien")
	private int thanhTien;
	@Column(name = "tiencoc")
	private int tienCoc;
	@Column(name = "trangthai")
	private int trangThai;

	public long getMaKhach_sanbong() {
		return maKhach_sanbong;
	}

	public void setMaKhach_sanbong(long maKhach_sanbong) {
		this.maKhach_sanbong = maKhach_sanbong;
	}

	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public int getMaSanBong() {
		return maSanBong;
	}

	public void setMaSanBong(int maSanBong) {
		this.maSanBong = maSanBong;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public int getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

	public int getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(int tienCoc) {
		this.tienCoc = tienCoc;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "KhachSanBong [maKhach_sanbong=" + maKhach_sanbong + ", maNguoiDung=" + maNguoiDung + ", maSanBong="
				+ maSanBong + ", thoiGian=" + thoiGian + ", thanhTien=" + thanhTien + ", tienCoc=" + tienCoc
				+ ", trangThai=" + trangThai + "]";
	}

}
