import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IMDbTestCases {

    // Method to play the trailer of a specific movie
    public static void playTrailer() {
        ChromeDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.imdb.com/");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Search for the movie
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='suggestion-search']")));
            searchBox.sendKeys("kgf 2022");
            WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role='listbox']//li[@role='option' 
            and @data-suggestion-index='0']")));    
            suggestion.click();

            // Play the trailer
            WebElement trailer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//video[@tabindex='-1']")));
            trailer.click();

            System.out.println("Trailer played successfully.");
        } catch (Exception e) {
            System.err.println("Error playing trailer: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    // Method to capture and display the movie rating
    public static void captureRating() {
        ChromeDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.imdb.com/");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Search for the movie
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='suggestion-search']")));
            searchBox.sendKeys("kgf 2022");
            WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role='listbox']//li[@role='option' 
            and @data-suggestion-index='0']")));
            suggestion.click();

            // Get the rating
            WebElement ratingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-3a4309f8-0 jJkxPn 
            sc-70a366cc-1kUfGfN']//div[@class='sc-d541859f-2 kxphVf']")));
            String rating = ratingElement.getText();
            System.out.println("Rating is: " + rating);
        } catch (Exception e) {
            System.err.println("Error capturing rating: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    // Method to retrieve and display recently visited movie titles
    public static void recentlyVisited() {
        ChromeDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.imdb.com/");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Search for multiple movies
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='suggestion-search']")));
            searchBox.sendKeys("kgf 2022");
            WebElement suggestion1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role='listbox']//li[@role='option' and 
            @data-suggestion-index='0']")));
            suggestion1.click();

            searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='suggestion-search']")));
            searchBox.sendKeys("salar ghajar");
            WebElement suggestion2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role='listbox']//li[@role='option' and 
            @data-suggestion-index='0']")));
            suggestion2.click();

            searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='suggestion-search']")));
            searchBox.sendKeys("No where");
            WebElement suggestion3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role='listbox']//li[@role='option' and 
            @data-suggestion-index='0']")));
            suggestion3.click();

            driver.findElement(By.xpath("//a[@id='home_img_holder']")).click();

            // Retrieve recently visited movie titles
            List<WebElement> recentMovies = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='sc-2877e49d-0 
            ehOXGg recently-viewed celwidget']//a[@class='ipc-poster-card__title ipc-poster-card__title--clamp-1 ipc-poster-card__title--clickable']")));

            System.out.println("Recently visited movies:");
            for (WebElement movie : recentMovies) {
                System.out.println(movie.getText());
            }
        } catch (Exception e) {
            System.err.println("Error retrieving recently visited movies: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        try {
            playTrailer();
            //captureRating();
            //recentlyVisited();
        } catch (Exception e) {
            System.err.println("Error in main execution: " + e.getMessage());
        }
    }
}
