package com.vdan.automotive.parts.aggregation.analyzer.model;

import com.vdan.automotive.parts.aggregation.analyzer.AnalyzerKey;
import org.openqa.selenium.WebDriver;

public interface Analyzer<Input extends AnalyzerInput> {
    AnalyzerResult collect(final WebDriver webDriver, Input input);
    AnalyzerKey key();
}
