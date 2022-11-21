package rocks.basset.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

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
    }
}
