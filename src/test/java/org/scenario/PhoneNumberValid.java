package org.scenario;

import org.baseclass.ReadData;
import org.baseclass.Slf4j;

import org.slf4j.Logger;
import org.swiggy.withpagefactory.SwiggyPageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;




public class PhoneNumberValid extends SwiggyPageFactory {
	
	//static Logger log = Slf4j.loadlogger(PhoneNumberValid.class);
	
	
	
	@Test(priority = -10)
    public  void phoneNumberValid() throws Exception {
		
		
	ExtentTest logger = extent.createTest("phoneNumberValid");	
	PhoneNumberValid ex = new PhoneNumberValid();
		ex.signupClick();
		logger.log(Status.INFO, "Clicking on sign up button");
		ex.phonenumberCheck(ReadData.getdatafromexcel("Data", 1, 1));
		ex.continueClick();
		logger.log(Status.INFO, "Clicking on continue button");
		String phonenumberlabelReads = ex.phonenumberlabelRead();
		Assert.assertTrue(phonenumberlabelReads.equalsIgnoreCase("Phone number"));
		
		try {
		Log.info("The values are  matching");
		logger.log(Status.PASS, "The given number is in 10 digits");
		}
		
		catch (Exception e) {
			// TODO: handle exception
			Log.info("The values are not matching");
			logger.log(Status.FAIL, "The given number is not in 10 digits");
			
		}
		
		
		
//		if(phonenumberlabelReads.equalsIgnoreCase("Phone number")) {
//			
//			System.out.println("The given number is in 10 digits");
//		}
//		
//		else {
//			
//			System.out.println("The given number is not in 10 digits");
//			
//		}
		
	}
	
	
	
	@Test(priority = 10)
	public  void phoneNumberNotValid() throws Exception{
		
		ExtentTest logger = extent.createTest("phoneNumberNotInvalid");	
		PhoneNumberValid ex = new PhoneNumberValid();
		ex.signupClick();
		logger.log(Status.INFO, "Clicking on sign up button");
		ex.phonenumberCheck(ReadData.getdatafromexcel("Data", 3, 1));
		ex.continueClick();
		logger.log(Status.INFO, "Clicking on continue button");
		String phonenumberlabelReads1 = ex.phonenumberlabelRead();
		Assert.assertEquals(phonenumberlabelReads1,"Phone number", "The phonenumber label is different");
		try {
			Log.info("The values are  matching");
			logger.log(Status.FAIL, "The given number is in 10 digits");
		}
		catch (Exception e) {
			// TODO: handle exception
			Log.info("The values are not matching");
			logger.log(Status.PASS, "The given number is in 10 digits");
		}
		
		
		
		
		
//		if(phonenumberlabelReads1.equalsIgnoreCase("Phone number")) {
//			
//			System.out.println("The given number is in 10 digits");
//		}
//		
//		else {
//			
//			System.out.println("The given number is not in 10 digits");
//			
//		}
		
	
	}	
	
	

	
	


}
