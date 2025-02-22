package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public class Faculty {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @ManyToOne
        @JoinColumn(name = "department_id")
        private Department department;

        public void setDepartment(Department department) {
            this.department = department;
        }

    }

