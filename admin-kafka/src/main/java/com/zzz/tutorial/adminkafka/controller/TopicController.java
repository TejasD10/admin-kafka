package com.zzz.tutorial.adminkafka.controller;

import com.zzz.tutorial.adminkafka.service.ListTopics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private ListTopics topicService;

    @RequestMapping("/topics")
    public List<String> getTopics(){
        return topicService.getAllTopics();
    }

    public ListTopics getTopicService() {
        return topicService;
    }

    public void setTopicService(ListTopics topicService) {
        this.topicService = topicService;
    }
}
