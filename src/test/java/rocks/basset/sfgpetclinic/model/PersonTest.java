package rocks.basset.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import rocks.basset.sfgpetclinic.ControllerTests;
import rocks.basset.sfgpetclinic.ModelTests;

import static org.junit.jupiter.api.Assertions.*;


class PersonTest implements ModelTests {

    @Test
    void groupAssertions(){
        //Given
        Person p = new Person(1l, "Joe","Buck");
        //Then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", p.getFirstName()),
                () -> assertEquals("Buck", p.getLastName())
                );
    }

    @Test
    void groupAssertionsMsgs(){
        //Given
        Person p = new Person(1l, "Joe","Buck");
        //Then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", p.getFirstName(), "First Name Failed"),
                () -> assertEquals("Buck", p.getLastName(), "Last Name Failed")
        );
    }
}
