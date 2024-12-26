package com.veeva.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

    static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeAll
    public static void setup() {
        logger.info("Starting tests...");
    }

    @AfterAll
    public static void teardown() {
        logger.info("Tests finished.");
    }
}
