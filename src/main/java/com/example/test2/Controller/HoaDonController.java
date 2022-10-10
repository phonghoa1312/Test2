package com.example.test2.Controller;

import com.example.test2.Model.HoaDon;
import com.example.test2.Model.KhachHang;
import com.example.test2.Repository.HoaDonRepository;
import com.example.test2.Repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class HoaDonController {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    KhachHangRepository khachHangRepository;

    @GetMapping("/HoaDon/create")
    public String create(@ModelAttribute("hoadon") HoaDon hoaDon, Model model){
        model.addAttribute("storehd", "/storehd");
        return "HoaDon/create";
    }

    @GetMapping("/HoaDon/edit/{id}")
    public String edit(@PathVariable(name="id") int id, Model model){
        model.addAttribute("id", id);
        HoaDon hoaDon = hoaDonRepository.getById(id);
        model.addAttribute("hoadon", hoaDon);
        model.addAttribute("storehd", "/storehd");
        return "HoaDon/create";
    }

    @GetMapping("/HoaDon/delete/{id}")
    public String delete(@PathVariable(name="id") int id){
        hoaDonRepository.deleteById(id);
        return "redirect:/listHD";
    }

    @PostMapping("/storehd")
    public String store(
            @ModelAttribute("hoadon") HoaDon x) {
        hoaDonRepository.save(x);
        return "redirect:/listHD";
    }

    @GetMapping("/listHD")
    public String List(Model  model){
        List<HoaDon> listhd =  hoaDonRepository.findAll();

        model.addAttribute("listHD", listhd);
        return "HoaDon/index";
    }
    @GetMapping("/listHDKH")
    public String HDKH(Model model ){
        List<KhachHang> listkh =  khachHangRepository.findAll();
        List<HoaDon> listhd = hoaDonRepository.findAll();
        model.addAttribute("listKH", listkh);
        model.addAttribute("listHD", listhd);
        return "HDKH";
    }
}
