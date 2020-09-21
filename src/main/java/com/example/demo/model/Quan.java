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
@Table(name = "quan")
public class Quan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maquan")
	private long maQuan;
	@Column(name = "tenquan")
	private String tenQuan;

	public long getMaQuan() {
		return maQuan;
	}

	public void setMaQuan(long maQuan) {
		this.maQuan = maQuan;
	}

	public String getTenQuan() {
		return tenQuan;
	}

	public void setTenQuan(String tenQuan) {
		this.tenQuan = tenQuan;
	}

	@Override
	public String toString() {
		return "Quan [maQuan=" + maQuan + ", tenQuan=" + tenQuan + "]";
	}

}
