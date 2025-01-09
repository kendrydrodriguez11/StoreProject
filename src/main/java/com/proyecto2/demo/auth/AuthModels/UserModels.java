package com.proyecto2.demo.auth.AuthModels;

import com.proyecto2.demo.auth.User.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"name"} ))
public class UserModels implements UserDetails {
    @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id @Column(name = "idUser")
    private long id;

    @Column(name="user_name", nullable = false)
    private String userName;

    @Getter @Setter @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

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
        return password;
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
