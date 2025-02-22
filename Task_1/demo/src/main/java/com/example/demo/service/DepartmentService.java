package com.example.demo.service;

import com.example.demo.entity.College;
import com.example.demo.entity.Department;
import com.example.demo.repository.CollegeRepository;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private CollegeRepository collegeRepository;

    public Department addDepartment(Long collegeId, Department department) {
        College college = collegeRepository.findById(collegeId)
                .orElse(null);
    department.setCollege(college);
        return departmentRepository.save(department);
    }

    public List<Department> getDepartmentsByCollegeName(String collegeName) {
        return departmentRepository.findByCollegeName(collegeName);
    }
}
