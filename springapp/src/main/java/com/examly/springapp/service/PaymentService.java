package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.examly.springapp.model.Payment;

public interface PaymentService {
    List<Payment> getAllPayments(Pageable pageable);
}

