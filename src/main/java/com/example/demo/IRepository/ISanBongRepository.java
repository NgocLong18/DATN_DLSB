package com.example.demo.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SanBong;

@Repository
public interface ISanBongRepository extends JpaRepository<SanBong, Long> {

}
