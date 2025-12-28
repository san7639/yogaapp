package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Attendance;

public interface AttendanceService {

    Attendance createAttendance(Attendance attendance);

    Attendance getAttendanceById(Long id);

    List<Attendance> getAllAttendance();

    Attendance updateAttendance(Long id, Attendance attendance);

    void deleteAttendance(Long id);

}
