package com.wcc.threadtest;

import com.wcc.threadtest.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    private InitService inits;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        inits.populateDB();
    }
}
