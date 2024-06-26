package com.juliomesquita.study.java_dsa.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOneDimensionTest {
    ArrayOneDimension a;

    @BeforeEach
    public void setup() {
        a = new ArrayOneDimension(3);
    }

    @Test
    public void testAddItemWithFor() {
        boolean a1 = a.addItemWithFor("a");
        boolean a2 = a.addItemWithFor("b");
        boolean a3 = a.addItemWithFor("c");
        boolean a4 = a.addItemWithFor("d");
        assertTrue(a1);
        assertTrue(a2);
        assertTrue(a3);
        assertFalse(a4);
    }

    @Test
    public void testAddItemWithStream() {
        boolean a1 = a.addItemWithStream("a");
        boolean a2 = a.addItemWithStream("b");
        boolean a3 = a.addItemWithStream("c");
        boolean a4 = a.addItemWithStream("d");
        assertTrue(a1);
        assertTrue(a2);
        assertTrue(a3);
        assertFalse(a4);
    }

    @Test
    public void testAddItemWithLimit() {
        boolean a1 = a.addItemWithLimit("a");
        boolean a2 = a.addItemWithLimit("b");
        boolean a3 = a.addItemWithLimit("c");
        boolean a4 = a.addItemWithLimit("d");
        assertTrue(a1);
        assertTrue(a2);
        assertTrue(a3);
        assertFalse(a4);
    }

    @Test
    public void testToArrayString() {
        a.addItemWithLimit("a");
        String text1 = a.toArrayString();
        a.addItemWithLimit("b");
        String text2 = a.toArrayString();

        assertAll("Compare Texts",
                () -> assertTrue(text1.contains("a")),
                () -> assertEquals("[a, b]", text2)
        );
    }


}