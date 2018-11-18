package com.wcc.threadtest.threadtest.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Calendar.*;


@Component
public class RandomService {

    public int getRandomInt() {

        return ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE );
    }

    public long getRandomLong() {

        return ThreadLocalRandom.current().nextLong(10, 20 );
    }


    public float getRandomFloat() {

        return ThreadLocalRandom.current().nextFloat();
    }

  public Date getRandomDate() {

      GregorianCalendar gc = new GregorianCalendar();

      int year = randBetween(1900, 2010);

      gc.set(YEAR, year);

      int dayOfYear = randBetween(1, gc.getActualMaximum(DAY_OF_YEAR));

      gc.set(DAY_OF_YEAR, dayOfYear);

      //System.out.println(gc.get(YEAR) + "-" + (gc.get(MONTH) + 1) + "-" + gc.get(DAY_OF_MONTH));

      return gc.getTime();

  }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}


