package com.technokratos.demo;

import com.technokratos.demo.repository.TestEntity;
import com.technokratos.demo.repository.TestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:tc:postgresql:9.6.8:///test",
    "spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver"
})
public class SimpleDatasourceTest {

    @Autowired
    private TestRepository repository;

    @Test
    void test() {
        long count = repository.count();
        assertEquals(0, count);
    }

    @Test
    void insertTest() {
        int id = 1;
        TestEntity testEntity = repository.save(TestEntity.of(id));
        assertEquals(id, testEntity.getId());
    }

}
