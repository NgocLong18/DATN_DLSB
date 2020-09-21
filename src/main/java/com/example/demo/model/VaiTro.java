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
@Table(name = "vaitro")
public class VaiTro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mavaitro")
	private long maVaiTro;
	@Column(name = "tenvaitro")
	private String tenVaitro;
	@Column(name = "trangthai")
	private String trangThai;

	public long getMaVaiTro() {
		return maVaiTro;
	}

	public void setMaVaiTro(long maVaiTro) {
		this.maVaiTro = maVaiTro;
	}

	public String getTenVaitro() {
		return tenVaitro;
	}

	public void setTenVaitro(String tenVaitro) {
		this.tenVaitro = tenVaitro;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "VaiTro [maVaiTro=" + maVaiTro + ", tenVaitro=" + tenVaitro + ", trangThai=" + trangThai + "]";
	}
	
	

}
