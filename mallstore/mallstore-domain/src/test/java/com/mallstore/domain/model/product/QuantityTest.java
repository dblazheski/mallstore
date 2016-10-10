package com.mallstore.domain.model.product;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DeKi on 4/3/2016.
 */
public class QuantityTest {

    private Integer value;
    private Quantity quantity;


    @Before
    public void setUp() throws Exception {
        this.value = 10;
        this.quantity = new Quantity(this.value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNullQuantity() {
        quantity = new Quantity(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void increaseQuantityNegativeValue() {
        quantity.add(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void increaseNullArgument() {
        quantity.add(null);
    }

    @Test
    public void testIncrease() throws Exception {
        quantity = quantity.add(5);
        assertEquals(new Integer(15), quantity.getQuantity());
    }

    @Test
    public void testDecrease() throws Exception {
        quantity = quantity.minus(5);
        assertEquals(new Integer(5), quantity.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void decreaseNullArgument() throws Exception {
        quantity.minus(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decreaseNegativeValue() {
        quantity.minus(-4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decreaseQuantityGreaterThanCurrentQuantity() {
        quantity.minus(11);
    }

    @Test
    public void hasQuantityTrue() {
        assertEquals(true, quantity.hasQuantity());
    }

    @Test
    public void hasQuantityFalse() {
        this.quantity = new Quantity(0);
        assertEquals(false, quantity.hasQuantity());
    }
}