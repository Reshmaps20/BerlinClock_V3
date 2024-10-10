package com.bnpp.kata.berlinclock.service;

import com.bnpp.kataexam.berlinclock.model.BerlinClockResponse;
import com.bnpp.kataexam.berlinclock.model.DetailedBerlinTime;
import com.bnpp.kataexam.berlinclock.model.TimeComponent;
import org.springframework.stereotype.Service;

@Service
public class BerlinClockService {

	public BerlinClockResponse convertToBerlinTime(TimeComponent time) {

		String result = (Integer.parseInt(time.getSeconds()) % 2 == 0) ? "Y" : "O";

		return BerlinClockResponse.builder()
				.digitalTime(null)
				.detailedBerlinTime(DetailedBerlinTime.builder().topFiveHourLamps("OOOO").build())
				.berlinTime(result)
				.build();
	}
}
