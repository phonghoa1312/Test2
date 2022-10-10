package com.example.test2.Controller;


import com.example.test2.Model.HoaDon;
import com.example.test2.Model.KhachHang;
import com.example.test2.Repository.HoaDonRepository;
import com.example.test2.Repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller

public class KhachHangController {
    @Autowired
    KhachHangRepository khachHangRepository;
    HoaDonRepository hoaDonRepository;

    @GetMapping("/KhachHang/create")
    public String create(@ModelAttribute("khachhang") KhachHang khachHang, Model model){
        model.addAttribute("store", "/store");
        return "KhachHang/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name="id") int id, Model model){
        model.addAttribute("id", id);
        KhachHang khachHang = khachHangRepository.getById(id);
        model.addAttribute("khachhang", khachHang);
        model.addAttribute("store", "/store");
        return "KhachHang/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name="id") int id){
        khachHangRepository.deleteById(id);

        return "redirect:/listKH";
    }

    @PostMapping("/store")
    public String store(
            @ModelAttribute("khachhang") KhachHang x) {
        khachHangRepository.save(x);
        return "redirect:/listKH";
    }

    @GetMapping("/listKH")
    public String List(Model  model){
        List<KhachHang> listkh =  khachHangRepository.findAll();

        model.addAttribute("listKH", listkh);
        return "KhachHang/index";
    }

}
