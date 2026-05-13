package com.base.service.Listener;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.camunda.bpm.engine.delegate.TaskListener;

import java.util.HashMap;
import java.util.Map;
@Component("taskAssignListener")
public class TaskAssignListener  implements TaskListener {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${socket.url}")
    private String socketUrl;

    @Override
    public void notify(
            DelegateTask delegateTask) {

        String assignee =
                delegateTask.getAssignee();

        Map<String, Object> body =
                new HashMap<>();

        body.put("username", assignee);

        body.put(
                "processInstanceId",
                delegateTask.getProcessInstanceId()
        );

        body.put(
                "taskId",
                delegateTask.getId()
        );
        String position = (String)
                delegateTask.getVariable("position");

        body.put(
                "taskName",
                position
        );
        System.out.println(
                "TASK CREATED"
        );

        System.out.println(
                delegateTask.getAssignee()
        );

        restTemplate.postForEntity(socketUrl+
                "/notify/assign",
                body,
                Void.class
        );
    }
}
