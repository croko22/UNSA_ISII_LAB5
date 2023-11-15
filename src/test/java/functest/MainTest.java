package functest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest  {

    private WebDriver driver;

    @BeforeEach
    protected void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void tests(){
        String[][] testData = {
                {"15.5", "100", "15.5"},
                {"-15.5", "100", "-15.5"},
                {"0", "100", "0"},
                {"0.1", "100", "0.1"},
                {"100", "100", "100"},
        };
        for (String[] data : testData){
            String result = AppWebDriver.calculatePercentage(driver, data[0], data[1]);
            System.out.println("El " + data[0] + "% de " + data[1] + " es: " + result);
            Assertions.assertEquals(data[2], result.trim());
        }
    }

    @AfterEach
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
