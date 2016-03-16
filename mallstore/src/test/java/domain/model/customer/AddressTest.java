package domain.model.customer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by DeKi on 3/16/2016.
 */
public class AddressTest {
    private String street;
    private String number;
    private int zip;

    @Before
    public void setUp() {
        street = "Street";
        number = "number";
        zip = 123;

    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNullStreet() {
        new Address(null, number, zip);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNullStreetNumber() {
        new Address(street, null, zip);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNegativeZip() {
        new Address(street,number, -10234);
    }

    @Test
    public void checkImmutability() {
        Address address1 = new Address("Street", "number" , 123);
        Address address2 = address1.changeStreet("Street2");
        assertEquals("Street", address1.getStreet());
        assertNotEquals(address1.getStreet(),address2.getStreet());
    }
}