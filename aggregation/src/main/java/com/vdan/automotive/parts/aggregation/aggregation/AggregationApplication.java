package com.vdan.automotive.parts.aggregation.aggregation;

import com.vdan.automotive.parts.aggregation.aggregation.common.AnalyzerFactory;
import lombok.RequiredArgsConstructor;
import org.apache.spark.api.java.JavaSparkContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication(scanBasePackages = {
        "com.vdan.automotive.parts.aggregation.aggregation",
        "com.vdan.automotive.parts.aggregation.analyzer.model.impl"
})
public class AggregationApplication implements CommandLineRunner {

    private final JavaSparkContext javaSparkContext;
    private final AnalyzerFactory analyzerFactory;

    public static void main(String[] args) {
        SpringApplication.run(AggregationApplication.class, args);
    }

    /*
        Args:
        0: Selenium chrome driver executable path
     */
    @Override
    public void run(final String... args) throws Exception {
        System.setProperty("webdriver.chrome.driver", args[0]);

        final ChromeDriverService chromeDriverService = ChromeDriverService.createDefaultService();

        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("window-size=1920x1080");
        chromeOptions.addArguments("--no-sandbox");

        final WebDriver webDriver = new ChromeDriver(chromeDriverService, chromeOptions);

        webDriver.get("https://yandex.ru/");

        final Actions actions = new Actions(webDriver);
//        actions
        actions.build(); // TODO investigate

        final String title = webDriver.getTitle();
        final String weatherTemp = webDriver.findElement(By.className("weather__temp")).getText();

        System.out.println(String.format("Title: %s", title));
        System.out.println(String.format("Temperature: %s", weatherTemp));

        webDriver.close();

//        Spark test OK
//        try(final JavaSparkContext ctx = javaSparkContext) {
//            final JavaDoubleRDD rdd = ctx.parallelizeDoubles(Lists.newArrayList(1.0d, 2.0d, 3.0d));
//            final Double sum = rdd.sum();
//
//            System.out.println(String.format("Result = %s", sum));
//        }
    }
}
