package com.akash.one.Service;

import com.akash.one.DAO.PersonDAO;
import com.akash.one.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;


    @Override
    public void savePerson(Person person) {
        personDAO.save(person);
    }

    @Override
    public Person getById(int id) {
        if (foundPerson(id))
            return personDAO.findById(id).get();
        else
            return new Person();
    }

    @Override
    public String delById(int id) {
        if (foundPerson(id)) {
            personDAO.deleteById(id);
            return "Person with id " + id + " is deleted";
        } else
            return "Person with id " + id + " is not found";
    }

    @Override
    public String updatePerson(int id, Person person) {

        if (foundPerson(id)) {
            Person oldPerson = personDAO.findById(id).get();
            oldPerson.setName(person.getName());
            personDAO.save(oldPerson);
            return "Person with id " + id + " is updated";
        } else
            return "Person with id " + id + " is not found";
    }

    @Override
    public List<Person> getAll() {
        return personDAO.findAll();
    }

    private boolean foundPerson(int id) {

        try {
            Person oldPerson = personDAO.findById(id).get();
            if (oldPerson != null)
                return true;
            return false;

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return false;
    }
}