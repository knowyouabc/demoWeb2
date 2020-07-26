package com.company.demoWeb2.service;

import com.company.demoWeb2.entity.Person;

import java.sql.SQLException;


public interface PersonService {
    Person getPerson() throws SQLException;
}
