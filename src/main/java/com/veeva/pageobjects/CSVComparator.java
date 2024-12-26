package com.veeva.pageobjects;

import org.slf4j.Logger;

import java.io.IOException;

public class CSVComparator {

    private static final Logger logger = LogUtil.getLogger(CSVComparator.class);

    public static boolean compareFiles(String file1Path, String file2Path) throws IOException {
        logger.info("Starting CSV comparison between '{}' and '{}'.", file1Path, file2Path);

        CSVFile file1 = new CSVFile(file1Path);
        CSVFile file2 = new CSVFile(file2Path);

        boolean comparisonResult = file1.compare(file2);

        if (comparisonResult) {
            logger.info("CSV files are identical.");
        } else {
            logger.error("CSV files are different.");
        }

        return comparisonResult;
    }
}
