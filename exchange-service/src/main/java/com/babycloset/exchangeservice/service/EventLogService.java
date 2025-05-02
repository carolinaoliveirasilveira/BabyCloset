package com.babycloset.exchangeservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class EventLogService {

    private final List<String> events = new ArrayList<>();

    public void add(String event) {
        events.add(event);
    }

    public List<String> getAll() {
        return events;
    }
}
