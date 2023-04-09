package net.c0r3.javachallanges;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Ex01_BasicTest {


    @ParameterizedTest
    @CsvSource(value = {
            "6,7,0",
            "3,4,6",
            "5,5,5"
    })
    void basicTest(int param1, int param2, int expected) {
        var actual = Ex01_Basic.calc(param1, param2);
        assertEquals(expected, actual);
    }
}