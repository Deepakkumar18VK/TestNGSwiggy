package org.swiggy.withpagefactory;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class SwiggyPageFactory extends BaseClass {
	
	
	public SwiggyPageFactory() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy (xpath = "//a[text()='Sign up']")
	public WebElement signup;
	
	@FindBy (xpath = "//a[@class= 'a-ayg']")
	public WebElement continueclick;
	
	@FindBy (id = "mobile")
	public WebElement mobilenumber;
	
	
	
	@FindBy (xpath = "//label[@for= 'mobile']")
	public WebElement phonenumberlabel;
	
	

	
	
 //Registraion Scenario
	
	
	  public  void signupClick() {
			
			
			elementClick(signup);
			
			
		}
	
	
	  
    public void continueClick() {
		
		
		elementClick(continueclick);
	}
	
	

  
  public void validPhonenumber() {
		
		
		type(mobilenumber, "6380136431");
	
		
	}
  
  
  
     
     public void phonenumberCheck(String phone) {
 		
 		
 		type(mobilenumber, phone);
 	
 	}
     
     
  
	
	
	

	public  String phonenumberlabelRead() {
		
	
		WebElement elementFinder = phonenumberlabel;
		String txt = elementFinder.getText();
		
		
		return txt;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
