package com.example.project1.service;

import com.example.project1.enity.GiaoVienInfo;
import com.example.project1.enity.GiaoVienInfoDTO;
import com.example.project1.enity.HocSinhInfo;
import com.example.project1.exception.GiaoVienNotFoundException;
import com.example.project1.repository.GiaoVienInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public GiaoVienInfo createGiaoVien(GiaoVienInfoDTO giaoVienInfoDTO){
        GiaoVienInfo giaoVienInfo = new GiaoVienInfo();
        giaoVienInfo.setMaGv(giaoVienInfoDTO.getMaGv());
        giaoVienInfo.setHoTen(giaoVienInfoDTO.getHoTen());
        giaoVienInfo.setNgaySinh(giaoVienInfoDTO.getNgaySinh());
        giaoVienInfo.setGioiTinh(giaoVienInfoDTO.isGioiTinh());
        giaoVienInfo.setCccd(giaoVienInfoDTO.getCccd());
        giaoVienInfo.setEmail(giaoVienInfoDTO.getEmail());
        giaoVienInfo.setTinh(giaoVienInfoDTO.getTinh());
        giaoVienInfo.setHuyen(giaoVienInfoDTO.getHuyen());
        giaoVienInfo.setXa(giaoVienInfoDTO.getXa());
        giaoVienInfo.setNoiSinh(giaoVienInfoDTO.getNoiSinh());
        giaoVienInfo.setThuongTru(giaoVienInfoDTO.getThuongTru());
        giaoVienInfo.setTamTru(giaoVienInfoDTO.getTamTru());
        giaoVienInfo.setDanToc(giaoVienInfoDTO.getDanToc());
        giaoVienInfo.setTonGiao(giaoVienInfoDTO.getTonGiao());
        giaoVienInfo.setTrinhDo(giaoVienInfoDTO.getTrinhDo());
        giaoVienInfo.setChungChiNn(giaoVienInfoDTO.getChungChiNn());
        giaoVienInfo.setChungChiTh(giaoVienInfoDTO.getChungChiTh());
        giaoVienInfo.setSdt(giaoVienInfoDTO.getSdt());
        GiaoVienInfo giaoVienInfo1 = giaoVienInfoRepository.save(giaoVienInfo);
        return giaoVienInfo1;
    }
    public GiaoVienInfo saveTeacherWithImage(GiaoVienInfo giaoVienInfo, byte[] imageBytes) {
        giaoVienInfo.setHinhAnh(imageBytes);
        return giaoVienInfoRepository.save(giaoVienInfo);
    }

    public byte[] getTeacherImage(Long id) {
        Optional<GiaoVienInfo> giaoVienInfo = giaoVienInfoRepository.findById(id);
        return giaoVienInfo.map(GiaoVienInfo::getHinhAnh).orElse(null);
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

    public Optional<GiaoVienInfo> findByMaGv(String maGV) {
        return giaoVienInfoRepository.findByMaGv(maGV);
    }

    @Transactional
    public void deleteGiaoVienByMaGv(String maGV) {
        giaoVienInfoRepository.deleteByMaGv(maGV);
    }

    public List<GiaoVienInfo> search(String hoTen,String maGv,Boolean gioiTinh, String trinhDo) {
        return giaoVienInfoRepository.search(hoTen,maGv,gioiTinh,trinhDo);
    }
}

