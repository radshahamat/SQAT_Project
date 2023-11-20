import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import java.time.Instant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Testing my Vehicle Renting Management  System with Selenium
        // 15 Modules

        WebDriver driver = new ChromeDriver();

        // 1. Test Admin Login Module
        //Get the Url
        String baseUrl = "http://localhost/VRMS-WT-Project-main/final-term/view/login.php";
        // Login
        driver.get(baseUrl);
        driver.findElement(By.name("luserid")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.name("submit")).click();
        // Close the browser
        driver.quit();



        // 2. Search passengers by Admin
        //Get the Url
        String baseUrl = "http://localhost/VRMS-WT-Project-main/final-term/view/login.php";
        // Login
        driver.get(baseUrl);
        driver.findElement(By.name("luserid")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.name("submit")).click();
        //Click Manager Passengers button
        driver.findElement(By.id("manage_passenger")).click();
        //Search by the name of a user
        driver.findElement(By.id("search-box")).sendKeys("adnan");
        //Press the Enter Button
        driver.findElement(By.id("search-box")).sendKeys(Keys.RETURN);



        // 3. Add driver by Admin
        //Getting the URL
        String baseUrl = "http://localhost/VRMS-WT-Project-main/final-term/view/login.php";
        // Login
        driver.get(baseUrl);
        driver.findElement(By.name("luserid")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.name("submit")).click();
        //Click Manager Passengers button
        driver.findElement(By.id("manage_driver")).click();
        //Click Add Driver
        driver.findElement(By.id("add-driver")).click();
        //Fill the form
        driver.findElement(By.id("dname")).sendKeys("Salman");
        driver.findElement(By.id("demail")).sendKeys("salman@gmail.com");
        driver.findElement(By.id("dcontact")).sendKeys("01735111111");
        driver.findElement(By.id("daddress")).sendKeys("Kuratoli, Dhaka");
        driver.findElement(By.id("dlicense")).sendKeys("123");
        driver.findElement(By.id("dcommission")).sendKeys("10");
        driver.findElement(By.id("did")).sendKeys("Salman123");
        driver.findElement(By.id("submit")).click();



        // 4. Admin allocate driver for managing a trip
        //Getting the URL
        String baseUrl = "http://localhost/VRMS-WT-Project-main/final-term/view/login.php";
        // Login
        driver.get(baseUrl);
        driver.findElement(By.name("luserid")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.name("submit")).click();
        //Click Manager Passengers button
        driver.findElement(By.id("manage_trip")).click();
        WebElement rowToAllocate = driver.findElement(By.xpath("//tr[td[text()='100007']]"));
        // Click the Change button
        WebElement changeButton = rowToAllocate.findElement(By.id("change_driver"));
        changeButton.click();
        // Enter the driver ID
        WebElement driverIdInput = driver.findElement(By.id("driver-id"));
        driverIdInput.clear(); // Clear the existing value
        driverIdInput.sendKeys("mahin");
        // Click the confirm button
        WebElement confirmButton = driver.findElement(By.id("submit_change_driver"));
        confirmButton.click();
        // Handle the alert
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Message: " + alertText);
        alert.accept();
        // Verify the alert message
        if (alertText.contains("Driver ID is set as mahin for trip ID 100005")) {
            System.out.println("Allocation Successful!");
        } else {
            System.err.println("Allocation Failed!");
        }



        // 5. Admin logout
        WebDriver driver = new ChromeDriver();
        //Getting the URL
        String baseUrl = "http://localhost/VRMS-WT-Project-main/final-term/view/login.php";
        // Admin Login
        driver.get(baseUrl);
        driver.findElement(By.name("luserid")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.name("submit")).click();
        //Stay logged in for 3 seconds
        //add throws InterruptedException for this timeout
        Thread.sleep(3000);
        //Admin Logout
        driver.findElement(By.id("logout")).click();



        // 6. User registration
        //Getting the Url
        driver.get("http://localhost/VRMS-WT-Project-main/final-term/view/registration.php");
        // Fill in the registration form.
        driver.findElement(By.name("name")).sendKeys("Rad Shahamat");
        driver.findElement(By.name("email")).sendKeys("radshamat@gmail.com");
        driver.findElement(By.name("contact")).sendKeys("12345678910");
        driver.findElement(By.name("adress")).sendKeys("Dhaka");
        driver.findElement(By.name("userid")).sendKeys("akash123");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("cpassword")).sendKeys("12345678");
        // Submit the registration form.
        driver.findElement(By.name("submit")).click();



        // 7. User login
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/VRMS-WT-Project-main/final-term/view/login.php");
        driver.findElement(By.name("luserid")).sendKeys("rad");
        driver.findElement(By.name("password")).sendKeys("rad12345");
        driver.findElement(By.name("submit")).click();



        //8. User trip booking
        // Login
        driver.get("http://localhost/VRMS-WT-Project-main/final-term/view/login.php");
        driver.findElement(By.name("luserid")).sendKeys("rad");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("submit")).click();
        // Booking
        driver.findElement(By.name("tripid")).click();
        // Use JavaScript to set the date
        WebElement tripDateField = driver.findElement(By.name("trip_date"));
        String script = "arguments[0].setAttribute('value', '2024-01-15')";
        ((JavascriptExecutor) driver).executeScript(script, tripDateField);
        // Click the "Book" button to book the car
        driver.findElement(By.name("submit")).click();
        // Handle the JavaScript alert
        Alert alert = driver.switchTo().alert();
        alert.accept(); // Click "OK" on the alert
        // Wait for redirection to trip_history.php (adjust wait conditions as needed)
        // In this example, we wait for a partial URL match
        String tripHistoryURL = "http://localhost/VRMS-WT-Project-main/final-term/view/trip_history.php";
        driver.get(tripHistoryURL);
        // Close the browser
        driver.quit();



        // 9. User check his/her trip history
        String baseUrl = "http://localhost/VRMS-WT-Project-main/final-term/view/login.php";
        // Login
        driver.get(baseUrl);
        driver.findElement(By.name("luserid")).sendKeys("rad");
        driver.findElement(By.name("password")).sendKeys("rad12345");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("trip-history")).click();
        // Close the browser
        driver.quit();



        // 10. User password change
        // Define the project URL and user credentials
        //Getting the url
        String baseUrl = "http://localhost/VRMS-WT-Project-main/final-term/view/login.php";
        // Login
        driver.get(baseUrl);
        driver.findElement(By.name("luserid")).sendKeys("rad");
        driver.findElement(By.name("password")).sendKeys("rad12345");
        driver.findElement(By.name("submit")).click();

        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("change-pass")).click();
        driver.findElement(By.name("old_password")).sendKeys("rad12345");
        driver.findElement(By.name("new_password")).sendKeys("12345678");
        driver.findElement(By.name("new_cpassword")).sendKeys("12345678");
        // Click the submit button
        driver.findElement(By.name("submit")).click();
        // Close the browser
        driver.quit();



        // 11. User can view the About Us page
        String baseUrl = "http://localhost/VRMS-WT-Project-main/final-term/view/login.php";
        // Login
        driver.get(baseUrl);
        driver.findElement(By.name("luserid")).sendKeys("rad");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.id("about")).click();
        // Close the browser
        //driver.quit();



        // 12. User can view Contact Us page
        String baseUrl = "http://localhost/VRMS-WT-Project-main/final-term/view/login.php";
        // Login
        driver.get(baseUrl);
        driver.findElement(By.name("luserid")).sendKeys("rad");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.id("contact")).click();
        // Close the browser
        driver.quit();



        // 13. User can view Database Design page
        String baseUrl = "http://localhost/VRMS-WT-Project-main/final-term/view/login.php";
        // Login
        driver.get(baseUrl);
        driver.findElement(By.name("luserid")).sendKeys("rad");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.id("db_design")).click();
        // Close the browser
        driver.quit();



        // 14. User can view General Information page
        String baseUrl = "http://localhost/VRMS-WT-Project-main/final-term/view/login.php";
        // Login
        driver.get(baseUrl);
        driver.findElement(By.name("luserid")).sendKeys("rad");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.id("general_information")).click();
        // Close the browser
        //driver.quit();



        // 15. User can logout
        // Login
        driver.get("http://localhost/VRMS-WT-Project-main/final-term/view/login.php");
        driver.findElement(By.name("luserid")).sendKeys("rad");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("submit")).click();
        //Logout
        Thread.sleep(3000);
        driver.findElement(By.id("logout")).click();



    }
}
