package com.manthan.hotelbillingapplication.dao;

import com.manthan.hotelbillingapplication.bean.HotelBillingAppBean;

public interface HotelBillingAppDao {

	public void showAllFoodItems();
	public void getTotalBillOfTheDay();
	public void setTotalPriceToCustomerBill(double totalPrice);
	public void setTotalPriceToCustomerBillToZero(double totalPrice);
	public void setTotalPriceToHotelBill(double totalPrice);
	public void getTotalBillOfTheCustomer();
	public String addFoodItem(HotelBillingAppBean hbaBean);
	public String removeFoodItem(int itemCode);
	public String modifyFoodItem(HotelBillingAppBean hbaBean);
}
