package com.us.bizs;

import com.us.bizs.service.hr.UsUserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsBizsApplicationTests {

    @Autowired
    private UsUserService usUserService;


    public void getTest() {
        usUserService.test();
    }

}
