package com.tungdev.springexcelexport.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TestGraphQL")
@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;

    @Column(name = "`Code`", length = 10, nullable = false)
    @NonNull
    private String code;

    @Column(name = "`name`", length = 50, nullable = false)
    @NonNull
    private String names;

    @Column(name = "`age`", nullable = false)
    @NonNull
    private Integer ages;

    @Column(name = "email", length = 50, nullable = false)
    @NonNull
    private String email;
    @Column(name = "address", length = 50, nullable = false)
    @NonNull
    private String address;

    @Column(name = "`class`", length = 50, nullable = false)
    @NonNull
    private String clazz;

}
