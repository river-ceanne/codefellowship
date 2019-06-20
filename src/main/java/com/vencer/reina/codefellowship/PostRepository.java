package com.vencer.reina.codefellowship;

import org.springframework.data.repository.CrudRepository;
import org.w3c.dom.ls.LSInput;

import java.util.List;
import java.util.Set;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByAppUserIn(Set<AppUser> appUserList);

}
