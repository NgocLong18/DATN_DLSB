package com.example.demo.controller;

import com.example.demo.IRepository.INguoiDungRepository;
import com.example.demo.model.NguoiDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class NguoidungConntroller {
    //Phần login cho người dùng
    int maNguoidung = 0;
    @Autowired
    private INguoiDungRepository nguoidungservice;

    @GetMapping("/login")//mấy cái này chắc ko cần nói
    public ModelAndView saveStaffs(Model model){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("nguoidung", new NguoiDung());
        return modelAndView;
    }

    @PostMapping("/login")//như trên
    public ModelAndView login(@ModelAttribute("nguoidung")NguoiDung nguoiDung, @RequestParam("email") String email, @RequestParam("matKhau") String matKhau) {
        List<NguoiDung> list = nguoidungservice.findAll();
        int maVaitro = 1;
        System.out.println(list.get(0).getEmail());
        for (NguoiDung nguoiDung1 : list){
            if(email.equalsIgnoreCase(nguoiDung1.getEmail()) && matKhau.equalsIgnoreCase(nguoiDung1.getMatKhau()) && (maVaitro+"").equalsIgnoreCase(nguoiDung1.getMaVaiTro()) ){
                ModelAndView modelAndView = new ModelAndView("main");
                maNguoidung= (int) nguoiDung1.getMaNguoiDung();
                System.out.println(maNguoidung);
                return modelAndView ;
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Sai email hoặc mât khẩu!");
        return modelAndView;
    }

    @Autowired
    INguoiDungRepository serviceNguoiDung;
    @GetMapping("/doimatkhau")//chuyển form đổi mật khẩu đang test thử vs 1 cái nhất định
    public ModelAndView editStaffs(){
        System.out.println(maNguoidung);
        Optional<NguoiDung> nguoiDung= serviceNguoiDung.findById(new Long(maNguoidung));
        ModelAndView modelAndView = new ModelAndView("nguoidung/changepass");
        modelAndView.addObject("nguoidung", new NguoiDung());
        return modelAndView;
    }

    @PostMapping("/doimatkhau")//thực hiện đổi mà đang lỗi chết mẹ
    public ModelAndView updateMatKhau(@ModelAttribute("nguoidung") NguoiDung nguoiDung,@RequestParam("matKhau") String matKhau) {
        ModelAndView modelAndView = new ModelAndView("/doimatkhau");
        if (!matKhau.equalsIgnoreCase(nguoiDung.getMatKhau())) {
            modelAndView.addObject("message", "Sai mật khẩu");
            ModelAndView modelAndView1 = new ModelAndView("/doimatkhau");
        }
//        else if(!XNMK.equalsIgnoreCase(MKM)){
//            modelAndView.addObject("message1", "mât khẩu mới không khớp");
//            ModelAndView modelAndView1 = new ModelAndView("nguoidung/changepass");
//        }
        else {
            serviceNguoiDung.save(nguoiDung);
            ModelAndView modelAndView1 = new ModelAndView("/doimatkhau");
            modelAndView.addObject("message2", "Thay đổi thành công");
        }
        return modelAndView;
    }

}
