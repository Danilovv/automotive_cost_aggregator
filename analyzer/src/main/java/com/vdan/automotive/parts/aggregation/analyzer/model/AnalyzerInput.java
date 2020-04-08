package com.vdan.automotive.parts.aggregation.analyzer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public class AnalyzerInput implements Serializable {
    private final String key;
}
