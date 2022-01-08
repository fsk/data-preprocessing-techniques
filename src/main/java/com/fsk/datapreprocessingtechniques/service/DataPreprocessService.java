package com.fsk.datapreprocessingtechniques.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DataPreprocessService {

    private DataPreprocessService(){}

    private static final String SHEET_NAME = "pima";
    private static final String PATH = "C:\\Users\\FSK\\Desktop\\yukseklisans\\data-preprocessing-techniques\\src\\main\\resources\\verionisleme.xlsx";
    private static int CELL_NUMBER = 0;
    private static ArrayList<Double> cellList = new ArrayList<>();


    public double average(String columnName) throws IOException {


        switch (columnName) {
            case "Insu" -> CELL_NUMBER = 4;
            case "Mass" -> CELL_NUMBER = 5;
            case "Pedi" -> CELL_NUMBER = 6;
            case "Age" -> CELL_NUMBER = 7;
            default -> CELL_NUMBER = -1;
        }
        File file = new File(PATH);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        cellList.clear();

        Sheet sheet = wb.getSheet(SHEET_NAME);

        for (Row row : sheet) {
            Cell cell = row.getCell(CELL_NUMBER);
            if (!cell.toString().equals("Age") && !cell.toString().equals("Insu")
                    && !cell.toString().equals("Mass") && !cell.toString().equals("Pedi")) {
                cellList.add(cell.getNumericCellValue());
            }
        }

        OptionalDouble average = cellList.stream().mapToDouble(value -> value).average();


        return average.getAsDouble();
    }

    public Double mode(String columnName) throws IOException {

        switch (columnName) {
            case "Insu" -> CELL_NUMBER = 4;
            case "Mass" -> CELL_NUMBER = 5;
            case "Pedi" -> CELL_NUMBER = 6;
            case "Age" -> CELL_NUMBER = 7;
            default -> CELL_NUMBER = -1;
        }
        File file = new File(PATH);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(SHEET_NAME);

        cellList.clear();

        for (Row row : sheet) {
            Cell cell = row.getCell(CELL_NUMBER);
            if (!cell.toString().equals("Age") && !cell.toString().equals("Insu")
                    && !cell.toString().equals("Mass") && !cell.toString().equals("Pedi")) {
                cellList.add(cell.getNumericCellValue());
            }
        }
        List<Double> modes =
                cellList.stream()
                        .collect(Collectors.groupingBy(Function.identity(),
                                Collectors.counting())) // Map<Integer,Long>
                        .entrySet()
                        .stream()
                        .collect(Collectors.groupingBy(Map.Entry::getValue,
                                TreeMap::new,
                                Collectors.mapping(Map.Entry::getKey,
                                        Collectors.toList())))
                        .lastEntry()
                        .getValue(); // you want the last value of the TreeMap

        return modes.get(0);
    }


    public Double standartDeviation(String columnName) throws IOException {
        switch (columnName) {
            case "Insu" -> CELL_NUMBER = 4;
            case "Mass" -> CELL_NUMBER = 5;
            case "Pedi" -> CELL_NUMBER = 6;
            case "Age" -> CELL_NUMBER = 7;
            default -> CELL_NUMBER = -1;
        }
        File file = new File(PATH);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        Sheet sheet = wb.getSheet(SHEET_NAME);

        cellList.clear();

        for (Row row : sheet) {
            Cell cell = row.getCell(CELL_NUMBER);
            if (!cell.toString().equals("Age") && !cell.toString().equals("Insu")
                    && !cell.toString().equals("Mass") && !cell.toString().equals("Pedi")) {
                cellList.add(cell.getNumericCellValue());
            }
        }

        final double average =
                cellList.stream()
                        .mapToDouble((x) -> x.doubleValue())
                        .summaryStatistics()
                        .getAverage();

        final double rawSum =
                cellList.stream()
                        .mapToDouble((x) -> Math.pow(x.doubleValue() - average,
                                2.0))
                        .sum();


        return Math.sqrt(rawSum / (cellList.size() - 1));

    }




    public double IQR(String columnName) throws IOException {

        int n = 2;

        switch (columnName) {
            case "Insu" -> CELL_NUMBER = 4;
            case "Mass" -> CELL_NUMBER = 5;
            case "Pedi" -> CELL_NUMBER = 6;
            case "Age" -> CELL_NUMBER = 7;
            default -> CELL_NUMBER = -1;
        }
        File file = new File(PATH);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        Sheet sheet = wb.getSheet(SHEET_NAME);

        for (Row row : sheet) {
            Cell cell = row.getCell(CELL_NUMBER);
            if (!cell.toString().equals("Age") && !cell.toString().equals("Insu")
                    && !cell.toString().equals("Mass") && !cell.toString().equals("Pedi")) {
                cellList.add(cell.getNumericCellValue());
            }
        }

        Collections.sort(cellList);

        int mid_index = (int) median(cellList, 0, n);

        double Q1 = cellList.get((int) median(cellList, 0, mid_index));
        double Q3 = cellList.get((int) (mid_index + median(cellList, mid_index + 1, n)));

        double result = Q3 - Q1;
        cellList.clear();

        return result;
    }

    public List minMaxNormalization(String columnName) throws IOException {
        switch (columnName) {
            case "Insu" -> CELL_NUMBER = 4;
            case "Mass" -> CELL_NUMBER = 5;
            case "Pedi" -> CELL_NUMBER = 6;
            case "Age" -> CELL_NUMBER = 7;
            default -> CELL_NUMBER = -1;
        }
        File file = new File(PATH);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(SHEET_NAME);

        cellList.clear();

        for (Row row : sheet) {
            Cell cell = row.getCell(CELL_NUMBER);
            if (!cell.toString().equals("Age") && !cell.toString().equals("Insu")
                    && !cell.toString().equals("Mass") && !cell.toString().equals("Pedi")) {
                cellList.add(cell.getNumericCellValue());
            }
        }

        OptionalDouble maxValue = cellList.stream().mapToDouble(value -> value).max();
        OptionalDouble minValue = cellList.stream().mapToDouble(value -> value).min();

        int newMin = 0;
        int newMax = 1;

        List<Double> result = cellList.stream().map(value -> (value - minValue.getAsDouble())
                / ((maxValue.getAsDouble() - minValue.getAsDouble())
                * (newMax - newMin) + newMin)).collect(Collectors.toList());

        cellList.clear();

        return result;
    }



    private double median(List<Double> list, int l, int r) {
        int n = r - l + 1;
        n = (n + 1) / 2 + 1;
        return n + 1;
    }


}
