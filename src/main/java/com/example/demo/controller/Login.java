package com.example.demo.controller;

import com.example.demo.IRepository.INguoiDungRepository;
import com.example.demo.model.NguoiDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Login {
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
		System.out.println(list.get(0).getEmail());
		for (NguoiDung nguoiDung1 : list){
			if(email.equalsIgnoreCase(nguoiDung1.getEmail()) && matKhau.equalsIgnoreCase(nguoiDung1.getMatKhau())){
				ModelAndView modelAndView = new ModelAndView("main");
				return modelAndView ;
			}
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Sai email hoặc mât khẩu!");
		return modelAndView;
	}
	
}
