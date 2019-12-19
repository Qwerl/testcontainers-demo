package com.technokratos.demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = Application.class, initializers = MongoInitializer.class)
public class MongoTest {

    //тут уже можно работать с репами, которые используют эту монгу
    //@Autowired
    //MongoRepository repo;

}
