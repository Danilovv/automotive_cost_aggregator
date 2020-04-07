package com.vdan.automotive.parts.aggregation.aggregation.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SparkConfiguration {

    @Bean
    @Profile("local")
    SparkConf sparkConf() {
        return new SparkConf()
                .setAppName("Danilov Automotiva parts aggregator")
                .setMaster("local[2]");
    }

    @Bean
    JavaSparkContext javaSparkContext(final SparkConf sparkConf) {
        return new JavaSparkContext(sparkConf);
    }
}
