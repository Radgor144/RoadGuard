package com.roadguard.monitoring.service.service;

import com.roadguard.monitoring.service.dto.EarDataResponse;
import com.roadguard.monitoring.service.entity.EarData;
import com.roadguard.monitoring.service.repository.EarDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final EarDataRepository earDataRepository;
    private static final int MAX_POINTS = 60;

    public List<EarDataResponse> getEarData(String driverId, LocalDateTime startTime, LocalDateTime endTime) {
        List<EarData> allData = earDataRepository.findByDriverIdAndTimestampBetweenOrderByTimestampAsc(driverId, startTime, endTime);

        int totalPoints = allData.size();
        if (totalPoints == 0) return List.of();

        if (totalPoints <= MAX_POINTS) {
            return allData.stream().map(data -> new EarDataResponse(data.getTimestamp(), data.getAverageEar()))
                                   .toList();
        }

        int groupSize = (int) Math.ceil((double) totalPoints / MAX_POINTS);
        List<EarDataResponse> reduced = new ArrayList<>();

        for (int i = 0; i < totalPoints; i += groupSize) {
            int end = Math.min(i + groupSize, totalPoints);
            List<EarData> group = allData.subList(i, end);
            double avg = group.stream().mapToDouble(EarData::getAverageEar).average().orElse(Double.NaN);
            LocalDateTime timestamp = group.get(group.size() / 2).getTimestamp();
            reduced.add(new EarDataResponse(timestamp, avg));
        }

        return reduced;
    }
}
