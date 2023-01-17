package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	public Installment(LocalDate installmentDate, double installmentValue) {

		this.installmentDate = installmentDate;
		this.installmentValue = installmentValue;
	}

	public Installment() {

	}

	DateTimeFormatter for1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate installmentDate;
	private double installmentValue;

	public LocalDate getInstallmentDate() {
		return installmentDate;
	}

	public void setInstallmentDate(LocalDate installmentDate) {
		this.installmentDate = installmentDate;
	}

	public double getInstallmentValue() {
		return installmentValue;
	}

	public void setInstallmentValue(double installmentValue) {
		this.installmentValue = installmentValue;
	}

	@Override
	public String toString() {
		return for1.format(installmentDate) + " - "+ String.format("%.2f", installmentValue);
		}

}
