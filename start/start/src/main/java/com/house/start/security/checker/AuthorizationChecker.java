package com.house.start.security.checker;

import com.house.start.domain.Member;
import com.house.start.security.matcher.SecurityUrlMatcher;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthorizationChecker {
    public boolean check(HttpServletRequest request, Authentication authentication) {
        Object principalObj = authentication.getPrincipal();

        if(!(principalObj instanceof Member)) {
            return false;
        }
        Member member = (Member) authentication.getPrincipal();

        return false;
    }
}
