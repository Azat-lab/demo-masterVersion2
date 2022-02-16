package com.example.HAndbook.demo.service.impl;

import com.example.HAndbook.demo.entity.Operator;
import com.example.HAndbook.demo.exception.OperatorNotFoundException;
import com.example.HAndbook.demo.repository.OperatorRepository;
import com.example.HAndbook.demo.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperatorServiceImpl implements OperatorService {
@Autowired
    OperatorRepository operatorRepository;;

    @Override
    public Operator findByOperatorId(Long operatorId) {
        Optional<Operator> optional = operatorRepository.findById(operatorId);
        if(optional.isPresent()) {
            return optional.get();
        }else{
            throw new OperatorNotFoundException("Operator with Id: " + operatorId);
        }
    }
    @Override
    public void deleteOperatorByOperatorId(Long operatorId) {
        operatorRepository.deleteById(operatorId);
    }
    @Override
    public void saveOperator(Operator operator) {
        operatorRepository.save(operator) ;

    }
}
