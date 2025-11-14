package com.example.test.service;

import com.example.test.HeartbeatSensor;
import org.springframework.stereotype.Service;

@Service
public class RandomHeartBeat implements HeartbeatSensor {
    public int get() {
        return (int) (Math.random() * (120));
    }
}
