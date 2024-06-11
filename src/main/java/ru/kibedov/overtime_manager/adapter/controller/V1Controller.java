package ru.kibedov.overtime_manager.adapter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class V1Controller {

    @GetMapping
    public String get(@RequestParam String s) {
        return s;
    }
}
