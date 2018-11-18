package com.wcc.threadtest.generator;

import com.wcc.threadtest.model.Detail;
import com.wcc.threadtest.model.Person;
import com.wcc.threadtest.model.Sex;
import com.wcc.threadtest.repository.DetailRepository;
import com.wcc.threadtest.threadtest.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import lombok.Data;


@Component
public class DetailGenerator implements Generator {

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private RandomService r;

    @Override
    public Person generate(Person person) {
        foo();
        Detail d = new Detail();
        d.setAge(r.getRandomInt());
        d.setLength(r.getRandomFloat());
        d.setWeight(r.getRandomFloat());
        d.setSalary(r.getRandomFloat());
        d.setSex(Sex.getRandom());

        detailRepository.save(d);
        person.setInfo(d);

        //System.out.print("D");

        return person;
    }
}
