package rocks.basset.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import rocks.basset.sfgpetclinic.ModelRepeatedTest;

public class PersonRepeatedTests implements ModelRepeatedTest {
    @RepeatedTest(value = 10, name =RepeatedTest.DISPLAY_NAME_PLACEHOLDER + " : "
            + RepeatedTest.CURRENT_REPETITION_PLACEHOLDER + " - "
            + RepeatedTest.TOTAL_REPETITIONS_PLACEHOLDER)
    @DisplayName("My repeated test")
    void myRepeatedTest(){
        //Todo impl
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 10, name = RepeatedTest.DISPLAY_NAME_PLACEHOLDER + " : "
            + RepeatedTest.CURRENT_REPETITION_PLACEHOLDER + " | "
            + RepeatedTest.TOTAL_REPETITIONS_PLACEHOLDER)
    @DisplayName("My repeated test assigment")
    void myRepeteatedTestAssigment(){
        //TODO impl
    }
}
