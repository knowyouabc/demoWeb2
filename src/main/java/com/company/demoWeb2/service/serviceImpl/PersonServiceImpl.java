package com.company.demoWeb2.service.serviceImpl;

import com.company.demoWeb2.service.PersonService;
import com.company.demoWeb2.entity.Person;
import com.company.demoWeb2.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

//    @Autowired
//    private PersonDao personDao;

    @Override
    public Person getPerson() {
        Person person = new Person();
        person.setName("bb");
//        Person person = personDao.getPerson();
        return person;
    }
}
