package com.zzz.tutorial.adminkafka;

import com.zzz.tutorial.adminkafka.service.ListTopics;
import org.apache.kafka.clients.admin.AdminClient;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ImportResource(locations = "classpath:application-test.properties")
public class AdminKafkaApplicationTests {

    private AdminClient adminClient;

    @Test
    public void contextLoads() {
    }

    @Ignore
    @Test
    public void getListTopicsshouldreturnList(){
        ListTopics topics = new ListTopics();

    }
}
