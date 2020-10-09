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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class QuanlySanController {
    int maQuanLy = 0;
    @Autowired
    ISanBongRepository sanbongService;
    @Autowired
    INguoiDungRepository nguoidungservice;

    @GetMapping("/manager")//hiển thị form login dành cho quản lý
    public ModelAndView loginformanager(Model model){
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
                maQuanLy = (int) nguoiDung1.getMaNguoiDung();
                return modelAndView ;
            }
        }
        ModelAndView modelAndView = new ModelAndView("loginformanager" );
        modelAndView.addObject("message", "Bạn không có quyền hạn truy cập");
        return modelAndView;
    }

    @GetMapping("/sanbong")//hiển thị trang quản lý sân bóng
    public ModelAndView reddirectSanBong(Model model){
        if (maQuanLy == 0) {
            ModelAndView modelAndView = new ModelAndView("loginformanager");
            modelAndView.addObject("nguoidung", new NguoiDung());
            return modelAndView;
        }
        List<SanBong> sanbong = sanbongService.findAll();
        List<SanBong> quanlysan = new ArrayList<SanBong>();
        for(int i = 0; i < sanbong.size();i++){
            if ((sanbong.get(i).getNguoiDung().getMaNguoiDung()+"").equalsIgnoreCase(maQuanLy+"")){
                quanlysan.add(sanbong.get(i));
                }
        }
        ModelAndView modelAndView = new ModelAndView("quanly/sanbong");
        model.addAttribute("listSanBong",sanbong);
        return modelAndView;


    }

    @GetMapping("/chitiet/{maSanBong}")//chi tiết sân bóng khi click vào link
    public ModelAndView editStaffs(@PathVariable Long maSanBong){
        Optional<SanBong> sanbong= sanbongService.findById(maSanBong);
        ModelAndView modelAndView = new ModelAndView("/quanly/chitietsan");
        System.out.println();
        modelAndView.addObject("sanbong", sanbong );
        return modelAndView;
    }

}
