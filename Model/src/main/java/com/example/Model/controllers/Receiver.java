package com.example.Model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.DTO.AmountZScoreDTO;
import com.example.Model.DTO.TransactionDTO;
import com.example.Model.Service.TransactionService;

@RestController
@RequestMapping("Model")
public class Receiver {
	@Autowired
    private TransactionService transactionService;
    
    @PostMapping("/process-data")
    public String processDataFromServiceA(@RequestBody TransactionDTO data) {
    	System.out.println(data.getTimestamp());
    	transactionService.calculate(data.getAmount(),data.getTimestamp());
        return "Data processed successfully";
    }
    
    @GetMapping("/data")
    public ResponseEntity<List<AmountZScoreDTO>> getData()
    {
    	return ResponseEntity.status(HttpStatus.OK).body(transactionService.getDatas());
    }
}

