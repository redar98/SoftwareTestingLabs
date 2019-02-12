For this laboratory work I had to create a test and see if the login was successfull. To do this I open a login page, insert required data and click on submit button.
If it redirects us to home page then the login succeeded. Else it will stay on the same login page!

```java
public static void main(String[] args){
    // Set webdriver location for chrome browser
    System.setProperty("webdriver.chrome.driver", "C:\\Maven\\chromedriver.exe");
    // Initialize webdriver
    WebDriver driver = new ChromeDriver();
    // Navigate to a page
    driver.get("http://127.0.0.1:8000/login/");

    // Check whether page title is "Twooter"
    System.out.println(driver.getTitle().equals("Twooter")? "+ Test Passed! (Title)": "- Test Failed! (Title)");

    try {
        // Insert "victo" in username field
        driver.findElement(By.id("id_username")).sendKeys("victo");
        // Insert "password" in password field
        driver.findElement(By.id("id_password")).sendKeys("password");
        // Click on login button
        driver.findElement(By.cssSelector("#account_bg>form>div>button")).click();
        // Check if login succeeded
        System.out.println(driver.getCurrentUrl().equals("http://127.0.0.1:8000/")? "+ Test Passed! (Login)":
                "- Test Failed! (Login)");
    } catch (Exception e) {
        System.out.println("- Test Failed. (Login)");
    }
    // Close the driver
    driver.close();
}
```