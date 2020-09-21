package com.example.demo.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.KhachSanBong;

@Repository
public interface IKhachSanBongRepository extends JpaRepository<KhachSanBong, Long> {

}
