package rocks.basset.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    @DisplayName("Test proper View name is returned for index page")
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view returned.");
        assertEquals("index", controller.index(), () -> "Another Expensive Message " +
                "Make me only if you have to");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oupsHandler();
        });
    }

    @Test
    @Disabled("Demo for timeout")
    void testTimeout(){
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got there");
        });
    }

    @Test
    @Disabled("Demo for timeout")
    void testTimeoutPreempt(){
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got there preemptivly");
        });
    }

    @Test
    void testAssumptionTrue(){
        assumeTrue("ROCKS".equalsIgnoreCase(System.getenv("ROCKS_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue(){
        assumeTrue("ROCKS".equalsIgnoreCase("ROCKS"));
    }
}
