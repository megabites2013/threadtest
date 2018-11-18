package com.wcc.threadtest.service;

import com.wcc.threadtest.controller.PersonController;
import com.wcc.threadtest.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

@Slf4j
@Service
public class InitService {

  @Autowired private ExecutorService executorService;

  @Autowired private com.wcc.threadtest.threadtest.service.RandomService r;

  @Autowired private PersonController controller;

  private int howManyGroups = 288;

  private Map<Integer, List<Person>> works;

  public InitService() {
    works = new HashMap();
  }

  public void populateDB() {

    long startTime = System.nanoTime();
    long count = 0;

    while (howManyGroups > 0) {

      getPeoplesParallel(howManyGroups);
      howManyGroups--;
    }
    long endTime = System.nanoTime();

    for (List<Person> list : works.values()) {
      count += list.size();
    }

    log.info(
        "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ done = " + count + "  in " + (endTime - startTime));
  }

  private void getPeoplesParallel(int howManyGroups) {

    executorService.submit(
        () -> {
          getPeoples(howManyGroups);
        });
  }

  public void getPeoples(int howManyGroups) {
    List<Person> ps = new ArrayList<>();

    Long numbers = r.getRandomLong();

    if (howManyGroups == 1 || howManyGroups == 200 || howManyGroups == 100) {
      numbers = 10000L;
    } else {
      numbers = 30L;
    }

    log.info("---------Group No:" + howManyGroups + " --------------> " + numbers + " Persons");

    while (numbers > 0) {

      ps.add(controller.createPerson("" + howManyGroups + "-" + numbers));
      numbers--;
    }

    log.info("++++++++++++ created " + ps.size() + " for Group No: " + howManyGroups + " +++ ");
    works.put(howManyGroups, ps);
  }

  public void getPeoplesFork(int howManyGroups) {
    List<Person> ps = new ArrayList<>();

    Long numbers = r.getRandomLong();

    if (howManyGroups == 1 || howManyGroups == 200 || howManyGroups == 100) {
      numbers = 10000L;
    } else {
      numbers = 30L;
    }

    log.info("---------Group No:" + howManyGroups + " --------------> " + numbers + " Persons");

    while (numbers > 0) {

      ps.add(controller.createPersonFork("" + howManyGroups + "-" + numbers));
      numbers--;
    }

    log.info("++++++++++++ created " + ps.size() + " for Group No: " + howManyGroups + " +++ ");
    works.put(howManyGroups, ps);
  }
}
