package com.example.viyog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name= "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Column(name = "full_name")
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "user_password", length = 500)
    private String password;


    @Column(name = "mobile_number", unique = true, nullable = false)
    private Long mobileNumber;
    
    
}
