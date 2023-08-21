package com.example.spring_thymeleaf.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.example.spring_thymeleaf.entities.LapTime;
import com.example.spring_thymeleaf.repo.LapTimeRepo;
import com.example.spring_thymeleaf.service.LapTimeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class LapTimeServiceTest {

    LapTimeRepo lapTimeRepo = mock(LapTimeRepo.class);
    List<LapTime> unsortedLapTimes = Arrays.asList(
            new LapTime(15.1),
            new LapTime(13.1),
            new LapTime(14.1),
            new LapTime(12.1),
            new LapTime(11.1),
            new LapTime(16.1),
            new LapTime(17.1)
    );


    @Test
    public void testFindLapTimesInOrder() {

        when(lapTimeRepo.findAll()).thenReturn(unsortedLapTimes);
        LapTimeService lapTimeService = new LapTimeService(lapTimeRepo);

        System.out.println("Unsorted Lap Times:");
        for (LapTime lapTime : unsortedLapTimes) {
            System.out.println(lapTime.getLapTime());
        }

        List<LapTime> sortedLapTimes = lapTimeService.findLapTimes();

        System.out.println("Sorted Lap Times:");
        for (LapTime lapTime : sortedLapTimes) {
            System.out.println(lapTime.getLapTime());
        }

        assertEquals(5, sortedLapTimes.size());
        for (int i = 1; i < sortedLapTimes.size(); i++) {
            assertTrue(sortedLapTimes.get(i - 1).getLapTime() <= sortedLapTimes.get(i).getLapTime());
        }
    }
}