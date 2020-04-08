package com.vdan.automotive.parts.aggregation.analyzer.model;

import com.vdan.automotive.parts.aggregation.core.parts.AutomotivePartData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class AnalyzerResult implements Serializable {
    private final List<AutomotivePartData> data;
}
