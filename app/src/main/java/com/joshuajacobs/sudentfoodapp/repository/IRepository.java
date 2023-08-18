package com.joshuajacobs.sudentfoodapp.repository;

/* IRepository.java
 Entity for the IRepository
 Author: Joshua Jacobs (221144862)
 Date: 5 April 2023
*/
public interface IRepository<T, ID> {
    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);
}
