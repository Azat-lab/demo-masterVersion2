package com.example.HAndbook.demo.service;

import com.example.HAndbook.demo.entity.Operator;

import java.util.List;
import java.util.Optional;

public interface OperatorService {
    Optional<Operator> findByOperatorId(Long operatorId);
    Optional<Operator> findByOperatorCode(Integer operatorCode);
    void deleteByOperatorId(Long operatorId);
    List<Operator> saveOperator(String operatorCountry);
}
