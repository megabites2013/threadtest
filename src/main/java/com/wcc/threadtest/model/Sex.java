package com.wcc.threadtest.model;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Sex {
    Male,Female,Unkown,Both,WontTell;

    private static final List<Sex> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Sex getRandom()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

}
