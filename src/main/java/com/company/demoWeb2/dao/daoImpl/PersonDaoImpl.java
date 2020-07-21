package com.company.demoWeb2.dao.daoImpl;

import com.company.demoWeb2.entity.Person;
import com.company.demoWeb2.dao.PersonDao;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao{

    @Override
    public Person getPerson() {
        Person person = new Person();
        person.setName("aa");
        return person;
    }
}
