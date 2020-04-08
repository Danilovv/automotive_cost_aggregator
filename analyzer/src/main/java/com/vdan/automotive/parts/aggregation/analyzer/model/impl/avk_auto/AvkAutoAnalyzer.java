package com.vdan.automotive.parts.aggregation.analyzer.model.impl.avk_auto;

import com.google.common.collect.Lists;
import com.vdan.automotive.parts.aggregation.analyzer.AnalyzerKey;
import com.vdan.automotive.parts.aggregation.analyzer.model.Analyzer;
import com.vdan.automotive.parts.aggregation.analyzer.model.AnalyzerInput;
import com.vdan.automotive.parts.aggregation.analyzer.model.AnalyzerResult;
import com.vdan.automotive.parts.aggregation.core.parts.AutomotivePartData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvkAutoAnalyzer implements Analyzer<AnalyzerInput> {
    @Override
    public AnalyzerResult collect(final WebDriver webDriver, final AnalyzerInput analyzerInput) {
        // L3K913250A
        final String url = String.format("https://avk-auto.com/search/?pcode=%s", analyzerInput.getKey());
        webDriver.get(url);

        final List<AutomotivePartData> data = Lists.newLinkedList();

        webDriver
//                .findElement(By.className("globalResult "))
                .findElement(By.id("searchResultsTable"))
                .findElements(By.className("resultTr2Route"))
                .forEach(webElement -> {
                    final String rawPrice = webElement
                            .findElement(By.className("resultPrice"))
                            .getText().trim();

                    final int indexOfCurrency = rawPrice.indexOf("руб.");

                    if (indexOfCurrency == -1)
                        return;

                    final String price = rawPrice.substring(0, indexOfCurrency).trim().replaceAll(" ", "");
                    final String currency = rawPrice.substring(indexOfCurrency);

                    try {
                        data.add(new AutomotivePartData(analyzerInput.getKey(), Double.valueOf(price), currency));
                    } catch (final Exception e) {
                        return;
                    }
                });

        return new AnalyzerResult(data);
    }

    @Override
    public AnalyzerKey key() {
        return AnalyzerKey.AVK_AUTO;
    }
}
