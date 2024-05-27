package com.example.project1.enity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;



@NoArgsConstructor
@Getter
@Setter
public class GiaoVienInfoDTO {

    private Long id;
    private String maGv;
    private String hoTen;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String cccd;
    private String email;
    private byte[] hinhAnh;
    private String tinh;
    private String huyen;
    private String xa;
    private String noiSinh;
    private String thuongTru;
    private String tamTru;
    private String danToc;
    private String tonGiao;
    private String trinhDo;
    private String chungChiTh;
    private String chungChiNn;
    private String sdt;
}
