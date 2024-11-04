package com.juliomesquita.study.java_dsa.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @Test
    void givenAValidArrayParamsAndItem_whenCallsBinarySearch_thenDoesNotThrows(){
        //given
        final int[] expectedNums = {1,2,3,5,7,8,14,36,47,58,60,70,89,98,123,1234,134345,56457,8787698};
        final int expectedNum = 1;

        //when
//        BinarySearch.binarySearch(expectedNums, expectedNum);
    }

    @Test
    void searchInsertPosition(){
        final int[] input = {1,3,5,6};
        final int response = BinarySearch.searchInsertPosition(input, 7);
        assertEquals(3,  response);
    }

}