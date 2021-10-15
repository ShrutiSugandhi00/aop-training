package com.axelor.timesheet.service;

import com.axelor.app.AxelorModule;
import com.axelor.project.db.repo.AbstractTimesheetRepository;
import com.axelor.project.db.repo.TimesheetRepository;

public class TimesheetModule extends AxelorModule {

  @Override
  protected void configure() {
    bind(TimesheetService.class).to(TimesheetServiceImpl.class);
    bind(AbstractTimesheetRepository.class).to(TimesheetRepository.class);
  }
}
