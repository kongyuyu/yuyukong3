package com.yuyukong;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.assertEquals;

/**
 * Created by Yuyu Kong on 7/9/2015.
 * For Comcast Interview
 */
public class ItemTest {
    //check Item setters
    @Test(dataProvider = "setterData")
    public void testSetters(int price, String type, boolean expect) {
        Item item = new Item();
        assertEquals(item.setPrice(price), expect);
        assertEquals(item.setType(type), expect);
    }

    //check Item getters
    @Test(dataProvider = "getterData")
    public void testGetters(Item item, int expectPrice, String expectType) {
        assertEquals(item.getPrice(), expectPrice);
        assertEquals(item.getType(), expectType);
    }

    //check calculatePrice method
    @Test(dataProvider = "calculatorData")
    public void testCalculator(Item item, long expectTotal) {
        assertEquals(item.calculatePrice(), expectTotal);
    }

    @DataProvider
    public Object[][] setterData() {
        return new Object[][] {
                {-1, "", false},
                {0, "luxury", true},
                {100, "necessary", true},
                {2147483647, "necessary", true},
        };
    }

    @DataProvider
    public Object[][] getterData() {
        return new Object[][] {
                {new Item(0, Item.Type.necessary), 0, Item.Type.necessary},
                {new Item(100, Item.Type.necessary), 100, Item.Type.necessary},
                {new Item(2147483647, Item.Type.luxury), 2147483647, Item.Type.luxury}
        };
    }

    @DataProvider
    public Object[][] calculatorData() {
        return new Object[][] {
                {new Item(0, Item.Type.necessary), 0},
                {new Item(0, Item.Type.luxury), 0},
                {new Item(100, Item.Type.necessary), 101},
                {new Item(100, Item.Type.luxury), 109},
                {new Item(2147483647, Item.Type.necessary), 2168958483l},
                {new Item(2147483647, Item.Type.luxury), 2340757175l}
        };
    }
}