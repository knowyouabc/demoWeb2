package com.company.demoWeb2.controller;


import com.company.demoWeb2.common.vo.PersonVO;
import com.company.demoWeb2.entity.Person;
import com.company.demoWeb2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "app")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "getPerson", method = RequestMethod.GET)
    public PersonVO getPerson() throws SQLException, ExecutionException, InterruptedException {
        return personService.getPerson();
    }

    @RequestMapping(value = "getString", method = RequestMethod.GET)
    public String getString() {
        return "aa";
    }
}
