package AutomationChallenge;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.Session;

import java.util.Properties;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author lilian
 */
public class LaunchBrowserTest {
	static WebDriver webDriver;
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(final String[] args) throws InterruptedException {
        // Telling the system where to find the chrome driver
        System.setProperty(
                "webdriver.firefox.driver",
                "C:\\selenium files\\geckodriver.exe");

        // Open the Chrome browser
        webDriver = new FirefoxDriver();

        // Maximize the browser window
        webDriver.manage().window().maximize();

        if (testMasokologin()) {
            System.out.println("Test Masoko Login: Passed");
        } else {
            System.out.println("Test Masoko Login: Failed");

        }

        // Close the browser and WebDriver
        //webDriver.close();
        //webDriver.quit();
    }

    private static boolean testMasokologin() {
        try {
            // Open google.com
            webDriver.navigate().to("https://www.masoko.com/customer/account/login/referer/aHR0cHM6Ly93d3cubWFzb2tvLmNvbS8%2C/");

            // Type in the username
            webDriver.findElement(By.id("email")).sendKeys("liliankirito@gmail.com");

            // Type in the password
            webDriver.findElement(By.id("pass")).sendKeys("Royal@ke2019");

            // Click the Submit button
            webDriver.findElement(By.id("send2")).click();

            // Wait a little bit (7000 milliseconds)
            Thread.sleep(7000);

            //check if the next page title is Shop Online in Kenya - Pay Conveniently via M-Pesa | Masoko
            
            String actualTitle="";
    		String expectedTitle="Shop Online in Kenya - Pay Conveniently via M-Pesa | Masoko";
    		
    		 if (actualTitle.contentEquals(expectedTitle)){
    			 System.out.println("Test Passed!");
    			  return true;
    	            
    	            } else {
    	            	System.out.println("Test Failed");
    	            	return false;
    	         }
    	      // logger.info(actualTitle);
    			
         

        // If anything goes wrong, return false.
        } catch (final Exception e) {
            System.out.println(e.getClass().toString());
            return false;
        }
    }
    private static boolean testMasokoRegistration() {
    	try {
            // Open google.com
            webDriver.navigate().to("https://www.masoko.com/customer/account/login/referer/aHR0cHM6Ly93d3cubWFzb2tvLmNvbS8%2C/");
            
            //type in firstname
            webDriver.findElement(By.id("firstname")).sendKeys("mary");
           
            //type lastname
            webDriver.findElement(By.id("lastname")).sendKeys("lily");
           
            //type mobile number
            webDriver.findElement(By.id("mobile")).sendKeys("705895190");
			//driver.findElement(By.id("store_code_indentifier_customer")).sendKeys("12345");
            
            //type email address
            webDriver.findElement(By.id("email_address")).sendKeys("liliankirito94@gmail.com");
            
            //type password
            webDriver.findElement(By.id("password")).sendKeys("Royal@ke2019");
            
            //type password
            webDriver.findElement(By.id("password-confirmation")).sendKeys("Royal@ke2019");
            
            //click subscribe check box
			WebElement subscribed = webDriver.findElement(By.id("is_subscribed"));										
	            subscribed.click (); 
	        //}
	         webDriver.findElement(By.name("send2")).click();
	         
	         String actualTitle="";
	    		String expectedTitle="Shop Online in Kenya - Pay Conveniently via M-Pesa | Masoko";
	    		
	    		 if (actualTitle.contentEquals(expectedTitle)){
	    			 System.out.println("Test Passed!");
	    			  return true;
	    	          
	    	            } else {
	    	            	System.out.println("Test Failed");
	    	            	return false;
	    	            
	    	         }
	         
	         
    	} catch (final Exception e) {
            System.out.println(e.getClass().toString());
            return false;
        }
		
        }
    
    private static boolean testProductSearch() {
    	try {
            // Open google.com
            webDriver.navigate().to("https://www.masoko.com/");
            
         // type name of a product
            webDriver.findElement(By.name("q")).sendKeys("Velvex serviettes");
           
            
            WebElement search =  webDriver.findElement(By.className("action search"));										
                search.click (); 
                
                
                //////////////////
            
                String actualTitle="";
	    		String expectedTitle="Shop Online in Kenya - Pay Conveniently via M-Pesa | Masoko";
	    		
	    		 if (actualTitle.contentEquals(expectedTitle)){
	    			 System.out.println("Test Passed!");
	    			  return true;
	    	          
	    	            } else {
	    	            	System.out.println("Test Failed");
	    	            	return false;
	    	            
	    	         }
	    		 ////////
	          
	    		 
	         
    	} catch (final Exception e) {
            System.out.println(e.getClass().toString());
            return false;
        }
    	
    }
    
    private static boolean testProductAddToCart() {
    	try {
    		 // Open google.com
            webDriver.navigate().to("https://www.masoko.com/");
            
            //select search by category
            webDriver.findElement(By.linkText("https://www.masoko.com/all-categories")).click();
            
            //select the categogy need
            webDriver.findElement(By.linkText("https://www.masoko.com/all-categories/alcoholic-beverages")).click();
            
          //select the categogy need
            webDriver.findElement(By.linkText("https://www.masoko.com/all-categories/alcoholic-beverages/spirits/brandy")).click();
           
            //////////////
            String actualTitle="";
    		String expectedTitle="Shop Online in Kenya - Pay Conveniently via M-Pesa | Masoko";
    		
    		 if (actualTitle.contentEquals(expectedTitle)){
    			 System.out.println("Test Passed!");
    			  return true;
    	          
    	            } else {
    	            	System.out.println("Test Failed");
    	            	return false;
    	            
    	         }
         ////////////////////
         
	} catch (final Exception e) {
        System.out.println(e.getClass().toString());
        return false;
    }
            
       
    	}
    @After
    private static boolean testSendEmail() {
    	
    	final String username = "liliankirito@gmail.com";
        final String password = "0792074625";

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        javax.mail.Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from.mail.liliankirito@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("to.mail.lilianthiauru@gmail.com"));
            message.setSubject("Masoko Automation Report");
            message.setText("PFA");

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();

            messageBodyPart = new MimeBodyPart();
            
            ///////////
            String file = "path of file to be attached";
            
            String fileName = "attachment name";
            
            //////////////
            
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            System.out.println("Sending");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
      }
    }
    
}