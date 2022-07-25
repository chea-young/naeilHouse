package com.house.start.security.checker;

import com.house.start.domain.Member;
import com.house.start.domain.Role;
import com.house.start.repository.MemberRepository;
import com.house.start.repository.SecurityUrlMatcherRepository;
import com.house.start.security.matcher.SecurityUrlMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class AuthorizationChecker {
    @Autowired
    private SecurityUrlMatcherRepository urlMatcherRepository;
    @Autowired
    private MemberRepository memberRepository;

    public boolean check(HttpServletRequest request, Authentication authentication) {
        Object principalObj = authentication.getPrincipal();

        if(!(principalObj instanceof Member)) {
            return false;
        }

        Role authority = null;

        List<SecurityUrlMatcher> urlMatchers = (List<SecurityUrlMatcher>) urlMatcherRepository.findAll();
        for (SecurityUrlMatcher matcher:
             urlMatchers) {
            if(new AntPathMatcher().match(matcher.getUrl(), request.getRequestURI())) {
                authority = matcher.getRole();
                break;
            }
        }

        Long memberId = ((Member) authentication.getPrincipal()).getId();
        Member loggedMember = memberRepository.findMemberById(memberId);


        return true;
    }
}
