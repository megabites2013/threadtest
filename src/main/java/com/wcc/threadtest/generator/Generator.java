package com.wcc.threadtest.generator;

import com.wcc.threadtest.model.Citizen;
import com.wcc.threadtest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ThreadLocalRandom;

public interface Generator {

    Person generate(Person person);

    default void foo() {
        try {
            if(true) {
                Thread.sleep(ThreadLocalRandom.current().nextLong(1, 5 ));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
