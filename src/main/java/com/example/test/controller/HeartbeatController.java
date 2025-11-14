package com.example.test.controller;
import com.example.test.HeartbeatSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {

    @Autowired
    private HeartbeatSensor hbsensor;

    @GetMapping("/heartbeat")
    public int getHeartbeat() {
        return hbsensor.get();
    }
}
