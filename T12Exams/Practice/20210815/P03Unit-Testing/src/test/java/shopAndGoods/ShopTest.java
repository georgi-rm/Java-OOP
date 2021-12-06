package shopAndGoods;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

import static org.junit.Assert.*;

public class ShopTest {

    private static final String FIRST_SHELVE = "Shelves1";
    private static final String SECOND_SHELVE = "Shelves2";
    private static final String INVALID_SHELVE = "Invalid Shelve";

    private Shop shop;
    private Goods firstValidGoods;
    private Goods secondValidGoods;

    @Before
    public void setUpTests() {
        this.shop = new Shop();
        this.firstValidGoods = new Goods("Banana", "1");
        this.secondValidGoods = new Goods("Carrot", "2");
    }

    @Test
    public void testConstructorCreateMapWithShelves() {
        Shop shop = new Shop();
        assertFalse(shop.getShelves().isEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelvesReturnUnmodifiableCollection() {
        this.shop.getShelves().clear();
    }

    @Test
    public void testAddGoodsWithValidShelfAndGoods() throws OperationNotSupportedException {
        String result = this.shop.addGoods(FIRST_SHELVE, this.firstValidGoods);
        String expected = String.format("Goods: %s is placed successfully!", this.firstValidGoods.getGoodsCode());
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsWithInvalidShelf() throws OperationNotSupportedException {
        this.shop.addGoods(INVALID_SHELVE, this.firstValidGoods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsWithTwoDifferentGoodsOnOneShelve() throws OperationNotSupportedException {
        this.shop.addGoods(FIRST_SHELVE, this.firstValidGoods);
        this.shop.addGoods(FIRST_SHELVE, this.secondValidGoods);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsWithTwoTheSameGoodsOnDifferentShelves() throws OperationNotSupportedException {
        this.shop.addGoods(FIRST_SHELVE, this.firstValidGoods);
        this.shop.addGoods(SECOND_SHELVE, this.firstValidGoods);
    }


    @Test
    public void testRemoveGoodsWithValidValues() throws OperationNotSupportedException {
        this.shop.addGoods(FIRST_SHELVE, this.firstValidGoods);
        String result = this.shop.removeGoods(FIRST_SHELVE, this.firstValidGoods);
        String expected = String.format("Goods: %s is removed successfully!", this.firstValidGoods.getGoodsCode());
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsWithInvalidShelf() {
        this.shop.removeGoods(INVALID_SHELVE, this.firstValidGoods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsRemoveDifferentGoods() throws OperationNotSupportedException {
        this.shop.addGoods(FIRST_SHELVE, this.firstValidGoods);
        this.shop.removeGoods(FIRST_SHELVE, this.secondValidGoods);
    }

    @Test
    public void testRemoveGoodsShouldSetShelveToNull() throws OperationNotSupportedException {
        this.shop.addGoods(FIRST_SHELVE, this.firstValidGoods);
        this.shop.removeGoods(FIRST_SHELVE, this.firstValidGoods);
        assertNull(this.shop.getShelves().get(FIRST_SHELVE));
    }
}
