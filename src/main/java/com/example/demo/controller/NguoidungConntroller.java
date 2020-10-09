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
    public ModelAndView loginformanger(Model model) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("nguoidung", new NguoiDung());
        return modelAndView;
    }

    @PostMapping("/login")//như trên
    public ModelAndView login(@ModelAttribute("nguoidung") NguoiDung nguoiDung, @RequestParam("email") String email, @RequestParam("matKhau") String matKhau) {
        List<NguoiDung> list = nguoidungservice.findAll();
        int maVaitro = 1;
        System.out.println(list.get(0).getEmail());
        for (NguoiDung nguoiDung1 : list) {
            if (email.equalsIgnoreCase(nguoiDung1.getEmail()) && matKhau.equalsIgnoreCase(nguoiDung1.getMatKhau()) && (maVaitro + "").equalsIgnoreCase(nguoiDung1.getMaVaiTro())) {
                ModelAndView modelAndView = new ModelAndView("main");
                maNguoidung = (int) nguoiDung1.getMaNguoiDung();
                return modelAndView;
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Sai email hoặc mât khẩu!");
        return modelAndView;
    }

    //Phần hiển thị thông tin nguoi dung và upd thông tin người dùng
    @GetMapping("/thongtinnguoidung")//chuyển form đổi mật khẩu đang test thử vs 1 cái nhất định
    public ModelAndView hỉenthithongtin(){
        if (maNguoidung == 0) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("nguoidung", new NguoiDung());
            return modelAndView;
        }
        Optional<NguoiDung> nguoiDung = nguoidungservice.findById(new Long(maNguoidung));
        System.out.println(nguoiDung.get().getEmail());
        ModelAndView modelAndView = new ModelAndView("nguoidung/information");
        modelAndView.addObject("nguoidung", nguoiDung);
        return modelAndView;
    }

    @PostMapping("/thongtinnguoidung")
    public ModelAndView updthongtin(@ModelAttribute("nguoidung") NguoiDung nguoiDung, @RequestParam("tenNguoiDung") String tenNguoiDung, @RequestParam("soDienThoai") String soDienThoai, @RequestParam("diaChi") String diaChi) {
        Optional<NguoiDung> thongtin = nguoidungservice.findById(new Long(maNguoidung));
        String email = thongtin.get().getEmail();
        String soDT1 = " ";
        String maVaitro = thongtin.get().getMaVaiTro();
        String trangThai = thongtin.get().getTrangThai();
        String matkhau = thongtin.get().getMatKhau();
        nguoiDung = new NguoiDung(new Long(maNguoidung), email, matkhau, tenNguoiDung, soDienThoai, soDT1, diaChi, maVaitro, trangThai);
        nguoidungservice.save(nguoiDung);
        ModelAndView modelAndView = new ModelAndView("nguoidung/information");
        modelAndView.addObject("message", "Sửa thông tin thành công");
        return modelAndView;
    }

    //Phần đổi mật khẩu người dùng
    @GetMapping("/doimatkhau")//chuyển form đổi mật khẩu đang test thử vs 1 cái nhất định
    public ModelAndView editStaffs() {
        if (maNguoidung == 0) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("nguoidung", new NguoiDung());
            return modelAndView;
        }
        Optional<NguoiDung> nguoiDung = nguoidungservice.findById(new Long(maNguoidung));
        ModelAndView modelAndView = new ModelAndView("nguoidung/changepass");
        modelAndView.addObject("nguoidung", new NguoiDung());
        return modelAndView;
    }

    @PostMapping("/doimatkhau")//thực hiện đổi mà đang lỗi chết mẹ -- hết lỗi rồi
    public ModelAndView updateMatKhau(@ModelAttribute("nguoidung") NguoiDung nguoiDung, @RequestParam("matKhau") String matKhau) {
        ModelAndView modelAndView = new ModelAndView("nguoidung/changepass");
        Optional<NguoiDung> findperson = nguoidungservice.findById(new Long(maNguoidung));
        nguoiDung = new NguoiDung(new Long(maNguoidung), findperson.get().getEmail(), matKhau, findperson.get().getTenNguoiDung(), findperson.get().getSoDienThoai(), findperson.get().getSoDienThoai1(), findperson.get().getDiaChi(), findperson.get().getMaVaiTro(), "active");
        System.out.println(nguoiDung.getEmail());
        nguoidungservice.save(nguoiDung);
        modelAndView.addObject("message", "Thay đổi thành công");
        return modelAndView;
    }

}
