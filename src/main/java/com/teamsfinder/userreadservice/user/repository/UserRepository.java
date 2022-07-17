package com.teamsfinder.userreadservice.user.repository;

import com.teamsfinder.userreadservice.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> { }
