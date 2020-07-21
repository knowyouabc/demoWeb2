package com.company.demoWeb2.controller;


import com.company.demoWeb2.entity.Person;
import com.company.demoWeb2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "getPerson", method = RequestMethod.GET)
    public Person getPerson() {
        return personService.getPerson();
    }

    @RequestMapping(value = "getString", method = RequestMethod.GET)
    public String getString() {
        return "aa";
    }
}
