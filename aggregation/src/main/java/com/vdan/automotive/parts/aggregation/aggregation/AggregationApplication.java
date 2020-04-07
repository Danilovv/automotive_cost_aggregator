package com.vdan.automotive.parts.aggregation.aggregation;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class AggregationApplication implements CommandLineRunner {

    private final JavaSparkContext javaSparkContext;

    public static void main(String[] args) {
        SpringApplication.run(AggregationApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        try(final JavaSparkContext ctx = javaSparkContext) {
            final JavaDoubleRDD rdd = ctx.parallelizeDoubles(Lists.newArrayList(1.0d, 2.0d, 3.0d));
            final Double sum = rdd.sum();

            System.out.println(String.format("Result = %s", sum));
        }
    }
}
