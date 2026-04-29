package com.iit.web.Repository;

import com.iit.web.Dto.CreateComplaintDto;
import com.iit.web.Helper.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ComplaintRepo
{
    private final JdbcTemplate jdbc;

    @Autowired
    ComplaintRepo(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }
    public void create(CreateComplaintDto dto, MultipartFile evidence, int reporter_id) throws IOException, IOException
    {

        String sql = "INSERT INTO complaints " +
                "(report_ticket_num, fk_reporter, category, description, priority_level," +
                " location_scope, nearest_building, outside_area, building, floor, room," +
                " created_at, evidence, incident_date, incident_time, witnesses, assigned_admin, accused_description) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String reportTicketId = IdGenerator.generateId();

        byte[] evidenceBytes = null;
        if (evidence != null && !evidence.isEmpty()) {
            evidenceBytes = evidence.getBytes();
        }

        String catGrouping;
        if(dto.category().startsWith("B")){
            catGrouping = "BEHAVIORAL";
        }else{
            catGrouping = "MAINTENANCE";
        }

        jdbc.update(
                sql,
                reportTicketId,
                reporter_id,
                dto.category(),
                dto.description(),
                dto.priorityLevel(),
                dto.locationScope(),
                dto.nearestBuilding(),
                dto.outsideArea(),
                dto.building(),
                dto.floor(),
                dto.room(),
                LocalDateTime.now(),
                evidenceBytes,
                dto.incidentDate(),
                dto.incidentTime(),
                dto.witnesses(),
                catGrouping,
                dto.accusedDescription()
        );

        List<Integer> accusedIds = dto.accusedIds();
        if (accusedIds != null && !accusedIds.isEmpty()) {
            String s = "INSERT INTO Complaints_Accused (fk_report_ticket_id, fk_accused_id) VALUES (?, ?)";
            accusedIds.forEach(id -> jdbc.update(s,reportTicketId,id));
        }
    }
}
