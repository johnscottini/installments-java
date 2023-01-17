package model.services;

import java.time.LocalDate;
import java.util.ArrayList;

import model.entities.Contract;
import model.entities.Installment;

public class PaymentService {

	public PaymentService(TaxService taxService) {
		super();
		this.taxService = taxService;
	}

	private TaxService taxService;
	
	public TaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}

	public void processContract(Contract contract, int months)
	{
		double initialAmount = contract.getContractValue() / months;
		
		for(int i=1; i<=months; i++)
		{
			LocalDate installmentDate= contract.getContractDate().plusMonths(i);
			double firstAmount = taxService.interest(initialAmount, i);
			double finalAmount = taxService.paymentFee(firstAmount);
			contract.getInstallment().add(new Installment(installmentDate, finalAmount));
			
		}
	}
}
