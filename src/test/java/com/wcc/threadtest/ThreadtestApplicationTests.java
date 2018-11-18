package com.wcc.threadtest;

import com.wcc.threadtest.service.InitService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadtestApplicationTests {

  @Autowired private InitService inits;

  @Test
  public void contextLoads() {}

  @Test
  public void testGeneratorSpeed() {

    long startTime = System.nanoTime();
    inits.getPeoples(1);
    long endTime = System.nanoTime();

    log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ done in " + (endTime - startTime));
  }

  @Test
  public void testGeneratorSpeedFork() {

    long startTime = System.nanoTime();
    inits.getPeoplesFork(100);
    long endTime = System.nanoTime();

    log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ done in " + (endTime - startTime));
  }
}
