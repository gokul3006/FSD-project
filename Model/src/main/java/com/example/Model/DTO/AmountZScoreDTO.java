package com.example.Model.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AmountZScoreDTO {
private Double amount;
private Double zscore;

@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
private LocalDateTime dateTime;
private Boolean isSuspicious;
public AmountZScoreDTO()
{
}

public AmountZScoreDTO(Double amount, Double zscore, LocalDateTime dateTime, Boolean isSuspicious) {
	super();
	this.amount = amount;
	this.zscore = zscore;
	this.dateTime = dateTime;
	this.isSuspicious = isSuspicious;
}

public LocalDateTime getDateTime() {
	return dateTime;
}

public void setDateTime(LocalDateTime dateTime) {
	this.dateTime = dateTime;
}

public Boolean getIsSuspicious() {
	return isSuspicious;
}

public void setIsSuspicious(Boolean isSuspicious) {
	this.isSuspicious = isSuspicious;
}

public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public Double getZscore() {
	return zscore;
}
public void setZscore(Double zscore) {
	this.zscore = zscore;
}

}
