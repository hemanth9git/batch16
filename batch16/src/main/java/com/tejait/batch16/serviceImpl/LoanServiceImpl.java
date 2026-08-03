package com.tejait.batch16.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.tejait.batch16.Batch16Application;
import com.tejait.batch16.dto.Overview;
import com.tejait.batch16.exceptions.DetailsAlreadyExists;
import com.tejait.batch16.exceptions.IdNotFoundException;
import com.tejait.batch16.model.BusinessProduct;
import com.tejait.batch16.model.CompanyAddress;
import com.tejait.batch16.model.CompanyDetails;
import com.tejait.batch16.model.LoanApplication;
import com.tejait.batch16.model.PersonDetails;
import com.tejait.batch16.model.SalesReport;
import com.tejait.batch16.model.TransactionHistory;
import com.tejait.batch16.repository.BusinessProductRepository;
import com.tejait.batch16.repository.CompanyAddressRepository;
import com.tejait.batch16.repository.CompanyDetailsRepository;
import com.tejait.batch16.repository.LoanRepository;
import com.tejait.batch16.repository.PersonDetailsRepository;
import com.tejait.batch16.repository.SalesRepository;
import com.tejait.batch16.repository.TransactionRepository;
import com.tejait.batch16.service.LoanService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService{
	
	 private final List<SalesReport> list = new ArrayList<>();
	 private final List<TransactionHistory> transactionList = new ArrayList<>();
	
	public static final Logger logger=LogManager.getLogger(Batch16Application.class);

	LoanRepository repository;
	BusinessProductRepository productRepository;
	CompanyDetailsRepository detailsRepository;
	CompanyAddressRepository addressRepository;
	TransactionRepository transactionRepository;
	
	PersonDetailsRepository personRepository;
	SalesRepository salesRepository;

	@Override
	public Overview getOverviewDetails(Integer appId) {
		
		LoanApplication loanApplication=repository.findById(appId).get();
		BusinessProduct businessProduct=productRepository.findByAppid(appId);
		CompanyDetails companyDetails=detailsRepository.findByAppId(appId);
		
		Overview overview = new Overview();
		overview.setAppId(appId);
		overview.setCompanyName(companyDetails.getCompanyName());
		overview.setCompanyPan(companyDetails.getCompanyPan());
		overview.setLoanAmt(businessProduct.getLoanAmount());
		overview.setMail(loanApplication.getMailId());
		overview.setMobile(loanApplication.getMobile());
		overview.setTenure(businessProduct.getTenure());
		return overview;
	}
	
	
	@Override
	public LoanApplication applyLoan(LoanApplication loan) {
		loan.setCustomerName(loan.getFname().concat(" "+loan.getLname()));
		
		String mail=loan.getMailId();
		long mobileNumber=loan.getMobile();
		
		LoanApplication findByEmail=repository.findByMailId(mail);
		if(findByEmail!=null) {
			throw new DetailsAlreadyExists("Mail Id already exists try with other mailId");
		}
		
		LoanApplication findByMobile=repository.findByMobile(mobileNumber);
		if(findByMobile!=null) {
			throw new DetailsAlreadyExists("Mobile number already exists try with other mobile..");
		}
		
		
		return repository.save(loan);
	}

	@Override
	public List<LoanApplication> LoansList() {
		
		return repository.findAll();
	}

	@Override
	public LoanApplication getLoanDetails(Integer appId) {
		
		return repository.findById(appId).orElseThrow(IdNotFoundException::new);
	}

	@Override
	public BusinessProduct saveBusinessProductDetails(BusinessProduct product) {
		
		BusinessProduct getProduct=productRepository.findByAppid(product.getAppid());
		
		if(getProduct!=null) {
			
			getProduct.setLoanAmount(product.getLoanAmount());
			getProduct.setNatureOfBusiness(product.getNatureOfBusiness());
			getProduct.setPurposeOfLoan(product.getPurposeOfLoan());
			getProduct.setTenure(product.getTenure());
			
			return productRepository.save(getProduct);
		}else {
			return productRepository.save(product);
		}
	
	}

	@Override
	public CompanyDetails saveCompanyDetails(CompanyDetails companyDetails) {
		CompanyDetails savedDetails=detailsRepository.findByAppId(companyDetails.getAppId());
		if(savedDetails!=null) {
			savedDetails.setCompanyName(companyDetails.getCompanyName());
			savedDetails.setCompanyPan(companyDetails.getCompanyPan());
			savedDetails.setDateOfEstablish(companyDetails.getDateOfEstablish());
			savedDetails.setGstin(companyDetails.getGstin());
			savedDetails.setTurnover(companyDetails.getTurnover());
			return detailsRepository.save(savedDetails);
		}
		return detailsRepository.save(companyDetails);
		
	}

	@Override
	public CompanyDetails getCompanyDetails(Integer appId) {
		
		return detailsRepository.findByAppId(appId);
	}

	@Override
	public CompanyAddress saveCompanyAddress(CompanyAddress address) {
		CompanyAddress gotAddress=addressRepository.findByAppId(address.getAppId());
		if(gotAddress!=null) {
			gotAddress.setArea(address.getArea());
			gotAddress.setBuilding(address.getBuilding());
			gotAddress.setCity(address.getBuilding());
			gotAddress.setFlatNum(address.getFlatNum());
			gotAddress.setLandmark(address.getLandmark());
			gotAddress.setLine(address.getLine());
			gotAddress.setPincode(address.getPincode());
			gotAddress.setState(address.getState());
			
			return addressRepository.save(gotAddress);
		}
		return addressRepository.save(address);
	}

	@Override
	public CompanyAddress getCompanyAddress(Integer appId) {
		
		return addressRepository.findByAppId(appId);
	}


	@Override
	public BusinessProduct getProductDetails(Integer appId) {
		
		return productRepository.findByAppid(appId);
	}





	@Override
	public List<PersonDetails> readJson(MultipartFile file) throws StreamReadException, DatabindException, IOException {
	   
	     ObjectMapper mapper = new ObjectMapper();
	    List<PersonDetails> savedList= Arrays.asList(mapper.readValue(file.getInputStream(), PersonDetails[].class));
	    return savedList;
	}


	@Override
	public List<PersonDetails> getPersonDetails(Integer appId) {
		
		return personRepository.findByAppid(appId);
	}


	@Override
	public List<PersonDetails> savePersonDataList(List<PersonDetails> persons, Integer appId) {
		if (persons == null || persons.isEmpty()) {
            return Collections.emptyList();
        }

        // 1. Assign the appId to each PersonDetails object
        for (PersonDetails person : persons) {
            person.setAppid(appId);
        }

        // 2. saveAll() returns the saved List<PersonDetails> with generated IDs
        return personRepository.saveAll(persons);
	}


	
	
	@Override
	public List<SalesReport> readExcel(MultipartFile file) throws IOException {

		list.clear();

	    XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());

	    XSSFSheet sheet = workbook.getSheetAt(0);

	    DataFormatter formatter = new DataFormatter();

	    FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

	    for (int i = 6; i < 18; i++) {

	        logger.info("Reading Row : {}", i + 1);

	        Row row = sheet.getRow(i);

	        if (row == null) {
	            continue;
	        }
	        SalesReport sales = new SalesReport();
	        

	        

	        // Date
	        Cell dateCell = row.getCell(0);
	        if (dateCell != null) {
	            sales.setDate(dateCell.getDateCellValue());
	        }

	        // Order Number
	        sales.setOrderno(
	                Integer.parseInt(formatter.formatCellValue(row.getCell(1), evaluator)));

	        // Invoice Number
	        sales.setInvoiceno(
	                formatter.formatCellValue(row.getCell(2), evaluator));

	        // Party Name
	        sales.setPartyName(
	                formatter.formatCellValue(row.getCell(3), evaluator));

	        // Party Phone Number
	        logger.info("Phone Number : {}", formatter.formatCellValue(row.getCell(5), evaluator));

	        sales.setPartyPhoneNum(
	                Long.parseLong(formatter.formatCellValue(row.getCell(5), evaluator)));

	        // Total Amount
	        sales.setTotalAmount(
	                Integer.parseInt(formatter.formatCellValue(row.getCell(7), evaluator)));

	        // Received Amount
	        sales.setRecievedOrPaidAmount(
	                Integer.parseInt(formatter.formatCellValue(row.getCell(9), evaluator)));

	        // Balance Amount
	        sales.setBalanceAmount(
	                Integer.parseInt(formatter.formatCellValue(row.getCell(11), evaluator)));

	        list.add(sales);

	        logger.info("Row {} inserted successfully.", i + 1);
	    }

	    workbook.close();
	   
	    return list;
	}

	@Override
	public List<SalesReport> getSalesReport(Integer appid) {
	
		return salesRepository.findByAppid(appid) ;
	}


	@Override
	public List<SalesReport> saveSalesReport(Integer appId,List<SalesReport> salesReport) {
		for(SalesReport report:salesReport) {
			report.setAppid(appId);
		}
		salesRepository.saveAll(salesReport);
		
		return salesRepository.findByAppid(appId);
	}


	@Override
	public List<TransactionHistory> readTransactionsCSV(MultipartFile file) throws IOException, CsvValidationException {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
		

		CSVReader csvReader = new CSVReader(reader);
		
		String[] row;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		csvReader.readNext();
		
		while((row=csvReader.readNext()) != null) {
			
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
		
		return transactionRepository.findByAppid(appId);
	}


	@Override
	public List<TransactionHistory> saveTxnsData(Integer appId,List<TransactionHistory> saveList) {
		
		for(TransactionHistory history:saveList) {
			history.setAppid(appId);
		}
		transactionRepository.saveAll(transactionList);
		return transactionRepository.findByAppid(appId);
	}


	@Override
	public List<TransactionHistory> getTransactionsFilter(Integer appId, String statusOrInstrument,
			List<String> statusOrInstrumentTypeList) {
		
		List<TransactionHistory> filtered = new ArrayList<>();
		
		List<TransactionHistory> transactions = transactionRepository.findByAppid(appId);
		
		if(statusOrInstrument == null || statusOrInstrument.isEmpty()) {
			return transactions;
		}
		
		switch(statusOrInstrument.toLowerCase()) {
		
		case "status":
			
			for(TransactionHistory transactions1:transactions) {
				
				for(String filters:statusOrInstrumentTypeList) {
					
					switch(filters) {
					
					case "SUCCESS":
						if("SUCCESS".equalsIgnoreCase(transactions1.getTransactionStatus())) {
							filtered.add(transactions1);
						}
						break;
						
					case "FAILED":
						if("FAILED".equalsIgnoreCase(transactions1.getTransactionStatus())) {
							filtered.add(transactions1);
						}
						break;
						
					case "PENDING":
						
						if("PENDING".equalsIgnoreCase(transactions1.getTransactionStatus())) {
							filtered.add(transactions1);
						}
						break;
						
					case "CANCELLED":
						if("CANCELLED".equalsIgnoreCase(transactions1.getTransactionStatus())) {
							filtered.add(transactions1);
							break;
						}
						
					}
				}
			}
			break;
			
		case "instrument":
			
			for(TransactionHistory transaction:transactions) {
				for(String filter:statusOrInstrumentTypeList) {
					
					switch(filter) {
					
					case "upi":
						if("upi".equalsIgnoreCase(transaction.getInstrument())) {
							transactions.add(transaction);
						}
						break;
						
					case "wallet":
						if("wallet".equalsIgnoreCase(transaction.getInstrument())) {
							transactions.add(transaction);
						}
						break;
						
					case "creditcard":
						if("creditcard".equalsIgnoreCase(transaction.getInstrument())) {
							transactions.add(transaction);
						}
						break;
						
					case "debitcard":
						if("debitcard".equalsIgnoreCase(transaction.getInstrument())) {
							transactions.add(transaction);
						}
						break;
					}
				}
			}
			break;
		}
		
		return filtered.stream().distinct().toList();
	}
	
	
	
	

	
	
	

	
	
	
}
