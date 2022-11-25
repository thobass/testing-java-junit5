package rocks.basset.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model")

class PersonTest {

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
