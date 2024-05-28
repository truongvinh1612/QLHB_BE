package com.example.project1.enity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "giaovien", schema = "luanvan")
public class GiaoVienInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ma_gv", unique = true)
    private String maGv;
    @Column(name = "ho_ten")
    private String hoTen;
    @Column(name = "ngay_sinh")
    private Date ngaySinh;
    @Column(name = "gioi_tinh")
    private boolean gioiTinh;
    @Column(name = "cccd")
    private String cccd;
    @Column(name = "email")
    private String email;
    @Lob
    @Column(name = "hinh_anh", columnDefinition="LONGBLOB")
    private byte[] hinhAnh;
    @Column(name = "tinh")
    private String tinh;
    @Column(name = "huyen")
    private String huyen;
    @Column(name = "xa")
    private String xa;
    @Column(name = "noi_sinh")
    private String noiSinh;
    @Column(name = "thuong_tru")
    private String thuongTru;
    @Column(name = "tam_tru")
    private String tamTru;
    @Column(name = "dan_toc")
    private String danToc;
    @Column(name = "ton_giao")
    private String tonGiao;
    @Column(name = "trinh_do")
    private String trinhDo;
    @Column(name = "chung_chi_th")
    private String chungChiTh;
    @Column(name = "chung_chi_nn")
    private String chungChiNn;
    @Column(name = "so_dien_thoai")
    private String sdt;
}
