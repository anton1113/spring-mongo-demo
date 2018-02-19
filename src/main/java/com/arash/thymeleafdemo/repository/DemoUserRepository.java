package com.arash.thymeleafdemo.repository;

import com.arash.thymeleafdemo.model.db.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by anton1113 on 19.02.18.
 */
@Repository
public interface DemoUserRepository extends MongoRepository<User, String> {
}
