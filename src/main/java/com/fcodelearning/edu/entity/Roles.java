//package com.fcodelearning.edu.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.Collection;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
//public class Roles {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "id")
//    private Integer id;
//    @Basic
//    @Column(name = "name")
//    private String name;
//    @OneToMany(mappedBy = "roles")
//    private Collection<Credentials> credentials;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Roles roles = (Roles) o;
//
//        if (id != null ? !id.equals(roles.id) : roles.id != null) return false;
//        if (name != null ? !name.equals(roles.name) : roles.name != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
//    }
//
//    public Collection<Credentials> getCredentials() {
//        return credentials;
//    }
//
//    public void setCredentials(Collection<Credentials> credentials) {
//        this.credentials = credentials;
//    }
//}
