package com.akash.one.Controller;

import com.akash.one.Service.PersonService;
import com.akash.one.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonCtrl {

    @Autowired
    private PersonService personService;


    @GetMapping("/getbyid/{id}")
    public Person byId(@PathVariable("id") String strId) {
        int id = Integer.parseInt(strId);
        return personService.getById(id);
    }

    @GetMapping("/save")
    public String save(@RequestBody Person person) {

        personService.savePerson(person);
        return "Person is saved";
    }

    @GetMapping("/all")
    public List<Person> all() {
        return personService.getAll();
    }

    @DeleteMapping("/delbyid/{id}")
    public String delById(@PathVariable("id") String strId) {
        int id = Integer.parseInt(strId);
        return personService.delById(id);
    }

    @PutMapping("/udpatebyid/{id}")
    public String updateById(@PathVariable("id") String strId, @RequestBody Person person) {
        int id = Integer.parseInt(strId);
        return personService.updatePerson(id, person);
    }


}
