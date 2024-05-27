package com.example.project1.enity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;



@NoArgsConstructor
@Getter
@Setter
public class HocSinhInfoDTO {


    private Long id;


    private String maHs;


    private String hoTen;


    private Date ngaySinh;


    private boolean gioiTinh;


    private String maDinhDanh;

    private String hinhAnh;

    private String tinh;

    private String huyen;

    private String xa;

    private String noiSinh;

    private String thuongTru;

    private String tamTru;

    private String danToc;

    private String tonGiao;

    private String lop;

    private boolean trangThai;

    private Date nhapHoc;
}
