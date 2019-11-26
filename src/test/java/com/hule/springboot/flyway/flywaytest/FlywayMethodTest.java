package com.hule.springboot.flyway.flywaytest;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.test.FlywayTestExecutionListener;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@RunWith(SpringRunner.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        FlywayTestExecutionListener.class
})
class FlywayMethodTest {

    @LocalServerPort
    private int port;

    @Autowired
    private UserRepository repository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @FlywayTest
    void contextLoads() {
        assertThat(repository.findAll().size(), is(3));
    }

    @Test
    void contextLoads1() {
        assertThat(repository.findAll().size(), is(3));
    }

    @Test
    void contextLoads2() {
        log.error("hule " + port);
        Users users = new Users();
        users.setCareer("aaa");
        users.setId(13);
        users.setFirstName("first");
        users.setLastName("last");
        repository.save(users);
        assertThat(repository.findAll().size(), is(4));
    }

}
