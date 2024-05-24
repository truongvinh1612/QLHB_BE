package com.example.project1.enity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "Lop", schema = "luanvan")
public class LopHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ten_lop")
    private String tenlop;
//????
    @OneToOne
    @JoinColumn(name = "ma_gv")
    private GiaoVienInfo gvcn;

    @Column(name = "mo_ta")
    private  String mota;

    @Column(name = "slhs")
    private Long slhs;

    @Column(name = "phong_hoc")
    private String phonghoc;


}
