package com.myt.learnspring.demospringboot.controllers;

import com.myt.learnspring.demospringboot.dao.PersonDao;
import com.myt.learnspring.demospringboot.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class PersonController {
    public static List<Person> personList = new ArrayList<>();

    @Autowired
    PersonDao personDao;


    @GetMapping(value = "/persons")
    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    @GetMapping(value = "/person/{id}")
    public Optional<Person> getPerson(@PathVariable Long id) {
        return personDao.getPersonById(id);

    }

    @PutMapping(value = "/person/{id}", consumes = {APPLICATION_JSON_VALUE})
    public String updatePerson(@PathVariable Long id, @RequestBody @Valid Person person) {
        personDao.updatePerson(person, id);
        return "Updating";
    }

    @PostMapping(value = "/person")
    public Person createPerson(@RequestBody @Valid Person person) {
        personDao.addPerson(person);
        return person;
    }

    @DeleteMapping(value = "/person/{id}")
    public void deletePersonById(@PathVariable Long id) {
        personDao.deletePersonneById(id);
    }
}
