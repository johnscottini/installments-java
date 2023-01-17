package model.services;

public class PaypalTaxService implements TaxService{
	
	@Override
	public double interest(Double amount, int months) {		
		return amount + (amount*0.01*months);
	}
	
	public double paymentFee(Double amount) {
		return amount + (amount*0.02);
	}	

}
