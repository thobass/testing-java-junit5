package rocks.basset.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import rocks.basset.sfgpetclinic.ControllerTests;
import rocks.basset.sfgpetclinic.ModelTests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions(){
        Owner o = new Owner(1l, "Joe", "Buck");
        o.setCity("Key West");
        o.setTelephone("1231231234");

        assertAll("Properties Test",
                () -> {
                    assertAll("Person Properties",
                            () -> assertEquals("Joe", o.getFirstName(), "First Name did not match"),
                            () -> assertEquals("Buck", o.getLastName()));
                },
                () -> {
                    assertAll("Owner Properties",
                            () -> assertEquals("Key West", o.getCity(), "City did not match"),
                            () -> assertEquals("1231231234", o.getTelephone()));
                });

        assertThat(o.getCity(), is("Key West"));
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name= ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + " - " + ParameterizedTest.DEFAULT_DISPLAY_NAME)
    @ValueSource(strings = {"Spring","Framework","Guru"})
    void testValueSource(String val){
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name= ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + " - " + ParameterizedTest.DEFAULT_DISPLAY_NAME)
    @EnumSource(OwnerType.class)
    void testEnumSource(OwnerType ownerType){
        System.out.println(ownerType);
    }

    @DisplayName("Csv Source Test")
    @ParameterizedTest(name= ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + " - " + ParameterizedTest.DEFAULT_DISPLAY_NAME)
    @CsvSource({
            "FL,1,1",
            "OH,2,2",
            "MI,1,1"
    })
    void testCsvSource(String stateName, int val1, int val2){
        System.out.println(stateName + " = " + val1 + " : " + val2);
    }

    @DisplayName("Csv File Source Test")
    @ParameterizedTest(name= ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + " - " + ParameterizedTest.DEFAULT_DISPLAY_NAME)
    @CsvFileSource(resources="/input.csv", numLinesToSkip = 1)
    void testCsvFileSource(String stateName, int val1, int val2){
        System.out.println(stateName + " = " + val1 + " : " + val2);
    }
}
