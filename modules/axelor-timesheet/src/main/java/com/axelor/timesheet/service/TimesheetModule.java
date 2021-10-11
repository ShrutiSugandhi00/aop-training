 package com.axelor.timesheet.service;

 import com.axelor.app.AxelorModule;

 public class TimesheetModule extends AxelorModule {

  @Override
  protected void configure() {
    bind(TimesheetService.class).to(TimesheetServiceImpl.class);
    

  }
 }
