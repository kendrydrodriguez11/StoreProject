package com.proyecto2.demo.auth.AuthModels;

import com.proyecto2.demo.auth.User.UserRole;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Builder
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"name"} ))
public class UserModels implements UserDetails {
    @Getter @Setter @GeneratedValue
    @Id @Column(name = "idUser")
    private long id;

    @Getter @Setter @Column(name="usernName", nullable = false)
    private String userName;

    @Getter @Setter @Column(name = "lastName")
    private String lastName;

    @Getter @Setter @Column(name = "password1")
    private String password1;

    @Getter @Setter @Column(name = "password2")
    private String password2;

    @Getter @Setter @Column(name = "mail")
    private String mail;

    @Enumerated(EnumType.STRING)
    @Getter @Setter @Column(name = "role")
    UserRole role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }


}
