package com.example.Model.DTO;

import java.time.LocalDateTime;

public class TransactionDTO {
private Double amount;
private LocalDateTime timestamp;
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public LocalDateTime getTimestamp() {
	return timestamp;
}
public void setTimestamp(LocalDateTime timestamp) {
	this.timestamp = timestamp;
}

}