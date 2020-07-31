package com.company.demoWeb2.mapper;

import com.company.demoWeb2.entity.Person;

import java.io.IOException;
import java.util.List;

public interface PersonMapper {

    public List<Person> findAll() throws IOException;

}
