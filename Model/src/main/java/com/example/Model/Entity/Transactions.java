package com.example.Model.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Transactions {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int transactionId;
private Double amount;
private LocalDateTime timeStamp;
private Double zScore;
private boolean isSuspicious;

public Transactions() {
	super();
}
public int getTransactionId() {
	return transactionId;
}
public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public LocalDateTime getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(LocalDateTime timeStamp) {
	this.timeStamp = timeStamp;
}
public Double getzScore() {
	return zScore;
}
public void setzScore(Double zScore) {
    if (zScore != null && !Double.isNaN(zScore)) {
        this.zScore = zScore;
    } else {
        // Handle NaN case, set to null or default value
        this.zScore = 0.0; // or this.zScore = someDefaultValue;
    }
}
public boolean isSuspicious() {
	return isSuspicious;
}
public void setSuspicious(boolean isSuspicious) {
	this.isSuspicious = isSuspicious;
}


}
