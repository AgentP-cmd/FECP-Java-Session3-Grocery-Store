package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
        Main.resetInventory();
    }

    @Test
    void testAddValidProduct() {
        String result = Main.addProduct("Banana", 30);
        assertEquals("Product added: Banana (30)", result);
    }

    @Test
    void testAddZeroQuantityProduct() {
        String result = Main.addProduct("Mango", 0);
        assertEquals("Product added: Mango (0)", result);
    }

    @Test
    void testOverwriteExistingProduct() {
        Main.addProduct("Milk", 10);
        String result = Main.addProduct("Milk", 50);
        assertEquals("Product added: Milk (50)", result);
    }

    @Test
    void testCheckExistingProduct() {
        Main.addProduct("Milk", 20);
        assertEquals("Milk is in stock: 20", Main.checkProduct("Milk"));
    }

    @Test
    void testCheckNonExistingProduct() {
        assertEquals("Product not found.", Main.checkProduct("Ice Cream"));
    }

    @Test
    void testUpdateExistingProduct() {
        Main.addProduct("Bread", 10);
        assertEquals("Stock updated: Bread (25)", Main.updateProduct("Bread", 25));
    }

    @Test
    void testUpdateNonExistingProduct() {
        assertEquals("Product not found.", Main.updateProduct("Tofu", 10));
    }

    @Test
    void testRemoveExistingProduct() {
        Main.addProduct("Eggs", 12);
        assertEquals("Product removed: Eggs", Main.removeProduct("Eggs"));
    }

    @Test
    void testRemoveNonExistingProduct() {
        assertEquals("Product not found.", Main.removeProduct("Pizza"));
    }
}
