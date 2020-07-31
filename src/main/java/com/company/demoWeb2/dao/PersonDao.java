package com.company.demoWeb2.dao;

import com.company.demoWeb2.common.vo.PersonVO;
import com.company.demoWeb2.entity.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {
    List<PersonVO> getPersonList() throws SQLException;
}
