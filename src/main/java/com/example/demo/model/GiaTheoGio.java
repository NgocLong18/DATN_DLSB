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
@Table(name = "giatheogio")
public class GiaTheoGio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "magiatheogio")
	private long maGiaTheoGio;
	@Column(name = "tilegio")
	private float tiLeGio;
	@Column(name = "tilengay")
	private float tiLeNgay;

	public long getMaGiaTheoGio() {
		return maGiaTheoGio;
	}

	public void setMaGiaTheoGio(long maGiaTheoGio) {
		this.maGiaTheoGio = maGiaTheoGio;
	}

	public float getTiLeGio() {
		return tiLeGio;
	}

	public void setTiLeGio(float tiLeGio) {
		this.tiLeGio = tiLeGio;
	}

	public float getTiLeNgay() {
		return tiLeNgay;
	}

	public void setTiLeNgay(float tiLeNgay) {
		this.tiLeNgay = tiLeNgay;
	}

	@Override
	public String toString() {
		return "GiaTheoGio [maGiaTheoGio=" + maGiaTheoGio + ", tiLeGio=" + tiLeGio + ", tiLeNgay=" + tiLeNgay + "]";
	}

	
}
