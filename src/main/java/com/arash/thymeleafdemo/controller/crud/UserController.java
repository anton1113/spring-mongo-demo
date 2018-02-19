package com.arash.thymeleafdemo.controller.crud;

import com.arash.thymeleafdemo.model.db.User;
import com.arash.thymeleafdemo.repository.DemoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by anton1113 on 19.02.18.
 */

@RestController
public class UserController implements CrudControllerApi<User, String> {

    @Autowired private DemoUserRepository demoUserRepository;

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/rest/user/")
    public List<User> findAll() {
        return demoUserRepository.findAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/rest/user/{id}")
    public User find(@PathVariable String id) {
        return demoUserRepository.findOne(id);
    }

    @Override
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/rest/user/",
            consumes = "application/json"
    )
    public void insert(@RequestBody User user) {
        demoUserRepository.save(user);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE, value = "/rest/user/{id}")
    public void delete(@PathVariable String id) {
        demoUserRepository.delete(id);
    }
}
