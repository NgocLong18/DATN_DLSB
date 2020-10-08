package com.example.demo.controller;

import com.example.demo.IRepository.INguoiDungRepository;
import com.example.demo.IRepository.ISanBongRepository;
import com.example.demo.model.NguoiDung;
import com.example.demo.model.SanBong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class QuanlySanController {
    @Autowired
    ISanBongRepository sangbongService;
    @Autowired
    INguoiDungRepository nguoidungservice;

    @GetMapping("/manager")//hiển thị form login dành cho quản lý
    public ModelAndView saveStaffs(Model model){
        ModelAndView modelAndView = new ModelAndView("loginformanager");
        modelAndView.addObject("nguoidung", new NguoiDung());
        return modelAndView;
    }

    @PostMapping("/manager")// thực hiện action login
    public ModelAndView login(@ModelAttribute("nguoidung")NguoiDung nguoiDung, @RequestParam("email") String email, @RequestParam("matKhau") String matKhau) {
        List<NguoiDung> list = nguoidungservice.findAll();
        for (NguoiDung nguoiDung1 : list){
            if(email.equalsIgnoreCase(nguoiDung1.getEmail()) && matKhau.equalsIgnoreCase(nguoiDung1.getMatKhau()) && nguoiDung1.getMaVaiTro().equalsIgnoreCase("2") ){
                ModelAndView modelAndView = new ModelAndView("quanly/redirect" );
                return modelAndView ;
            }
        }
        ModelAndView modelAndView = new ModelAndView("quanly/loginformanager" );
        modelAndView.addObject("message", "Bạn không có quyền hạn truy cập");
        return modelAndView;
    }

    @GetMapping("/sanbong")//hiển thị trang quản lý sân bóng
    public String reddirectSanBong(Model model){
        model.addAttribute("listSanBong",sangbongService.findAll());
        List<SanBong> list = sangbongService.findAll();
        return "quanly/sanbong";
    }

    @GetMapping("/chitiet/{maSanBong}")//chi tiết sân bóng khi click vào link
    public ModelAndView editStaffs(@PathVariable Long maSanBong){
        Optional<SanBong> sanbong= sangbongService.findById(maSanBong);
        ModelAndView modelAndView = new ModelAndView("/quanly/chitietsan");
        modelAndView.addObject("sanbong", sanbong );
        return modelAndView;
    }

}
