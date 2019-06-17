package com.vencer.reina.codefellowship;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    public List<AppUser> findByUsername(String username);

}
