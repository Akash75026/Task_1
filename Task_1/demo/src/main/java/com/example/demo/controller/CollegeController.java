package com.example.demo.controller;

import com.example.demo.entity.College;
import com.example.demo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @PostMapping
    public ResponseEntity<College> addCollege(@RequestBody College college) {
        return ResponseEntity.status(HttpStatus.CREATED).body(collegeService.addCollege(college));
    }


    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllCollege();
    }

    @GetMapping("/{id}")
    public College getCollegeById(@PathVariable Long id) {
        return collegeService.getCollegeById(id);
    }

    @GetMapping("/name/{name}")
    public College getCollegeByName(@PathVariable String name) {
        return collegeService.getCollegeByName(name);
    }

    @PutMapping("/{id}")
    public College updateCollegeName(@PathVariable Long id, @RequestBody String newName) {
        return collegeService.updateCollegeName(id, newName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollegeById(@PathVariable Long id) {
        collegeService.deleteCollegeById(id);
        return ResponseEntity.noContent().build();
    }
}
