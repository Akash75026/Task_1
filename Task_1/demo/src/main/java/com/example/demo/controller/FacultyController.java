package com.example.demo.controller;


import com.example.demo.entity.Faculty;
import com.example.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @PostMapping("/{departmentId}")
    public ResponseEntity<Faculty> addFaculty(@PathVariable Long departmentId, @RequestBody Faculty faculty) {
        return ResponseEntity.status(HttpStatus.CREATED).body(facultyService.addFaculty(departmentId, faculty));
    }

    @GetMapping("/department/{departmentName}")
    public List<Faculty> getFacultiesByDepartmentName(@PathVariable String departmentName) {
        return facultyService.getFacultiesByDepartmentName(departmentName);
    }

    @PutMapping("/assignHOD/{departmentId}/{facultyId}")
    public ResponseEntity<Faculty> assignHOD(@PathVariable Long departmentId, @PathVariable Long facultyId) {
        return ResponseEntity.ok(facultyService.assignHOD(departmentId, facultyId));
    }
}
