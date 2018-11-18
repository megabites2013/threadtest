package com.wcc.threadtest.generator;

import com.wcc.threadtest.repository.CitizenRepository;
import lombok.Data;

import com.wcc.threadtest.model.Citizen;
import com.wcc.threadtest.model.Person;
import com.wcc.threadtest.threadtest.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CitizenGenerator implements Generator {


    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private RandomService randomService;

    @Override
    public Person generate(Person person) {
        foo();
        Citizen citizen = new Citizen();
        citizen.setCitizenName("Citizen"+randomService.getRandomInt());
        citizen.setFromDate(randomService.getRandomDate());
        citizenRepository.save(citizen);
        person.getCitizen().add(citizen);

        return person;
    }
}
