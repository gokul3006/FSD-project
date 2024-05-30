package com.example.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Model.DTO.AmountZScoreDTO;
import com.example.Model.Entity.Transactions;

@Repository
public interface TransactionRepo extends JpaRepository<Transactions,Integer> {


@Query("SELECT t.amount FROM Transactions t ORDER BY t.timeStamp DESC")
public List<Double> findLatestHundredTransactions();

@Query("SELECT new com.example.Model.DTO.AmountZScoreDTO(t.amount,t.zScore,t.timeStamp,t.isSuspicious) FROM Transactions t")
public List<AmountZScoreDTO> getData();
}
