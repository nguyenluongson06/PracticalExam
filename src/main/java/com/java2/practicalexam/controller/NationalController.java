package com.java2.practicalexam.controller;

import com.java2.practicalexam.service.NationalService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/national")
public class NationalController {
    private final NationalService nationalService;
    public NationalController(NationalService nationalService) {
        this.nationalService = nationalService;
    }


}
