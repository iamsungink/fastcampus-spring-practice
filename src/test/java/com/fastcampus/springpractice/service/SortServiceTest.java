package com.fastcampus.springpractice.service;

import com.fastcampus.springpractice.logic.BubbleSort;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortServiceTest {

    //system under test
    private SortService sut = new SortService(new BubbleSort<>());


    @Test
    void test() {

        // Given

        // When
        List<String> actual = sut.doSort(List.of("3", "2", "1"));

        // Then
        assertEquals(List.of("1","2","3"), actual);
    }

}