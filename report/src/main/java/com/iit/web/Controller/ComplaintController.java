package com.iit.web.Controller;

import com.iit.web.Dto.CreateComplaintDto;
import com.iit.web.Repository.ComplaintRepo;
import com.sun.jdi.IntegerValue;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/create")
    void createComplaint(@RequestBody CreateComplaintDto complaintDto, HttpSession session){

        Integer reporter_id = (Integer) session.getAttribute("userId");
        System.out.println("Session ID: " + session.getId());
        System.out.println(reporter_id);
        complaintRepository.create(complaintDto, reporter_id);
    }
}
