package com.example.project1.enity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "phuhuynh",schema = "luanvan")
public class PhuHuynhInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    // ?????
}
