package co.wethinkcode.shoutout.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.wethinkcode.shoutout.model.Shoutout;

@RestController
@RequestMapping("/api/shoutouts")
public class ShoutoutController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping
    public ResponseEntity<Map<String, String>> sendShoutout(@RequestBody Shoutout shoutout) {
        // Send JSON payload asynchronously to the JMS queue
        jmsTemplate.convertAndSend("school-shoutouts-queue", shoutout);

        // Immediate HTTP 202 Accepted response back to user
        return ResponseEntity.accepted().body(Map.of(
            "status", "SUCCESS",
            "info", "Shoutout submitted and queued for moderation!"
        ));
    }
}