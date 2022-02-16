package com.example.HAndbook.demo.service;

import com.example.HAndbook.demo.entity.Operator;

import java.util.List;
import java.util.Optional;

public interface OperatorService {
    Operator findByOperatorId(Long operatorId);
    void deleteOperatorByOperatorId(Long operatorId);
    void saveOperator(Operator operator);
}
