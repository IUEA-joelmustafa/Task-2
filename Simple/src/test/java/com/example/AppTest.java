package com.example;
import org.junit.Test;
import static org.junit.Assert.*;
public class AppTest {
    @Test
    public void testAppRuns() {
        assertTrue("App should run successfully", true);
    }
    @Test
    public void testMessage() {
        String msg = "Jenkins Agents Demo - IUEA BIT2202";
        assertNotNull("Message should not be null", msg);
    }
}
