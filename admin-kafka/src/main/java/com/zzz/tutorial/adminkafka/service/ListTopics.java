package com.zzz.tutorial.adminkafka.service;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.TopicListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

@Component
public class ListTopics {

    @Autowired
    private AdminClient kafkaAdmin;

    private static Logger log = Logger.getLogger(ListTopics.class.getName());

    public List<String> getAllTopics(){
        ListTopicsResult result = kafkaAdmin.listTopics();
        Collection<TopicListing> topiclisting = null;
        try {
            topiclisting = result.listings().get();
        } catch (InterruptedException e) {
            log.warning("Error occured getting the topic:" + e);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        List<String> topicNames = new ArrayList<>();
        for (TopicListing item : topiclisting) {
            topicNames.add(item.name());
        }
        return topicNames;
    }

    public AdminClient getKafkaAdmin() {
        return kafkaAdmin;
    }

    public void setKafkaAdmin(AdminClient kafkaAdmin) {
        this.kafkaAdmin = kafkaAdmin;
    }
}
