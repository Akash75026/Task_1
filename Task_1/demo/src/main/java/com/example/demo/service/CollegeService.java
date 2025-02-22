package com.example.demo.service;

import com.example.demo.entity.College;
import com.example.demo.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;

    public College addCollege(College college){
       return collegeRepository.save(college);
    }

    public List<College> getAllCollege()
    {
        return collegeRepository.findAll();
    }

    public College getCollegeById(Long id) {
        return collegeRepository.findById(id).orElse(null);
    }

    public College getCollegeByName(String name) {
        return collegeRepository.findByName(name).orElse(null);
    }

    public College updateCollegeName(Long id, String newName) {
        College college = getCollegeById(id);
        college.setName(newName);
        return collegeRepository.save(college);
    }


    public void deleteCollegeById(Long id) {
        College college = getCollegeById(id);
        collegeRepository.delete(college);
    }


}
