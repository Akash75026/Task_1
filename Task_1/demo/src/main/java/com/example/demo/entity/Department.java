package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @ManyToOne
        @JoinColumn(name = "college_id")
        private College college;

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

        @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
        private List<Faculty> faculties;

        @OneToOne
        @JoinColumn(name = "hod_id")
        private Faculty hod;

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public Faculty getHod() {
        return hod;
    }

    public void setHod(Faculty hod) {
        this.hod = hod;
    }
}
