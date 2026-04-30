package com.iit.web.Dto;

import com.iit.web.enums.ComplaintCategory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record CreateComplaintDto(
        ComplaintCategory category,
        String description,
        Integer priorityLevel,
        String locationScope,
        String building,
        Integer floor,
        String room,
        String specificLocation,
        String zone,
        LocalDate incidentDate,
        LocalTime incidentTime,
        List<Integer> accusedIds,
        String witnesses,
        String accusedDescription,
        Boolean isHazardous
)
{
}