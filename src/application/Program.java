package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();

		System.out.print("Enter a file path: ");
		String strPath = sc.nextLine();
		File path = new File(strPath);
		String strPath2 = path.getParent() + "\\";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();

			while (line != null) {
				String[] parts = line.split(",");
				String productName = parts[0];
				Double productPrice = Double.parseDouble(parts[1]);
				Integer productQuantity = Integer.parseInt(parts[2]);

				list.add(new Product(productName, productPrice, productQuantity));

				line = br.readLine();
			}
		}

		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.print("Enter the new folder: ");
		String newFolder = sc.nextLine();

		boolean success = new File(strPath2 + newFolder).mkdir();

		System.out.print("Enter the new File: ");
		String strPath3 = strPath2 + newFolder + "\\" + sc.nextLine();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(strPath3))) {

			for (Product lines : list) {
				bw.write(lines.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		sc.close();
	}
}