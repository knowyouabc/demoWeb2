package com.company.demoWeb2.service;

import com.company.demoWeb2.aspect.MyProxyService;
import com.company.demoWeb2.common.vo.PersonVO;
import com.company.demoWeb2.mapper.PersonMapper;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public PersonVO getPerson() throws SQLException {
        List<PersonVO> personVOList = new ArrayList<>();

        personVOList = personDao.getPersonList();

//        redisUtil.set("person", personVOList.get(0));
//        redisUtil.get("person");

        return personVOList.get(0);
    }

}
