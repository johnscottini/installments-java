package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.PaymentService;
import model.services.PaypalTaxService;

import model.services.TaxService;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		final DateTimeFormatter for1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Enter contract data");
		System.out.println("Contract number: ");
		int contractNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.nextLine(), for1);
		System.out.println("Contract value: ");
		double value = sc.nextDouble();
		
		Contract c = new Contract(contractNumber, date, value);

		PaymentService ps = new PaymentService(new PaypalTaxService());
		System.out.println("In how many installments do you want to split the contract?");
		int installmentsNumber = sc.nextInt();
		ps.processContract(c, installmentsNumber);
		System.out.println("Installments:");
		for (Installment s : c.getInstallment())
		{
			System.out.println(s.toString());
		}

		sc.close();
	}

}
