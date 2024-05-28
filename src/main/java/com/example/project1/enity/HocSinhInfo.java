package com.example.project1.enity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.Date;

@Entity
@Data
@Table(name = "hocsinh", schema = "luanvan")
public class HocSinhInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ma_hs")
    private String maHs;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "gioi_tinh")
    private boolean gioiTinh;

    @Column(name = "ma_dinh_danh")
    private String maDinhDanh;

    @Lob
    @Column(name = "hinh_anh", columnDefinition = "LONGBLOB")
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

    @Column(name = "ten_lop",unique = true)
    private String lop;

    @Column(name = "trang_thai")
    private boolean trangThai;

    @Column(name = "nhap_hoc")
    private Date nhapHoc;
}
