package com.genesis.springbootarch.service;

import com.genesis.springbootarch.domain.response.PersonResponse;

/**
 * @author: KG
 * @description:
 * @date: Created in 5:40 PM 2019/4/13
 * @modified by:
 */

public interface PersonService {
    /**
     * get person
     * @return
     */
    PersonResponse getPerson();
}

