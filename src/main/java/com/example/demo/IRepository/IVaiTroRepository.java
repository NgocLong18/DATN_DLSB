package com.example.demo.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.VaiTro;

@Repository
public interface IVaiTroRepository extends JpaRepository<VaiTro, Long> {

}
