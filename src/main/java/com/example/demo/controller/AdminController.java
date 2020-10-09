package com.example.demo.controller;

import com.example.demo.IRepository.INguoiDungRepository;
import com.example.demo.IRepository.ISanBongRepository;
import com.example.demo.model.NguoiDung;
import com.example.demo.model.SanBong;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    INguoiDungRepository nguoidungservice;
    @Autowired
    ISanBongRepository sanbnongservice;

    @GetMapping("/dsquanly")//hiển thị danh sách quản lý
    public String listQuanly(Model model) {
        List<NguoiDung> list = nguoidungservice.findAll();
        List<NguoiDung> listquanly = new ArrayList<NguoiDung>();
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getMaVaiTro()).equalsIgnoreCase("2")) {
                listquanly.add(list.get(i));
            }
        }
        model.addAttribute("listquanly", listquanly);
        System.out.println("");
        return "admin/dsquanly";
    }

    //Phần đăng ký cho quản lý mới
    @GetMapping("/themquanly")//hiển thị form đăng ký cho quản lý mới
    public ModelAndView savemanage(Model model) {
        ModelAndView modelAndView = new ModelAndView("admin/themquanly");
        modelAndView.addObject("nguoidung", new NguoiDung());
        return modelAndView;
    }

    @PostMapping("/themquanly")//thực hiện action form đăng  ký quản lý mới, thay chỉ cho những thông tin cần thiết
    public ModelAndView savemanage(@ModelAttribute("nguoidung") NguoiDung nguoiDung) {
        nguoiDung.setMaVaiTro("2");
        nguoiDung.setMatKhau("123");
        nguoiDung.setTrangThai("active");
        nguoidungservice.save(nguoiDung);
        ModelAndView modelAndView = new ModelAndView("admin/themquanly");
        modelAndView.addObject("message", "Lưu thành công");
        return  modelAndView;
    }




}
