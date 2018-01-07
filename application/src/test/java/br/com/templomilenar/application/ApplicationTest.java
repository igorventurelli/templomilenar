package br.com.templomilenar.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Test
    public void applicationContextLoaded() {

    }

    @Test
    public void applicationContext() {
        Application.main(new String[] {});
    }
}
