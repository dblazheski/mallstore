package com.mallstore.domain.model.customer;

import com.mallstore.domain.model.customer.address.Address;
import com.mallstore.domain.model.customer.address.Street;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by DeKi on 3/16/2016.
 */
public class AddressTest {
    private Street street;
    private String city;
    private String country;

    @Before
    public void setUp() {
        street = new Street("Street", "Number", 1234);
        city = "city";
        country = "city";

    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNullStreet() {
        new Address(null, city, country);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNullStreetNumber() {
        new Address(street, null, country);
    }

    @Test
    public void checkImmutability() {
        Address address1 = new Address(street, city , country);
        Address address2 = address1.changeStreet(new Street("Street2", "Number", 1234));
        assertEquals(street, address1.getStreet());
        assertNotEquals(address1.getStreet(),address2.getStreet());
    }
}