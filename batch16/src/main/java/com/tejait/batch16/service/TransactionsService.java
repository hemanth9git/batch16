package com.tejait.batch16.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.opencsv.exceptions.CsvValidationException;
import com.tejait.batch16.model.TransactionHistory;

public interface TransactionsService {

	List<TransactionHistory> readTransactionsCSV(MultipartFile file) throws CsvValidationException, IOException;

	List<TransactionHistory> getTxnsData(Integer appId);

	List<TransactionHistory> saveTxnsData(Integer appId, List<TransactionHistory> saveList);

}
