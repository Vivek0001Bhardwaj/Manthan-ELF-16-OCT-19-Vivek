package com.manthan.hotelbillingapplication.util;

import com.manthan.hotelbillingapplication.dao.HotelBillingAppDao;
import com.manthan.hotelbillingapplication.dao.HotelBillingAppDaoImpl;

public class HotelBillingAppDaoImplManager {

	private HotelBillingAppDaoImplManager() {}
	public static HotelBillingAppDao getDaoInstance()
	{
		return new HotelBillingAppDaoImpl();
	}

}//End of class

