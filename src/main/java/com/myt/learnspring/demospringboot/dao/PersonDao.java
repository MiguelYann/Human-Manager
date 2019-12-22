package com.myt.learnspring.demospringboot.dao;

import com.myt.learnspring.demospringboot.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {
    List<Person> getAllPersons();

    Optional<Person> getPersonById(Long id);

    Person addPerson(Person person);

    void updatePerson(Person person, Long id);

    void deletePersonneById(Long id);
}
