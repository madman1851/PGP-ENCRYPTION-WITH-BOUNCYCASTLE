package com.encr.encryption;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Spark {

    @Value("${spark-inputPath}")
    String inputPath;
    @Value("${spark-outputPath}")
    String outputPath;


    public void readFile(){
        JavaSparkContext sc = new JavaSparkContext("local", "spark");

        JavaRDD<String> rdd = sc.textFile(inputPath);

        rdd.saveAsTextFile(outputPath);
        sc.close();
    }
}
