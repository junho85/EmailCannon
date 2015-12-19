package kr.pe.junho85.service.impl;

import kr.pe.junho85.hello.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SendServiceGmail2ImplTest {
    @Autowired
    SendServiceGmail2Impl service;

    @Test
    public void testSend() throws Exception {
        service.send();
    }
}