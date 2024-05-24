package com.example.project1.enity;

import com.example.project1.enity.GiaoVienInfo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Lop", schema = "luanvan")
public class LopHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ten_lop")
    private String tenLop;

    @Column(name = "gvcn",unique = true)
    private String gvcn;

    @Column(name = "slhs")
    private Long slhs;

    @Column(name = "phong_hoc")
    private String phongHoc;

}
