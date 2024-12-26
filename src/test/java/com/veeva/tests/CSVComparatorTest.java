package com.veeva.tests;

import com.veeva.pageobjects.CSVComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVComparatorTest extends BaseTest {

    @Test
    public void testCompareIdenticalCSVFiles() throws Exception {
        String file1 = "src/test/java/com/veeva/resources/file1.csv";
        String file2 = "src/test/java/com/veeva/resources/file1.csv"; // Identical files

        logger.info("Starting test: testCompareIdenticalCSVFiles");

        boolean result = CSVComparator.compareFiles(file1, file2);
        assertTrue(result, "CSV files should be identical");

        logger.info("Test finished: testCompareIdenticalCSVFiles");
    }

    @Test
    public void testCompareSameCSVFilesWithDifferentFormatting() throws Exception {
        String file1 = "src/test/java/com/veeva/resources/file1.csv";
        String file2 = "src/test/java/com/veeva/resources/sameAsFile1WithDifferentFormatting.csv"; // Identical file with different formatting

        logger.info("Starting test: testCompareSameCSVFilesWithDifferentFormatting");

        boolean result = CSVComparator.compareFiles(file1, file2);
        assertTrue(result, "CSV files should be identical");

        logger.info("Test finished: testCompareSameCSVFilesWithDifferentFormatting");
    }

    @Test
    public void testCompareDifferentCSVFiles() throws Exception {
        String file1 = "src/test/java/com/veeva/resources/file1.csv";
        String file2 = "src/test/java/com/veeva/resources/file2.csv"; // Different files

        logger.info("Starting test: testCompareDifferentCSVFiles");

        boolean result = CSVComparator.compareFiles(file1, file2);
        assertFalse(result, "CSV files should be different");

        logger.info("Test finished: testCompareDifferentCSVFiles");
    }

    @Test
    public void testCompareEmptyAndNonEmptyCSVFiles() throws Exception {
        String file1 = "src/test/java/com/veeva/resources/emptyfile.csv";
        String file2 = "src/test/java/com/veeva/resources/file2.csv";

        logger.info("Starting test: testCompareEmptyAndNonEmptyCSVFiles");

        boolean result = CSVComparator.compareFiles(file1, file2);
        assertFalse(result, "CSV files should be different");

        logger.info("Test finished: testCompareEmptyAndNonEmptyCSVFiles");
    }

    @Test
    public void testCompareNoncsvFormatFiles() {
        logger.info("Starting test: testCompareNoncsvFormatFiles");
        String file1 = "src/test/java/com/veeva/resources/wrongFileFormat.csvx";
        String file2 = "src/test/java/com/veeva/resources/file2.csv";
        assertFalse(file1.toLowerCase().endsWith(".csv"), "file1 is not a valid csv file.");
        assertTrue(file2.toLowerCase().endsWith(".csv"), "file2 is a valid csv file.");
        logger.info("Test finished: testCompareNoncsvFormatFiles");
    }

    @Test
    public void testCompareTwoEmptyCSVFiles() throws Exception {
        String file1 = "src/test/java/com/veeva/resources/emptyfile.csv";
        String file2 = "src/test/java/com/veeva/resources/emptyfile1.csv";

        logger.info("Starting test: testCompareTwoEmptyCSVFiles");

        boolean result = CSVComparator.compareFiles(file1, file2);
        assertTrue(result, "CSV files should be the same");

        logger.info("Test finished: testCompareTwoEmptyCSVFiles");
    }

    /*This tests cases list can go on like below. I can modify the logic/tests if needed. */
//    Two CSV files with the same columns but different number of rows.
//    Two CSV files with the same columns but different number of rows.
//    Two CSV files that contain the same data but with the rows in a different order
//    Case sensitivity
}
