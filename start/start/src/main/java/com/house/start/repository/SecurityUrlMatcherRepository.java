package com.house.start.repository;

import com.house.start.security.matcher.SecurityUrlMatcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityUrlMatcherRepository extends CrudRepository<SecurityUrlMatcher, Long> {
    
}
