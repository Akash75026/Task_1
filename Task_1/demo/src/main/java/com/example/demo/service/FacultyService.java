package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Faculty;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Faculty addFaculty(Long departmentId, Faculty faculty) {
        Department department = departmentRepository.findById(departmentId)
                .orElse(null);
        faculty.setDepartment(department);
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getFacultiesByDepartmentName(String departmentName) {
        return facultyRepository.findByDepartmentName(departmentName);
    }

    public Faculty assignHOD(Long departmentId, Long facultyId) {
        Department department = departmentRepository.findById(departmentId)
                .orElse(null);
        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(null);

        department.setHod(faculty);
        return facultyRepository.save(faculty);
    }
}
