package com.tejait.batch16.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.tejait.batch16.model.TransactionHistory;
import com.tejait.batch16.repository.TransactionRepository;
import com.tejait.batch16.service.TransactionsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionsServiceImpl implements TransactionsService{
	
	private final List<TransactionHistory> transactionList = new ArrayList<>();
	
	TransactionRepository repository;

	@Override
	public List<TransactionHistory> readTransactionsCSV(MultipartFile file) throws CsvValidationException, IOException {
		
		transactionList.clear();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
		
		CSVReader csvReader = new CSVReader(reader);
		
		String[] row;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		
		csvReader.readNext();
		
		while((row=csvReader.readNext())!=null) {
			TransactionHistory transaction = new TransactionHistory();
			
			 try {
			        Date transactionDate = sdf.parse(row[0].trim());
			        transaction.setTransactionDate(transactionDate);
			    } catch (ParseException e) {
			        e.printStackTrace();
			        continue; // Skip this row if date is invalid
			    }
			 
			   transaction.setActivity(row[1]);
			   transaction.setSource(row[2]);
			   transaction.setTxnId(Long.parseLong(row[3]));
			   transaction.setComment(row[4]);
			   transaction.setDebtAmt(row[5].isBlank() ? 0.0 : Double.parseDouble(row[5]));
			   transaction.setCreditAmt(row[6].isBlank() ? 0.0 : Double.parseDouble(row[6]));
			   transaction.setTransactionBreakup(row[7]);
			   transaction.setTransactionStatus(row[8]);
			   
			   transactionList.add(transaction);
		}
		csvReader.close();
		return transactionList;
	}

	@Override
	public List<TransactionHistory> getTxnsData(Integer appId) {
		
		return repository.findByAppid(appId);
	}

	@Override
	public List<TransactionHistory> saveTxnsData(Integer appId, List<TransactionHistory> saveList) {
		
		for(TransactionHistory history:saveList) {
			history.setAppid(appId);
		}
		repository.saveAll(saveList);
		return repository.findByAppid(appId);
		
	}
	

}
