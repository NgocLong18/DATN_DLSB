package com.example.demo.controller;

import com.example.demo.IRepository.INguoiDungRepository;
import com.example.demo.model.NguoiDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Register {
    @Autowired
    INguoiDungRepository serviceNguoiDung;
    //hien thi form dang ky
    @GetMapping("/dangky")
    public ModelAndView saveStaffs(Model model){
        ModelAndView modelAndView = new ModelAndView("dangky");
        modelAndView.addObject("nguoidung", new NguoiDung());
        return modelAndView;
    }
    //thuc hien form dang ky
    @PostMapping("/dangky")
    public ModelAndView dangKy(@ModelAttribute("nguoidung")NguoiDung nguoiDung, @RequestParam("email")String email, @RequestParam("matKhau")String matKhau){
        NguoiDung nguoiDungDangKy = new NguoiDung(email, matKhau,"1", "active");
        serviceNguoiDung.save(nguoiDungDangKy);
        ModelAndView modelAndView = new ModelAndView("dangky");
        modelAndView.addObject("message", "Bạn đã đăng ký thàng công!");
        return modelAndView;
    }

}
