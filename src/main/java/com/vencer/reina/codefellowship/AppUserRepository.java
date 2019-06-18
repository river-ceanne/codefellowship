package com.vencer.reina.codefellowship;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByUsername(String username);
    AppUser findById(long id);
    AppUser findByUsernameAndPassword(String username, String hashedpwd);

}
