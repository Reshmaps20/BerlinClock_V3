package com.bnpp.kata.berlinclock.service;

import com.bnpp.kataexam.berlinclock.model.BerlinClockResponse;
import com.bnpp.kataexam.berlinclock.model.TimeComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BerlinClockServiceTest {

	private BerlinClockService berlinClockService;
	private static final String ZERO = "00";
	private static final String TWO = "02";
	private static final String FIVE = "05";
	private static final String YELLOW = "Y";
	private static final String OFF = "O";
	private static final String ALLOFF = "OOOO";


	@BeforeEach
	public void setup() {
		berlinClockService = new BerlinClockService();
	}

	@Test
	@DisplayName("Seconds Lamp : should be ON for even seconds")
	public void convertToBerlinTime_passEvenSeconds_secondsLampShouldBeON() {

		TimeComponent timeComponent = TimeComponent.builder()
				.hours(ZERO)
				.minutes(ZERO)
				.seconds(TWO)
				.build();

		BerlinClockResponse result = berlinClockService.convertToBerlinTime(timeComponent);

		assertThat(result.getBerlinTime()).contains(YELLOW);
	}

	@Test
	@DisplayName("Seconds Lamp : should be OFF for odd seconds")
	public void convertToBerlinTime_passOddSeconds_secondsLampShouldBeOFF() {

		TimeComponent timeComponent = TimeComponent.builder()
				.hours(ZERO)
				.minutes(ZERO)
				.seconds(FIVE)
				.build();

		BerlinClockResponse result = berlinClockService.convertToBerlinTime(timeComponent);

		assertThat(result.getBerlinTime()).contains(OFF);
	}

	@Test
	@DisplayName("Five Hour Row : should be OFF when given hour is less than 5")
	public void convertToBerlinTime_passHoursLessThanFive_allFiveHourLampShouldBeOFF() {

		TimeComponent timeComponent = TimeComponent.builder()
				.hours(TWO)
				.minutes(ZERO)
				.seconds(FIVE)
				.build();

		BerlinClockResponse response = berlinClockService.convertToBerlinTime(timeComponent);

		assertThat(response.getDetailedBerlinTime().getTopFiveHourLamps()).isEqualTo(ALLOFF);
	}
}
