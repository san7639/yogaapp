package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    @RequestMapping("/{id}")
    public String getMembership(@PathVariable Long id) {
        return "Membership";
    }
}
