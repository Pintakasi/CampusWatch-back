package com.iit.web.enums;

public enum ComplaintCategory
{
    //Behavioral
    BULLYING(Office.BEHAVIORAL),
    HARASSMENT(Office.BEHAVIORAL),
    CHEATING(Office.BEHAVIORAL),
    THEFT(Office.BEHAVIORAL),
    VANDALISM(Office.BEHAVIORAL),

    //MAINTENANCE
    ELECTRICAL(Office.MAINTENANCE),
    PLUMBING(Office.MAINTENANCE);



    private final Office assignedOffice;
    ComplaintCategory(Office assignedOffice)
    {
        this.assignedOffice = assignedOffice;
    }

    public Office getAssignedOffice(){
        return this.assignedOffice;
    }
}
