package com.example.HAndbook.demo.controllers;


import com.example.HAndbook.demo.entity.Operator;
import com.example.HAndbook.demo.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/operator/")
public class OperatorRestController {
    private final OperatorService operatorService;
@Autowired
    public OperatorRestController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping(value = "/operator/{id}")
    public ResponseEntity<Operator> getOperatorByOperatorId(@PathVariable("id") Long operatorId) {
        Optional<Operator> operatorData = operatorService.findByOperatorId(operatorId);
        return operatorData.map(operator -> new ResponseEntity<>(operator, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/operator/code")
    public ResponseEntity<Operator> getOperatorByCode(@RequestBody Operator operator, @PathVariable Integer operatorCode) {
        Optional<Operator> operatorData = operatorService.findByOperatorCode(operatorCode);
        return operatorData.map(Operator -> new ResponseEntity<>(operator, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping(value = "/operator/{id}")
    public ResponseEntity<HttpStatus> deleteOperatorId(@PathVariable("id") Long operatorId) {
        try {
            operatorService.deleteByOperatorId(operatorId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }}
    @PostMapping("/operator")
    public ResponseEntity<Operator> createOperator(@RequestBody Operator operator) {
        operatorService.saveOperator(String.valueOf(operator));
        return new ResponseEntity<>(HttpStatus.CREATED);
}}

