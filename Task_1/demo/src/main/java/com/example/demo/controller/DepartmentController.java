package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/{collegeId}")
    public ResponseEntity<Department> addDepartment(@PathVariable Long collegeId, @RequestBody Department department) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(collegeId, department));
    }

    @GetMapping("/college/{collegeName}")
    public List<Department> getDepartmentsByCollegeName(@PathVariable String collegeName) {
        return departmentService.getDepartmentsByCollegeName(collegeName);
    }

}
