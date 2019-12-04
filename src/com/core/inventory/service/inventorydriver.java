package com.core.inventory.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class InventoryDriver {
	// Define Command Variables
	private static final String createCmd = "CREATE";
	private static final String deleteCmd = "DELETE";
	private static final String updateBuyCmd = "UPDATEBUY";
	private static final String updateSellCmd = "UPDATESELL";
	private static final String reportCmd = "REPORT";
	private static final String updateSellPriceCmd = "UPDATESELLPRICE";
	static {
		System.gc();
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {
			Scanner scanner = new Scanner(System.in);
			String lineText = null;
			while (true) {
				System.out.print("Enter command,'q' to quit :");
				// Read User input value
				lineText = scanner.nextLine();
				if ("q".equalsIgnoreCase(lineText)) {
					System.out.println("Exit!");
					break;
				}
				String[] commands = lineText.split(" ");
				String command = commands[0];
				if (createCmd.equalsIgnoreCase(command)) {
					Inventory.create(commands[1], Double.valueOf(commands[2]), Double.valueOf(commands[3]));
				} else if (deleteCmd.equalsIgnoreCase(command)) {
					Inventory.delete(commands[1]);
				} else if (updateBuyCmd.equalsIgnoreCase(command)) {
					Inventory.updateBuy(commands[1], Integer.valueOf(commands[2]));
				} else if (updateSellCmd.equalsIgnoreCase(command)) {
					Inventory.updateSell(commands[1], Integer.valueOf(commands[2]));
				} else if (updateSellPriceCmd.equalsIgnoreCase(command)) {
					Inventory.updateSellprice(commands[1], Double.valueOf(commands[2]));
				} else if (reportCmd.equalsIgnoreCase(command)) {
					Inventory.report();
				} else {
					System.out.println("Invalid Command ");
				}
			}
			scanner.close();

		} catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		} catch (ArrayIndexOutOfBoundsException ex1) {
			System.out.println("Invalid Arguments Passed, Truncating the Process");
		} catch (Exception e) {

			System.out.println(e.getMessage() + ", Truncating the Process");
		}

	}

}
