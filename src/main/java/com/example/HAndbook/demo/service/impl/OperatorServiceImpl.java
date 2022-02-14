package com.example.HAndbook.demo.service.impl;

import com.example.HAndbook.demo.entity.Operator;
import com.example.HAndbook.demo.repository.OperatorRepository;
import com.example.HAndbook.demo.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperatorServiceImpl implements OperatorService {
@Autowired
    OperatorRepository operatorRepository;;

    @Override
    public Optional<Operator> findByOperatorId(Long operatorId) {
        return null;
    }

    @Override
    public Optional<Operator> findByOperatorCode(Integer operatorCode) {
        return null;
    }

    @Override
    public void deleteByOperatorId(Long operatorId) {
        operatorRepository.deleteById(operatorId);
    }
    @Override
    public List<Operator> saveOperator(String operatorCountry) {
        operatorRepository.save(new Operator(saveOperator(operatorCountry))) ;
        return null;
    }
}
