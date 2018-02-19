package com.arash.thymeleafdemo.controller.crud;

import java.util.List;

/**
 * Created by anton1113 on 19.02.18.
 */
public interface CrudControllerApi<Type, Id> {

    List<Type> findAll();
    Type find(Id id);
    void insert(Type type);
    void delete(Id id);

}
