package rocks.basset.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("controllers")
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

        assertThat(controller.index()).isEqualTo("index");
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

    @Test
    @EnabledOnOs(OS.MAC)
    void testMeOnMacOS(){

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testMeOnWindows(){

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testMeOnJava8(){

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testMeOnJava11(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "username", matches = "jt")
    void testIfUserJT(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "username", matches = "bassett")
    void testIfUserBassett(){

    }
}
