package com.iit.web.Controller;

import com.iit.web.Dto.CreateComplaintDto;
import com.iit.web.Repository.ComplaintRepo;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/complaints")
@RestController
public class ComplaintController
{

    ComplaintRepo complaintRepository;

    @Autowired
    ComplaintController(ComplaintRepo complaintRepository)
    {
        this.complaintRepository = complaintRepository;
    }
    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void createComplaint(
            @RequestPart("data") CreateComplaintDto complaintDto,
            @RequestPart(value = "evidence", required = false) MultipartFile evidence,
            HttpSession session
    ) throws IOException
    {
        Integer reporter_id = (Integer) session.getAttribute("userId");

        System.out.println("Session ID: " + session.getId());
        System.out.println(reporter_id);

        complaintRepository.create(complaintDto, evidence, reporter_id);
    }
}
