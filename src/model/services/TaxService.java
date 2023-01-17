package model.services;

public interface TaxService {
	double interest (Double interest, int months);
	double paymentFee(Double interest);
}
