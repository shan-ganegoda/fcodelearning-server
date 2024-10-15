package com.fcodelearning.edu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userstatus_id")
    private Userstatus userstatus;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "datejoined")
    private LocalDate datejoined;

    @Column(name = "nic", length = 12)
    private String nic;

    @Lob
    @Column(name = "address")
    private String address;

    @Column(name = "dob")
    private LocalDate dob;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "lastupdated")
    private Instant lastupdated;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "roles_id", nullable = false)
    private Role roles;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();


            authorityList.add(new SimpleGrantedAuthority("ROLE_" + roles.getName()));

            for (Authority authority : roles.getAuthorities()) {
                authorityList.add(new SimpleGrantedAuthority(
                        authority.getModule().getName() + "-" + authority.getOperation().getName())
                );
            }

        return authorityList;
    }

    @Override
    public String getUsername(){ return username;}

    @Override
    public String getPassword(){
        return password;
    }

}