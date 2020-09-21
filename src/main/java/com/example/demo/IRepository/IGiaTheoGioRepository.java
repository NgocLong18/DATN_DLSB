package com.example.demo.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.GiaTheoGio;

@Repository
public interface IGiaTheoGioRepository extends JpaRepository<GiaTheoGio, Long> {

}
