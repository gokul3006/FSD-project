package com.example.User.Service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User.Service.FeignClients.ClientModel;

@RestController
@RequestMapping("user")
public class SenderController {
	@Autowired
    private ClientModel clientModel;


    @PostMapping("/send")
    public ResponseEntity<String> sendDataToServiceB(@RequestBody TransactionDTO data) {

        String responseEntity = clientModel.processTransaction(data);
        return ResponseEntity.status(HttpStatus.OK).body(responseEntity);
    }
}
