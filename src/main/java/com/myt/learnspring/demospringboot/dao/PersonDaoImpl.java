package com.myt.learnspring.demospringboot.dao;

import com.myt.learnspring.demospringboot.models.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonDaoImpl implements PersonDao {

    public static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new Person(1L, "miguel", "yann", 24));
        personList.add(new Person(2L, "Salome", "Etienne", 14));
        personList.add(new Person(3L, "Charifa", "Sekoutoure", 22));
        personList.add(new Person(4L, "Mathieu", "Jean", 34));

    }

    private static void removePerson(Person person) {
        personList.remove(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personList;
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return getFirst(id);
    }

    private Optional<Person> getFirst(Long id) {
        return personList.stream()
                .filter((aPerson -> aPerson.getId().equals(id))).findFirst();
    }

    @Override
    public Person addPerson(Person person) {
        personList.add(person);
        return person;
    }

    @Override
    public void updatePerson(Person person, Long id) {
        var personal = getFirst(id);
        if (personal.isPresent()) {
            personal.get().setAge(person.getAge());
            personal.get().setFirstName(person.getFirstName());
            personal.get().setLastName(person.getLastName());
        }
    }

    @Override
    public void deletePersonneById(Long id) {
        personList.stream()
                .filter(person -> person.getId().equals(id))
                .forEach(PersonDaoImpl::removePerson);

    }
}
