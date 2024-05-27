package com.example.project1.enity;

import jakarta.persistence.Entity;
import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HocSinhInfoDTO {

    private Long id;
    private String maHs;
    private String hoTen;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String maDinhDanh;
    private byte[] hinhAnh;
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
