package com.tejait.batch16.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.tejait.batch16.dto.Overview;
import com.tejait.batch16.model.BusinessProduct;
import com.tejait.batch16.model.CompanyAddress;
import com.tejait.batch16.model.CompanyDetails;
import com.tejait.batch16.model.LoanApplication;
import com.tejait.batch16.model.PersonDetails;
import com.tejait.batch16.model.SalesReport;

public interface LoanService {


	LoanApplication applyLoan(LoanApplication loan);

	List<LoanApplication> LoansList();

	LoanApplication getLoanDetails(Integer appId);

	BusinessProduct saveBusinessProductDetails(BusinessProduct product);

	CompanyDetails saveCompanyDetails(CompanyDetails companyDetails);

	CompanyDetails getCompanyDetails(Integer appId);

	CompanyAddress saveCompanyAddress(CompanyAddress address);

	CompanyAddress getCompanyAddress(Integer appId);

	Overview getOverviewDetails(Integer appId);

	BusinessProduct getProductDetails(Integer appId);


	List<PersonDetails> readJson(MultipartFile file) throws StreamReadException, DatabindException, IOException;

	List<PersonDetails> getPersonDetails(Integer appId);

	List<PersonDetails> savePersonDataList(List<PersonDetails> persons, Integer appId);

	List<SalesReport> readExcel(MultipartFile file) throws IOException;

	List<SalesReport> getSalesReport(Integer appid);

	List<SalesReport> saveSalesReport(Integer appId, List<SalesReport> salesReport);

}
