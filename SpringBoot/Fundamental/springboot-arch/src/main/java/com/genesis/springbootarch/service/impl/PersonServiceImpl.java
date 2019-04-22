package com.genesis.springbootarch.service.impl;

import com.genesis.springbootarch.domain.data.Person;
import com.genesis.springbootarch.domain.helper.ResponseHelper;
import com.genesis.springbootarch.domain.response.PersonResponse;
import com.genesis.springbootarch.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * @author: KG
 * @description:
 * @date: Created in 5:42 PM 2019/4/13
 * @modified by:
 */

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public PersonResponse getPerson() {

        PersonResponse response = new PersonResponse();

        Person person = new Person();
        person.setName("KG");
        person.setAge(35);

        ResponseHelper.success(response, person);

        return response;
    }
}


