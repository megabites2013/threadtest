package com.wcc.threadtest.controller;

import com.wcc.threadtest.generator.Generator;
import com.wcc.threadtest.model.Person;
import com.wcc.threadtest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Controller
public class PersonController {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private List<Generator> generators;

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private com.wcc.threadtest.threadtest.service.RandomService r;


    public Person createPerson(String s) {


        List<Generator> b = new ArrayList<Generator>(generators);

        Person p = new Person();
        p.setFName(s);
        p.setSurName(s);
        p.setBirthDay(r.getRandomDate());


        for (Generator generator : b) {

            p=generator.generate(p);


        }


        personRepository.save(p);

        return p;
    }

    public Person createPersonFork(String s) {

        List<Generator> b = new ArrayList<Generator>(generators);

        Person p = new Person();
        p.setFName(s);
        p.setSurName(s);
        p.setBirthDay(r.getRandomDate());

        b.parallelStream().forEach(g -> g.generate(p));

        personRepository.save(p);

        return p;
    }






}
