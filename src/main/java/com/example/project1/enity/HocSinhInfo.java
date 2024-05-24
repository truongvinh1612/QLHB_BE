package com.example.project1.enity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;

import java.util.Date;

@Entity
@Data
@Table(name = "student",schema = "luanvan")
public class HocSinhInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
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

    @Column(name = "ma_hs")
    private String mahs;
    @Column(name = "ten_lop")
    private String tenlop;
    @Column(name = "khoi")
    private String khoi;
    @Column(name = "trang_thai")
    private boolean trangthai;
    @Column(name = "nhap_hoc")
    private Date nhaphoc;


}
