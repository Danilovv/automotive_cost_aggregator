package com.vdan.automotive.parts.aggregation.core.parts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public class AutomotivePartData implements Serializable {
    private final String key;
    private final Double cost;
    private final String currency;
}
