package com.example.project1.service;

import com.example.project1.enity.GiaoVienInfo;
import com.example.project1.enity.LopHoc;
import com.example.project1.enity.LopHocDTO;
import com.example.project1.repository.GiaoVienInfoRepository;
import com.example.project1.repository.LopHocRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LopHocService {

    @Autowired
    private LopHocRepository lopHocRepository;
    @Autowired
private GiaoVienInfoRepository giaoVienInfoRepository;
    public List<LopHoc> getAllLopHoc() {
        return lopHocRepository.findAll();
    }

    public LopHoc getLopHocById(Long id) {
        return lopHocRepository.findById(id).orElse(null);
    }


    public LopHoc createLopHoc(LopHocDTO lopHocDTO){
      LopHoc lopHoc = new LopHoc();
      lopHoc.setTenLop(lopHocDTO.getTenLop());
      lopHoc.setGvcn(lopHocDTO.getGvcn());
      lopHoc.setPhongHoc(lopHocDTO.getPhongHoc());
      lopHoc.setSlhs(lopHocDTO.getSlhs());
      LopHoc lopHoc1 = lopHocRepository.save(lopHoc);
      return lopHoc1;
    }


    public LopHoc updateLopHoc(Long id, LopHoc lopHocDetails) {
        LopHoc lopHoc = lopHocRepository.findById(id).orElse(null);
        if (lopHoc != null) {
            lopHoc.setTenLop(lopHocDetails.getTenLop());
            lopHoc.setGvcn(lopHocDetails.getGvcn());
            lopHoc.setSlhs(lopHocDetails.getSlhs());
            lopHoc.setPhongHoc(lopHocDetails.getPhongHoc());
            return lopHocRepository.save(lopHoc);
        }
        return null;
    }

    public void deleteLopHoc(Long id) {
        lopHocRepository.deleteById(id);
    }
}
