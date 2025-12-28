package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.repository.AttendanceRepository;


import com.examly.springapp.model.Attendance;


@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance getAttendanceById(Long id) {
          return attendanceRepository.findById(id).orElse(null);
    }

    @Override
    public List getAllAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance updateAttendance(Long id, Attendance attendance) {
        attendance.setAttendanceId(id);
        return attendanceRepository.save(attendance);
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
