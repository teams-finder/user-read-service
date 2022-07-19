package com.teamsfinder.userreadservice.user.repository;

import com.teamsfinder.userreadservice.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> { }
