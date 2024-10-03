package com.java2.practicalexam.service;

import com.java2.practicalexam.entity.National;
import com.java2.practicalexam.repository.NationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NationalService {
    @Autowired
    private NationalRepository nationalRepository;

    public NationalService(NationalRepository nationalRepository) {
        this.nationalRepository = nationalRepository;
    }

    public boolean insertNational(National national) throws Exception {
        try {
            nationalRepository.save(national);
            return true;
        } catch (Exception e) {
            throw new Exception("Error adding new national" + e.getMessage());
        }
    }

    public boolean deleteNational(int nationalId) throws Exception {
        try {
            nationalRepository.deleteById(nationalId);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting national with ID "+ nationalId + e.getMessage());
        }
    }
}
