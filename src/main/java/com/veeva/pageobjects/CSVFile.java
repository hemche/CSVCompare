package com.veeva.pageobjects;

import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {
    private static final Logger logger = LogUtil.getLogger(CSVFile.class);
    private List<String[]> rows;

    public CSVFile(String filePath) throws IOException {
        logger.info("Reading CSV file from path: {}", filePath);
        this.rows = readCSVFile(filePath);
    }

    private List<String[]> readCSVFile(String filePath) throws IOException {
        List<String[]> content = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            content.add(normalizeLine(line));
        }
        reader.close();
        logger.info("Finished reading CSV file: {}", filePath);
        return content;
    }

    private String[] normalizeLine(String line) {
        String[] columns = line.split("\\s*,\\s*");
        for (int i = 0; i < columns.length; i++) {
            columns[i] = columns[i].trim();
        }
        return columns;
    }

    public List<String[]> getRows() {
        return rows;
    }

    public boolean compare(CSVFile otherFile) {
        logger.info("Starting comparison between two CSV files...");
        List<String[]> otherRows = otherFile.getRows();

        if (this.rows.size() != otherRows.size()) {
            logger.warn("The files have different number of rows: {} vs {}", this.rows.size(), otherRows.size());
            return false;
        }

        for (int i = 0; i < this.rows.size(); i++) {
            String[] row1 = this.rows.get(i);
            String[] row2 = otherRows.get(i);
            if (!compareRows(row1, row2)) {
                logger.error("Files differ at row {}.", i + 1);
                return false;
            }
        }

        logger.info("CSV files are identical.");
        return true;
    }

    private boolean compareRows(String[] row1, String[] row2) {
        if (row1.length != row2.length) {
            logger.error("Row lengths differ: {} vs {}", row1.length, row2.length);
            return false;
        }

        for (int i = 0; i < row1.length; i++) {
            if (!row1[i].equals(row2[i])) {
                logger.error("Row mismatch at column {}: {} vs {}", i + 1, row1[i], row2[i]);
                return false;
            }
        }

        return true;
    }
}
