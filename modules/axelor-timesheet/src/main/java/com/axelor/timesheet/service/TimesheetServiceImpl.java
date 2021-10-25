package com.axelor.timesheet.service;

import com.axelor.inject.Beans;
import com.axelor.project.db.Timesheet;
import com.axelor.project.db.TimesheetLines;
import com.axelor.project.db.repo.AbstractTimesheetRepository;
import com.google.inject.persist.Transactional;
import java.math.BigDecimal;

public class TimesheetServiceImpl implements TimesheetService {

  //	@Override
  //	public Timesheet computetotalHrs(Timesheet timesheet) {
  //		System.err.println("computetotalHrs.........");
  //		BigDecimal totalhrs = BigDecimal.ZERO;
  //		if (timesheet.getTimesheetLineList() != null) {
  //			for (TimesheetLines l : timesheet.getTimesheetLineList()) {
  //				totalhrs = totalhrs.add(l.getHours());
  //			}
  //		}
  //		timesheet.setTotalHrs(totalhrs);
  //		return timesheet;
  //	}

  @Override
  public Timesheet fromDate(Timesheet timesheet) {
    System.err.println("updating date");
    // timesheet.setFromdate(java.time.LocalDate.now());
    return timesheet;
  }

  @Override
  @Transactional
  public void demo(Timesheet timesheet) {
    System.err.println("calling demo");
    BigDecimal totalhrs = BigDecimal.ZERO;
    if (timesheet.getTimesheetLineList() != null) {
      for (TimesheetLines l : timesheet.getTimesheetLineList()) {
        totalhrs = totalhrs.add(l.getHours());
      }
    }
    timesheet = Beans.get(AbstractTimesheetRepository.class).find(timesheet.getId());
    System.err.println(timesheet);
    timesheet.setTotalHrs(totalhrs);
    System.err.println(timesheet.getTotalHrs());
    Beans.get(AbstractTimesheetRepository.class).save(timesheet);
    Beans.get(AbstractTimesheetRepository.class).refresh(timesheet);
    System.err.println("called");
  }
}
