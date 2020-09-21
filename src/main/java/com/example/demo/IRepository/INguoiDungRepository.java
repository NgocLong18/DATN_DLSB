package com.example.demo.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NguoiDung;

@Repository
public interface INguoiDungRepository extends JpaRepository<NguoiDung, Long> {

}
