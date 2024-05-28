package com.example.project1.service;

import com.example.project1.enity.HocSinhInfo;
import com.example.project1.enity.HocSinhInfoDTO;
import com.example.project1.repository.HocSinhInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocSinhInfoService {

 @Autowired
 HocSinhInfoRepository hocSinhInfoRepository;

 public List<HocSinhInfo> getAllHocSinh() {
     return hocSinhInfoRepository.findAll();
 }

    public Optional<HocSinhInfo> getHocSinhById(Long id) {
        return hocSinhInfoRepository.findById(id);
    }

    public HocSinhInfo createHocSinhInfo(HocSinhInfoDTO hocSinhInfoDTO) {
        HocSinhInfo hocSinhInfo = new HocSinhInfo();
        hocSinhInfo.setId(hocSinhInfoDTO.getId());
        hocSinhInfo.setHoTen(hocSinhInfoDTO.getHoTen());
        hocSinhInfo.setMaHs(hocSinhInfoDTO.getMaHs());
        hocSinhInfo.setNgaySinh(hocSinhInfoDTO.getNgaySinh());
        hocSinhInfo.setGioiTinh(hocSinhInfoDTO.isGioiTinh());
        hocSinhInfo.setMaDinhDanh(hocSinhInfoDTO.getMaDinhDanh());
        hocSinhInfo.setHinhAnh((hocSinhInfoDTO.getHinhAnh()));
        hocSinhInfo.setTinh(hocSinhInfoDTO.getTinh());
        hocSinhInfo.setHuyen(hocSinhInfoDTO.getHuyen());
        hocSinhInfo.setXa(hocSinhInfoDTO.getXa());
        hocSinhInfo.setNoiSinh(hocSinhInfoDTO.getNoiSinh());
        hocSinhInfo.setThuongTru(hocSinhInfoDTO.getThuongTru());
        hocSinhInfo.setTamTru(hocSinhInfoDTO.getTamTru());
        hocSinhInfo.setDanToc(hocSinhInfoDTO.getDanToc());
        hocSinhInfo.setTonGiao(hocSinhInfoDTO.getTonGiao());
        hocSinhInfo.setLop(hocSinhInfoDTO.getLop());
        hocSinhInfo.setTrangThai(hocSinhInfoDTO.isTrangThai());
        hocSinhInfo.setNhapHoc(hocSinhInfoDTO.getNhapHoc());
        HocSinhInfo hocSinhInfo1 = hocSinhInfoRepository.save(hocSinhInfo);
        return hocSinhInfo1;
    }

    public HocSinhInfo saveStudentWithImage(HocSinhInfo hocSinhInfo, byte[] image) {
        hocSinhInfo.setHinhAnh(image);
        return hocSinhInfoRepository.save(hocSinhInfo);
    }

    public byte[] getStudentImage(Long id) {
        Optional<HocSinhInfo> hocSinhInfo = hocSinhInfoRepository.findById(id);
        return hocSinhInfo.map(HocSinhInfo::getHinhAnh).orElse(null);
    }
 public HocSinhInfo updateHocSinhInfo(Long id, HocSinhInfo hocSinhInfoDetails) {
        Optional<HocSinhInfo> optionalHocSinhInfo = hocSinhInfoRepository.findById(id);
        if (optionalHocSinhInfo.isPresent()) {
            HocSinhInfo existingHocSinhInfo = optionalHocSinhInfo.get();
            existingHocSinhInfo.setHoTen(hocSinhInfoDetails.getHoTen());
            existingHocSinhInfo.setNgaySinh(hocSinhInfoDetails.getNgaySinh());
            existingHocSinhInfo.setGioiTinh(hocSinhInfoDetails.isGioiTinh());
            existingHocSinhInfo.setMaDinhDanh(hocSinhInfoDetails.getMaDinhDanh());
            existingHocSinhInfo.setTinh(hocSinhInfoDetails.getTinh());
            existingHocSinhInfo.setHuyen(hocSinhInfoDetails.getHuyen());
            existingHocSinhInfo.setXa(hocSinhInfoDetails.getXa());
            existingHocSinhInfo.setNoiSinh(hocSinhInfoDetails.getNoiSinh());
            existingHocSinhInfo.setThuongTru(hocSinhInfoDetails.getThuongTru());
            existingHocSinhInfo.setTamTru(hocSinhInfoDetails.getTamTru());
            existingHocSinhInfo.setDanToc(hocSinhInfoDetails.getDanToc());
            existingHocSinhInfo.setTonGiao(hocSinhInfoDetails.getTonGiao());
            existingHocSinhInfo.setMaHs(hocSinhInfoDetails.getMaHs());
            existingHocSinhInfo.setTrangThai(hocSinhInfoDetails.isTrangThai());
            existingHocSinhInfo.setNhapHoc(hocSinhInfoDetails.getNhapHoc());
            return hocSinhInfoRepository.save(existingHocSinhInfo);
        } else {
            throw new RuntimeException("HocSinhInfo not found with id " + id);
        }
    }

    public void deleteHocSinhInfo(Long id) {
        hocSinhInfoRepository.deleteById(id);
    }

    public List<HocSinhInfo> search(String ten,String mahs,boolean gioitinh) {
        return hocSinhInfoRepository.search(ten,mahs,gioitinh);
    }
}
