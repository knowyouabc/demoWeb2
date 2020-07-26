package com.company.demoWeb2.service.serviceImpl;

import com.company.demoWeb2.aspect.MyProxyService;
import com.company.demoWeb2.service.PersonService;
import com.company.demoWeb2.entity.Person;
import com.company.demoWeb2.dao.PersonDao;
import com.company.demoWeb2.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Person getPerson() {

        Person person = personDao.getPerson();

        redisUtil.set("person", person);
        redisUtil.get("person");

        return person;
    }

}
