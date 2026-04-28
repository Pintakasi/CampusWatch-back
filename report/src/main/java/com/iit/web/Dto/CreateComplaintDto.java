package com.iit.web.Dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record CreateComplaintDto(
        String category,
        String description,
        Integer priorityLevel,
        String locationScope,
        String nearestBuilding,
        String outsideArea,
        String building,
        Integer floor,
        String room,
        LocalDate incidentDate,
        LocalTime incidentTime,
        List<Integer> accusedIds,
        String witnesses,
        String accusedDescription
) {
}