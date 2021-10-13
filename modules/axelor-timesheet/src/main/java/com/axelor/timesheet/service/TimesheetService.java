package com.axelor.timesheet.service;

import com.axelor.project.db.Timesheet;

public interface TimesheetService {
  public Timesheet computetotalHrs(Timesheet timesheet);

  public Timesheet fromDate(Timesheet timesheet);
}
