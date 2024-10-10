package com.bnpp.kata.berlinclock.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BerlinClockServiceTest {

    private BerlinClockService berlinClockService;

    @BeforeEach
    public void setup() {
        berlinClockService = new BerlinClockService();
    }

    @Test
    @DisplayName("Seconds Lamp : should be ON for even seconds")
    public void convertToBerlinTime_passEvenSeconds_secondsLampShouldBeON() {

        String result = berlinClockService.convertToBerlinTime("02");

        assertThat(result).isEqualTo("Y");
    }

    @Test
    @DisplayName("Seconds Lamp in Berlin Clock should be OFF for odd seconds")
    public void convertToBerlinTime_passOddSeconds_secondsLampShouldBeOFF() {

        String result = berlinClockService.convertToBerlinTime("05");

        assertThat(result).isEqualTo("O");
    }
}
