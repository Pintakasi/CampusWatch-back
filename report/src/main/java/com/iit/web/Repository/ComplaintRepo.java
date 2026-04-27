package com.iit.web.Repository;

import com.iit.web.Dto.CreateComplaintDto;
import com.iit.web.Helper.IdGenerator;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@Repository
public class ComplaintRepo
{
    private final JdbcTemplate jdbc;

    @Autowired
    ComplaintRepo(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }
    public void create(CreateComplaintDto dto, int reporter_id)
    {

        String sql = "INSERT INTO complaints (report_ticket_num, fk_reporter, category, description, priority_level,location_scope, nearest_building, outside_area, building, floor, room, created_at, evidence, incident_date, incident_time, witnesses, assigned_admin) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String reportTicketId = IdGenerator.generateId();
        System.out.println(dto.category());

        jdbc.update(
                sql, reportTicketId, reporter_id, dto.category(), dto.description(),
                dto.priorityLevel(),dto.locationScope(),dto.nearestBuilding(),dto.outsideArea(),dto.building(), dto.floor(),dto.room(),
                LocalDateTime.now(), dto.evidence(),
                dto.incidentDate(),dto.incidentTime(), dto.witnesses(), "BEHAVIORAL"
                );

        Integer[] accusedIds = dto.accusedIds();
        if(accusedIds != null){
            String s = "INSERT INTO Complaints_Accused (fk_report_ticket_id, fk_accused_id) VALUES (?,?)";

        for(int i=0; i<accusedIds.length; i++){
            jdbc.update(s, reportTicketId, accusedIds[i]);
        }
        }
    }



}
