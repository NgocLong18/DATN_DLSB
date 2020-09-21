package com.example.demo.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Quan;

@Repository
public interface IQuanRepository extends JpaRepository<Quan, Long> {

}
