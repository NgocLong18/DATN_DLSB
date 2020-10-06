package com.example.demo.controller;

import com.example.demo.IRepository.INguoiDungRepository;
import com.example.demo.IRepository.ISanBongRepository;
import com.example.demo.model.NguoiDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class QuanlySanController {
    @Autowired
    ISanBongRepository sangbongService;
    @Autowired
    INguoiDungRepository nguoidungservice;

    @GetMapping("/manager")
    public ModelAndView saveStaffs(Model model){
        ModelAndView modelAndView = new ModelAndView("quanly/loginformanager");
        modelAndView.addObject("nguoidung", new NguoiDung());
        return modelAndView;
    }

    @PostMapping("/manager")
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

    @GetMapping("/sanbong")
    public String reddirectSanBong(){
        return "quanly/sanbong";
    }
}
