package testpractice3;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class saucedemo3 {

	   public static void main(String[] args) {
	        // Set the path to your ChromeDriver 
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\eclipse-workspace\\testpractice2\\Drivers\\chromedriver.exe");

	        // Initialize the WebDriver 
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	  
	        //Step 1: Visit www.saucedemo.com
	         driver.get("https://www.saucedemo.com");
	   

	       // Step 2: Login with locked_out_user and secret_sauce
	        login(driver, "locked_out_user", "secret_sauce");

	        // Step 3: Verify the error message
	        String errorMessage = "Epic sadface: Sorry, this user has been locked out.";
	        verifyErrorMessage(driver, errorMessage);

	        // Step 4: Clear the entered details
	         clearLoginDetails(driver);

	        // Step 5: Log in again with standard_user (without re-entering the password)
	       login(driver, "standard_user", "");

	        // Step 7: Verify the text "two-needle hemmed sleeved" in the product description
	        verifyProductDescription(driver, "Sauce Labs Onesie", "two-needle hemmed sleeved");

	        // Step 8: Click back to product
	        WebElement clickback = driver.findElement(By.id("back-to-products"));
	        clickback.click();


	        // Step 9: Access the menu on the left of the page
	        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
	        menuButton.click();

	        // Step 10: Click logout
	        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
	        logoutLink.click();

	        // Close the WebDriver
	        driver.quit();
	   }
	    


		public static void login(WebDriver driver, String username, String password) {
	        WebElement usernameField = driver.findElement(By.id("user-name"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.id("login-button"));

	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        loginButton.click();
	    }

	    public static void verifyErrorMessage(WebDriver driver, String expectedErrorMessage) {
	        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
	        String actualErrorMessage = errorElement.getText();
	        if (actualErrorMessage.equals(expectedErrorMessage)) {
	            System.out.println("Error message verification successful.");
	        } else {
	            System.out.println("Error message verification failed.");
	        }
	    }

	          public static void clearLoginDetails(WebDriver driver) {
	           WebElement usernameField = driver.findElement(By.id("user-name"));
	          WebElement passwordField = driver.findElement(By.id("password"));

	         usernameField.clear();
	         passwordField.clear();
	      }

	          public static void verifyProductDescription(WebDriver driver, String productName, String expectedDescription) {
	          WebElement productElement = driver.findElement(By.xpath("//div[text()='" + productName + "']"));
	          productElement.click();

	        WebElement descriptionElement = driver.findElement(By.cssSelector(".inventory_details_desc "));
	        String actualDescription = descriptionElement.getText();
	        if (actualDescription.contains(expectedDescription)) {
	            System.out.println("Product description verification successful.");
	        } else {
	            System.out.println("Product description verification failed.");
	        }
	    }
	}


