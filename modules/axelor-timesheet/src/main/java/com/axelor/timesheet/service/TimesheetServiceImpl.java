package com.axelor.timesheet.service;

import com.axelor.project.db.Timesheet;
import com.axelor.project.db.TimesheetLines;
import java.math.BigDecimal;

public class TimesheetServiceImpl implements TimesheetService {

  @Override
  public Timesheet computetotalHrs(Timesheet timesheet) {
   // System.err.println("computetotalHrs.........");
    BigDecimal totalhrs = BigDecimal.ZERO;
    if (timesheet.getTimesheetLineList() != null) {
      for (TimesheetLines l : timesheet.getTimesheetLineList()) {
        totalhrs = l.getHours();
      }
    }
    timesheet.setTotalHrs(totalhrs);
    return timesheet;
  }

  @Override
  public Timesheet fromDate(Timesheet timesheet) {
   System.err.println("updating date");
   //timesheet.setFromdate(java.time.LocalDate.now());
   return timesheet;
}
}
