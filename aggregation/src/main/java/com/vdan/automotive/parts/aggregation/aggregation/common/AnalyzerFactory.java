package com.vdan.automotive.parts.aggregation.aggregation.common;

import com.google.common.collect.Maps;
import com.vdan.automotive.parts.aggregation.analyzer.AnalyzerKey;
import com.vdan.automotive.parts.aggregation.analyzer.model.Analyzer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public final class AnalyzerFactory {
    private final Map<AnalyzerKey, Analyzer> analyzers = Maps.newConcurrentMap();

    public AnalyzerFactory(final List<Analyzer> analyzers) {
        analyzers.forEach(a -> this.analyzers.put(a.key(), a));
    }

    public final Analyzer get(final AnalyzerKey key) {
        return analyzers.get(key);
    }
}
