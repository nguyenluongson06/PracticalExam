package com.java2.practicalexam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "national")
@Entity
public class National {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NationalId", nullable = false)
    private int nationalId;

    @Getter
    @Column(name = "NationalName", nullable = false)
    private String nationalName;

    protected National() {}

    public National(String nationalName) {
        this.nationalName = nationalName;
    }
}
