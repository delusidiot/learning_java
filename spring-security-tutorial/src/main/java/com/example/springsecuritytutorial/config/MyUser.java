package com.example.springsecuritytutorial.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serial;
import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
public class MyUser extends User {

    @Serial
    private static final long serialVersionUID = 1L;

    public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,
                  boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
                  String firstName, String lastName, String emailAddress, LocalDate birthdate
    ) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = "%s %s".formatted(firstName, lastName);
        this.emailAddress = emailAddress;
        this.birthdate = birthdate;
    }
    private String firstName;
    private String lastName;
    private String fullName;
    private String emailAddress;
    private LocalDate birthdate;

    @Override
    public String toString() {
        return "MyUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
