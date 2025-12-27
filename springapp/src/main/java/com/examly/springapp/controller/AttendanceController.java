package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

@RequestMapping("/{id}")
public String getAttendance(@PathVariable Long id) {
return "Attendance";
}
}