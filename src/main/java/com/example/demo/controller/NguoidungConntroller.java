package com.example.demo.controller;

import com.example.demo.IRepository.INguoiDungRepository;
import com.example.demo.model.NguoiDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class NguoidungConntroller {
    @Autowired
    INguoiDungRepository serviceNguoiDung;
    @GetMapping("/1/matkhau")//chuyển form đổi mật khẩu đang test thử vs 1 cái nhất định
    public ModelAndView editStaffs(){
        Optional<NguoiDung> nguoiDung= serviceNguoiDung.findById(new Long(1));
        System.out.println(nguoiDung.get().getEmail());
        ModelAndView modelAndView = new ModelAndView("nguoidung/changepass");
        modelAndView.addObject("nguoidung", new NguoiDung());
        return modelAndView;
    }

    @PostMapping("/1/matkhau")//thực hiện đổi mà đang lỗi chết mẹ
    public ModelAndView updateMatKhau(@ModelAttribute("nguoidung") NguoiDung nguoiDung,@RequestParam("matKhau") String matKhau) {
        ModelAndView modelAndView = new ModelAndView("/1/matkhau");
        if (!matKhau.equalsIgnoreCase(nguoiDung.getMatKhau())) {
            modelAndView.addObject("message", "Sai mật khẩu");
            ModelAndView modelAndView1 = new ModelAndView("/1/matkhau");
        }
//        else if(!XNMK.equalsIgnoreCase(MKM)){
//            modelAndView.addObject("message1", "mât khẩu mới không khớp");
//            ModelAndView modelAndView1 = new ModelAndView("nguoidung/changepass");
//        }
        else {
            serviceNguoiDung.save(nguoiDung);
            ModelAndView modelAndView1 = new ModelAndView("/1/matkhau");
            modelAndView.addObject("message2", "Thay đổi thành công");
        }
        return modelAndView;
    }

}
