package com.example.test2.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "khachhang")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;


    @Column(name = "Ma")
    private String maKH;

    @Column(name = "Ten")
    private String tenKH;

    @Column(name = "tendem")
    private String tenDem;

    @Column(name = "ho")
    private String ho;

    @Column(name = "ngaysinh")
    private Date ngaySinh;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "thanhpho")
    private String thanhPho;

    @Column(name = "quocgia")
    private String quocGia;

    @Column(name = "matkhau")
    private String matKhau;
}
