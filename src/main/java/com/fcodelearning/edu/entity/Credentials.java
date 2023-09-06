//package com.fcodelearning.edu.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.sql.Date;
//
//@Entity
//@Builder
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@EqualsAndHashCode
//public class Credentials {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "id")
//    private Integer id;
//    @Basic
//    @Column(name = "username")
//    private String username;
//    @Basic
//    @Column(name = "password")
//    private String password;
//
//    @Basic
//    @Column(name = "firstname")
//    private String firstname;
//    @Basic
//    @Column(name = "lastname")
//    private String lastname;
//    @Basic
//    @Column(name = "datejoined")
//    private Date datejoined;
//    @Basic
//    @Column(name = "nic")
//    private String nic;
//    @Basic
//    @Column(name = "credentialscol")
//    private String credentialscol;
//    @Basic
//    @Column(name = "address")
//    private String address;
//    @Basic
//    @Column(name = "dob")
//    private Date dob;
//    @Basic
//    @Column(name = "description")
//    private String description;
//    @ManyToOne
//    @JoinColumn(name = "roles_id", referencedColumnName = "id", nullable = false)
//    private Roles roles;
//}
//
