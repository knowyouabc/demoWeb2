package com.company.demoWeb2.dao;

import com.company.demoWeb2.common.so.PersonSO;
import com.company.demoWeb2.common.vo.PersonVO;
import com.company.demoWeb2.entity.Person;
import com.company.demoWeb2.dao.PersonDao;
import com.company.demoWeb2.mapper.PersonMapper;
import com.company.demoWeb2.util.OrikaBeanMapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao{

    @Autowired
    private QueryRunner queryRunner;

    @Autowired
    private PersonMapper personMapper;

    @Resource
    protected OrikaBeanMapper orikaBeanMapper;

    @Override
    public List<PersonVO> getPersonList() throws SQLException {
        String sql = "select * from testT";
        List<Person> personList = new ArrayList<>();
//        personList = queryRunner.query(sql, new BeanListHandler<Person>(Person.class));
        personList = personMapper.findAll();
        System.out.println("查询到数据库数据："+personList.size());
        return orikaBeanMapper.convertList(personList, PersonVO.class);
    }
}
