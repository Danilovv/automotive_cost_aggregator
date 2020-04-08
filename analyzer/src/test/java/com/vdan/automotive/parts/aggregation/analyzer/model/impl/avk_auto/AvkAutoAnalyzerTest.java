package com.vdan.automotive.parts.aggregation.analyzer.model.impl.avk_auto;


import com.vdan.automotive.parts.aggregation.analyzer.model.AnalyzerInput;
import com.vdan.automotive.parts.aggregation.analyzer.model.AnalyzerResult;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class AvkAutoAnalyzerTest {

    @Test
    public void collect() {


        final ChromeDriverService chromeDriverService = ChromeDriverService.createDefaultService();

        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("window-size=1920x1080");
        chromeOptions.addArguments("--no-sandbox");

        final WebDriver webDriver = new ChromeDriver(chromeDriverService, chromeOptions);

        AvkAutoAnalyzer avkAutoAnalyzer = new AvkAutoAnalyzer();
        final AnalyzerResult result = avkAutoAnalyzer.collect(webDriver, new AnalyzerInput("L3K913250A"));

        System.out.println();
    }
}