package com.akash.one.Service;


import com.akash.one.model.Person;

import java.util.List;

public interface PersonService {

    public void savePerson(Person person);

    public Person getById(int id);

    public String delById(int id);

    public String updatePerson(int id, Person person);

    public List<Person> getAll();
}
