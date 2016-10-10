package com.mallstore.domain.model.product;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by DeKi on 4/3/2016.
 */
public class PriceTest {

    private Price price;
    private Float value;

    @Before
    public void setUp() throws Exception {
        this.value = 10.0f;
        this.price = new Price(this.value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNullPrice() {
        this.price = new Price(null);
    }

    @Test
    public void increasePrice() {
        price = price.add(5.0f);
        assertEquals(new Float(15.0f), price.getPrice());
    }

    @Test
    public void decreasePrice() {
        price = price.minus(5.0f);
        assertEquals(new Float(5.0f), price.getPrice());
    }

    @Test(expected = IllegalArgumentException.class)
    public void increasePriceNullArgument() {
        price = price.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void increasePriceNegativeValue() {
        price = price.add(-5.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decreasePriceNullArgument() {
        price = price.minus(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decreasePriceNegativeValue() {
        price = price.minus(-5.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decreasePriceValueGreaterThanCurrentPrice() {
        price = price.minus(11.0f);
    }

    @Test
    public void multiplyByQuantity() {
        Quantity quantity = new Quantity(2);
        Price multipliedPrice = price.multiplyBy(quantity);
        assertEquals(new Float(20.0f), multipliedPrice.getPrice());
    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void multiplyByNullQuantity() {
//        price.multiplyBy(null);
//    }
}