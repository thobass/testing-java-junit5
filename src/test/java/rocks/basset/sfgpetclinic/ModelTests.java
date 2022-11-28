package rocks.basset.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("model")
public interface ModelTests {
    @BeforeEach
    default void beforEachConsoleOutputer(TestInfo testInfo){
        System.out.println("Running Test - " + testInfo.getDisplayName());
    }
}
