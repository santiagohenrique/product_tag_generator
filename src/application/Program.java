package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int numberOfProducts = sc.nextInt();
		
		for(int i = 0; i < numberOfProducts; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char productType = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String productName = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if(productType == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				Product product = new ImportedProduct(productName, price, customsFee);
				products.add(product);
			}else if(productType == 'u') {
				System.out.print("Manufacture date: (DD/MM/YYYY): ");
				String date = sc.next();
				LocalDate productDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				Product product = new UsedProduct(productName, price, productDate);
				products.add(product);
			}else {
				Product product = new Product(productName, price);
				products.add(product);
			}
		}
		
		System.out.println("PRICE TAGS:");
		for(Product product : products) {
			System.out.println(product.priceTag()); 
		}
		
		
	}
	
	
}
