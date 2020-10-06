package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manguoidung")
	private NguoiDung NguoiDung;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name = "masanbong")
	private SanBong SanBong;

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


	public NguoiDung getNguoiDung() {
		return NguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		NguoiDung = nguoiDung;
	}

	public SanBong getSanBong() {
		return SanBong;
	}

	public void setSanBong(SanBong sanBong) {
		SanBong = sanBong;
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
		return "KhachSanBong [maKhach_sanbong=" + maKhach_sanbong + ", NguoiDung=" + NguoiDung + ", SanBong=" + SanBong
				+ ", thoiGian=" + thoiGian + ", thanhTien=" + thanhTien + ", tienCoc=" + tienCoc + ", trangThai="
				+ trangThai + "]";
	}



}
