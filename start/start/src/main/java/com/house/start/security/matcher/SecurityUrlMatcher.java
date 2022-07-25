package com.house.start.security.matcher;


import com.house.start.domain.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Getter @Setter
public class SecurityUrlMatcher {
    @Id
    @GeneratedValue
    private long id;

    private String url;
    private Role role;
}
