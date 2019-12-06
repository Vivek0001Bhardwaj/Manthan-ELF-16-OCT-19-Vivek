package com.manthan.hotelbillingapplication.main;

import java.util.Scanner;

import com.manthan.hotelbillingapplication.bean.HotelBillingAppBean;
import com.manthan.hotelbillingapplication.dao.HotelBillingAppDao;
import com.manthan.hotelbillingapplication.util.HotelBillingAppDaoImplManager;

public class HotelBillingApp {

	static int firstTake=0;
	
	public static void main(String[] args) {		

		HotelBillingAppDao hbadao = HotelBillingAppDaoImplManager.getDaoInstance(); //getting dao class object by a dao manager class
		
		HotelBillingAppBean hbaBean = new HotelBillingAppBean();

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Hotel Taj\n");

		int enter=1;
		
		while(enter==1)
		{
			System.out.println("\nPress 1 to show all food items");
			System.out.println("Press 2 to take order from customers");
			System.out.println("Press 3 to operate on food items");
			System.out.println("Press 4 to total bill of the day");
			System.out.println("Press 5 to Exit from ordering for the day\n");

			int input = sc.nextInt();

			switch(input)
			{

			case 1:
				hbadao.showAllFoodItems();
				break;

			case 2:
				firstTake=1;
				int complete=1;
				double totalPrice=0;
				while(complete==1)
				{
					System.out.println("Enter the Item Code");
					int itemCode = sc.nextInt();

					sc.nextLine();
					System.out.println("Enter the Food Name");
					String foodName = sc.nextLine();

					System.out.println("Enter the Price");
					double price = sc.nextDouble();

					System.out.println("To continue order press 1 or if order is complete press 0");
					complete = sc.nextInt();

					totalPrice = totalPrice + price;
				}
				
				hbadao.setTotalPriceToHotelBill(totalPrice);
				hbadao.setTotalPriceToCustomerBill(totalPrice);
				System.out.println("Order Completed and Bill Generated for this Customer");

				break;

			case 3:
				System.out.println("Press A to add food item");
				System.out.println("Press B to remove food item");
				System.out.println("Press C to modify food item\n");

				char option = sc.next().charAt(0);

				switch(option)
				{

				case 'A':
					sc.nextLine();
					System.out.println("Enter the Item Code");
					int itemCode = sc.nextInt();

					sc.nextLine();
					System.out.println("Enter the Food Name");
					String foodName = sc.nextLine();

					System.out.println("Enter the Price");
					double price = sc.nextDouble();

					hbaBean.setItemCode(itemCode);
					hbaBean.setFoodName(foodName);
					hbaBean.setPrice(price);

					System.out.println(hbadao.addFoodItem(hbaBean));

					break;

				case 'B':
					sc.nextLine();
					System.out.println("Enter the Item Code");
					itemCode = sc.nextInt();

					System.out.println(hbadao.removeFoodItem(itemCode));

					break;

				case 'C':
					sc.nextLine();
					System.out.println("Enter the Item Code");
					itemCode = sc.nextInt();

					sc.nextLine();
					System.out.println("Enter the Food Name");
					foodName = sc.nextLine();

					System.out.println("Enter the Price");
					price = sc.nextDouble();

					hbaBean.setItemCode(itemCode);
					hbaBean.setFoodName(foodName);
					hbaBean.setPrice(price);

					System.out.println(hbadao.modifyFoodItem(hbaBean));

					break;	
				}
				break;

			case 4:
				if(firstTake==1)
				{
					System.out.print("Bill for the day till now --> ");
					hbadao.getTotalBillOfTheDay();
					firstTake=0;
				}
				else
				{
					System.out.println("Take the Order first, for any Customer");
				}
				break;

			case 5:
				System.out.print("Exited from ordering for the day and here is the Total Bill for the day --> ");
				hbadao.getTotalBillOfTheDay();
				System.exit(0);
			}
			if(enter==1)
			{
				if(firstTake==1)
				{
					System.out.print("\nEnter 1 for next customer order and Here is the Total Bill for this customer --> ");
					hbadao.getTotalBillOfTheCustomer();
					hbadao.setTotalPriceToCustomerBillToZero(0);
					enter = sc.nextInt();
				}
				else
				{
					System.out.print("\nEnter 1 for taking the order for Customer\n");
					enter = sc.nextInt();
				}
			}
		}
		sc.close();

	}//End of main method

}// End of class
