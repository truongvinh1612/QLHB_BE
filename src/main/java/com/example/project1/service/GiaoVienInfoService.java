package com.example.project1.service;

import com.example.project1.enity.GiaoVienInfo;
import com.example.project1.exception.GiaoVienNotFoundException;
import com.example.project1.repository.GiaoVienInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GiaoVienInfoService {

    private final GiaoVienInfoRepository giaoVienInfoRepository;

    @Autowired
    public GiaoVienInfoService(GiaoVienInfoRepository giaoVienInfoRepository) {
        this.giaoVienInfoRepository = giaoVienInfoRepository;
    }

    public List<GiaoVienInfo> getAllGiaoVien() {
        return giaoVienInfoRepository.findAll();
    }

    public Optional<GiaoVienInfo> getGiaoVienById(Long id) {
        return giaoVienInfoRepository.findById(id);
    }

    @Transactional
    public GiaoVienInfo saveGiaoVien(GiaoVienInfo giaoVienInfo) {
        return giaoVienInfoRepository.save(giaoVienInfo);
    }

    @Transactional
    public GiaoVienInfo updateGiaoVien(Long id, GiaoVienInfo giaoVienInfoDetails) {
        return giaoVienInfoRepository.findById(id)
                .map(existingGiaoVienInfo -> {
                    existingGiaoVienInfo.setHoTen(giaoVienInfoDetails.getHoTen());
                    existingGiaoVienInfo.setNgaySinh(giaoVienInfoDetails.getNgaySinh());
                    existingGiaoVienInfo.setGioiTinh(giaoVienInfoDetails.isGioiTinh());
                    existingGiaoVienInfo.setCccd(giaoVienInfoDetails.getCccd());
                    existingGiaoVienInfo.setEmail(giaoVienInfoDetails.getEmail());
                    existingGiaoVienInfo.setHinhAnh(giaoVienInfoDetails.getHinhAnh());
                    existingGiaoVienInfo.setTinh(giaoVienInfoDetails.getTinh());
                    existingGiaoVienInfo.setHuyen(giaoVienInfoDetails.getHuyen());
                    existingGiaoVienInfo.setXa(giaoVienInfoDetails.getXa());
                    existingGiaoVienInfo.setNoiSinh(giaoVienInfoDetails.getNoiSinh());
                    existingGiaoVienInfo.setThuongTru(giaoVienInfoDetails.getThuongTru());
                    existingGiaoVienInfo.setTamTru(giaoVienInfoDetails.getTamTru());
                    existingGiaoVienInfo.setDanToc(giaoVienInfoDetails.getDanToc());
                    existingGiaoVienInfo.setTonGiao(giaoVienInfoDetails.getTonGiao());
                    existingGiaoVienInfo.setMaGv(giaoVienInfoDetails.getMaGv());
                    return giaoVienInfoRepository.save(existingGiaoVienInfo);
                })
                .orElseThrow(() -> new GiaoVienNotFoundException("GiaoVienInfo not found with id " + id));
    }

    @Transactional
    public void deleteGiaoVien(Long id) {
        if (!giaoVienInfoRepository.existsById(id)) {
            throw new GiaoVienNotFoundException("GiaoVienInfo not found with id " + id);
        }
        giaoVienInfoRepository.deleteById(id);
    }
}
