package com.tejait.batch16.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tejait.batch16.exceptions.DetailsAlreadyExists;
import com.tejait.batch16.exceptions.IdNotFoundException;
import com.tejait.batch16.model.BusinessProduct;
import com.tejait.batch16.model.CompanyAddress;
import com.tejait.batch16.model.CompanyDetails;
import com.tejait.batch16.model.LoanApplication;
import com.tejait.batch16.repository.BusinessProductRepository;
import com.tejait.batch16.repository.CompanyAddressRepository;
import com.tejait.batch16.repository.CompanyDetailsRepository;
import com.tejait.batch16.repository.LoanRepository;
import com.tejait.batch16.service.LoanService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService{

	LoanRepository repository;
	
	BusinessProductRepository productRepository;
	CompanyDetailsRepository detailsRepository;
	CompanyAddressRepository addressRepository;

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
		return addressRepository.save(gotAddress);
	}

	@Override
	public CompanyAddress getCompanyAddress(Integer appId) {
		
		return addressRepository.findByAppId(appId);
	}
	
	

	
	
	
}
