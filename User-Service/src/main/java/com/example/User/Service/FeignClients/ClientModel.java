package com.example.User.Service.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.User.Service.controllers.TransactionDTO;

@FeignClient(name="model")
public interface ClientModel {
	
	@PostMapping("/Model/process-data")
	String processTransaction(@RequestBody TransactionDTO transaction);

}
