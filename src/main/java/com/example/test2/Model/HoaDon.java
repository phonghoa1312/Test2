package com.example.test2.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "hoadon")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "IdKH")
    private int idKH;

    @Column(name = "Ma")
    private String maHD;

    @Column(name = "ngaytao")
    private Date ngayTao;

    @Column(name = "ngaythanhtoan")
    private Date ngayThanhToan;

    @Column(name = "ngayship")
    private Date ngayShip;

    @Column(name = "ngaynhan")
    private Date ngayNhan;

    @Column(name = "tinhtrang")
    private int tinhTrang;

    @Column(name = "tennguoinhan")
    private String tenNguoiNhan;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;
}
