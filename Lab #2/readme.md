In this laboratory work I had to get all of the products from all pages and save their information (brand, description, price) in a list to sort it later.

```java
public static void main(String[] args){
    // Initialize webdriver and load the page
    System.setProperty("webdriver.chrome.driver", "C:\\Maven\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://md.sportsdirect.com/mens/mens-hoodies?promo_name=landing-mens#dcp=1&dppp=100&OrderBy=rank&Filter=ACOL%5EGrey");

    // If there is a popup, close it!
    if (driver.findElement(By.id("advertPopup")).isDisplayed())
        driver.findElement(By.id("advertPopup")).findElement(By.className("close")).click();

    // If "nextPage" button is not found then we are on the lastPage
    boolean lastPage = false;
    // Create a list to contain all of our products
    List<Product> products = new ArrayList<Product>();
    // Iterate through each page to get elements
    while(!lastPage) {
        // Find "navlist" element to get every list item
        List<WebElement> links = driver.findElement(By.id("navlist")).findElements(By.tagName("li"));

        // Iterate through each product item
        for (int i = 0; i < links.size(); i++) {
            String brand = links.get(i).findElement(By.className("productdescriptionbrand")).getText();
            String desc = links.get(i).findElement(By.className("productdescriptionname")).getText();
            String price = links.get(i).findElement(By.className("CurrencySizeLarge")).getText();
            products.add(new Product(brand, desc, price));
            System.out.println(products.size() + ": " + brand + " " + desc + ", for " + price);
        }

        // If "nextPage" button doesn't exist then we are on the lastPage
        try {
            driver.findElement(By.className("swipeNextClick")).click();
            // Wait? c'mon
            Thread.sleep(4500);
        } catch (Exception e){
            lastPage = true;
        }
    }

    // Sort the list by product price
    Collections.sort(products);
    Product cheapest = products.get(0);
    System.out.println("Cheapest product: " + cheapest.brand + " " + cheapest.desc + ", for $" + cheapest.price);
}
```