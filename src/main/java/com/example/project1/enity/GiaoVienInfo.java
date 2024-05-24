package com.example.project1.enity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Table(name = "giaovien", schema = "luanvan")
public class GiaoVienInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ma_gv",unique = true)
    private String magv;
    @Column(name = "ho_ten")
    private String hoten;
    @Column(name = "ngay_sinh")
    private Date ngaysinh;
    @Column(name = "gioi_tinh")
    private boolean gioitinh;
    @Column(name = "cccd")
    private String cccd;
    @Column(name = "email")
    private String email;
    @Column(name = "hinh_anh")
    private String hinhanh;

    @Column(name = "tinh")
    private String tinh;
    @Column(name = "huyen")
    private String huyen;
    @Column(name = "xa")
    private String xa;
    @Column(name = "noi_sinh")
    private String noisinh;
    @Column(name = "thuong_tru")
    private String thuongtru;
    @Column(name = "tam_tru")
    private String tamtru;
    @Column(name = "dan_toc")
    private String dantoc;
    @Column(name = "ton_giao")
    private String tongiao;


    @Column(name = "trinh_do")
    private String trinhdo;
    @Column(name = "chung_chi_th")
    private String chungchith;

    @Column(name = "chung_chi_nn")
    private String chungchinn;

}
