package com.fsk.datapreprocessingtechniques.controller;

import com.fsk.datapreprocessingtechniques.service.DataPreprocessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class DataPreprocess {

    private final DataPreprocessService dataPreprocessService;

    public DataPreprocess(DataPreprocessService dataPreprocessService) {
        this.dataPreprocessService = dataPreprocessService;
    }

    @GetMapping("/average/{columnName}")
    public double average(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.average(columnName);
    }

    @GetMapping("/mode/{columnName}")
    public Double mode(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.mode(columnName);
    }

    @GetMapping("/standartDeviation/{columnName}")
    public Double standartDeviation(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.standartDeviation(columnName);
    }


    @GetMapping("/iqr/{columnName}")
    public Double iqr(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.IQR(columnName);
    }

    @GetMapping("min-max-normalization/{columnName}")
    public List minMaxNormalization(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.minMaxNormalization(columnName);
    }


    @GetMapping("five-number-summary/{columnName}")
    public Map<String, Double> fiveNumberSummary(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.fiveNumberSummary(columnName);
    }


    @GetMapping("z-score-normalization/{columnName}")
    public List<Double> zScoreNormalization(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.zScoreNormalization(columnName);
    }


    @GetMapping("three-width-equal/{columnName}")
    public List<List<Double>> threeWidthEqual(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.threeEqualWidth(columnName);
    }







}
