package com.babycloset.exchangeservice.controller;

import com.babycloset.exchangeservice.service.EventLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventLogController {

    private final EventLogService eventLogService;

    @GetMapping
    public List<String> getAllEvents() {
        return eventLogService.getAll();
    }
}
