package com.example.Model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.example.Model.DTO.AmountZScoreDTO;
import com.example.Model.Entity.Transactions;
import com.example.Model.Repository.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepo transactionRepo;

	public List<Double> getData() {
		return transactionRepo.findLatestHundredTransactions();
	}

	public static double calculateMean(List<Double> data) {
		double sum = 0.0;
		for (double num : data) {
			sum += num;
		}
		return sum / data.size();
	}

	public static double calculateStandardDeviation(List<Double> data, double mean) {
		double sumSquaredDifferences = 0.0;
		for (double num : data) {
			sumSquaredDifferences += Math.pow(num - mean, 2);
		}
		return Math.sqrt(sumSquaredDifferences / data.size());
	}

	public static boolean isOutlier(double zScore, double threshold) {
		return Math.abs(zScore) > threshold;
	}

	public static Double calculateZScores(List<Double> data) {
		double mean = calculateMean(data);
		double standardDeviation = calculateStandardDeviation(data, mean);

		List<Double> zScores = new ArrayList<>();
		for (double num : data) {
			double zScore = (num - mean) / standardDeviation;
			zScores.add(zScore);
		}
		return zScores.get(zScores.size() - 1);
	}

	public void calculate(Double amount, LocalDateTime dateTime) {
		List<Double> data = getData();
		System.out.println(data);
		data.add(amount);
		Double zscore = calculateZScores(data);
		boolean susPecious = false;
		if (amount >= 500000)
		{
			susPecious = true;
		}
		else if(dateTime.getHour()<9 || dateTime.getHour()>17)
		{
			if(amount>200000)
			{
				susPecious=true;
			}
			else
			{
				susPecious=false;
			}
		}
		else {
			susPecious = isOutlier(zscore, 2);
		}
		Transactions transaction = new Transactions();
		transaction.setAmount(amount);
		transaction.setSuspicious(susPecious);
		transaction.setTimeStamp(dateTime);
		transaction.setzScore(zscore);
		transactionRepo.save(transaction);
	}
	
	public List<AmountZScoreDTO> getDatas()
	{
		return transactionRepo.getData();
	}

}
