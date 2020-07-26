package com.company.demoWeb2.service.serviceImpl;

import com.company.demoWeb2.aspect.MyProxyService;
import com.company.demoWeb2.service.PersonService;
import com.company.demoWeb2.entity.Person;
import com.company.demoWeb2.dao.PersonDao;
import com.company.demoWeb2.util.RedisUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private QueryRunner queryRunner;

    @Override
    public Person getPerson() throws SQLException {

        String sql = "select * from testT";
        List<Person> list= queryRunner.query(sql, new BeanListHandler<Person>(Person.class));


        Person person = personDao.getPerson();

        redisUtil.set("person", person);
        redisUtil.get("person");

        return person;
    }

}
