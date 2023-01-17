package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;
import model.services.TaxService;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		final DateTimeFormatter for1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		System.err.println("Enter rental data");
		System.out.println("Car model: ");
		String carModel = sc.nextLine();
		System.out.println("Pickup (dd/MM/yyyy hh:mm): ");
		LocalDateTime pickupDate = LocalDateTime.parse(sc.nextLine(), for1);
		System.out.println("Return (dd/MM/yyyy hh:mm): ");
		LocalDateTime returnDate = LocalDateTime.parse(sc.nextLine(), for1);
		CarRental cr = new CarRental(pickupDate, returnDate, new Vehicle(carModel));
		System.out.println("Enter price per hour: ");
		double hourValue = sc.nextDouble();
		System.out.println("Enter price per day: ");
		double dayValue = sc.nextDouble();
		RentalService rs = new RentalService(hourValue, dayValue, new BrazilTaxService());
		rs.processInvoice(cr);
		System.out.println("INVOICE:\nBasic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()) + "\nTax: "
				+ String.format("%.2f", cr.getInvoice().getTax()) + "\nTotal payment: "
				+ String.format("%.2f", cr.getInvoice().getTotalPayment() ) );
		
		sc.close();
	}

}
