package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;

import model.services.PaymentService;
import model.services.TaxService;

public class Contract {
	ArrayList<Installment> installment = new ArrayList<Installment>();
	public Contract( int contractNumber, LocalDate contractDate,
			double contractValue, TaxService taxService) {

		this.contractNumber = contractNumber;
		this.contractDate = contractDate;
		this.contractValue = contractValue;
		
		this.taxService = taxService;
	}

	public Contract(int contractNumber, LocalDate contractDate, double contractValue) {

		this.contractNumber = contractNumber;
		this.contractDate = contractDate;
		this.contractValue = contractValue;
		
	}

	public Contract() {

	}

	public ArrayList<Installment> getInstallment() {
		return installment;
	}

	
	private int contractNumber;
	private LocalDate contractDate;
	private double contractValue;
	TaxService taxService;
	public int getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(int contractNumber) {
		this.contractNumber = contractNumber;
	}

	public LocalDate getContractDate() {
		return contractDate;
	}

	public void setContractDate(LocalDate contractDate) {
		this.contractDate = contractDate;
	}

	public double getContractValue() {
		return contractValue;
	}

	public void setContractValue(double contractValue) {
		this.contractValue = contractValue;
	}


}
