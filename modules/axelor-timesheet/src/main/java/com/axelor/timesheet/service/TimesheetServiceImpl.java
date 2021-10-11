package com.axelor.timesheet.service;

import com.axelor.project.db.Timesheet;
import com.axelor.project.db.TimesheetLines;

public class TimesheetServiceImpl implements TimesheetService {

	@Override
	public Timesheet computetotalHrs(Timesheet timesheet) {
		System.err.println("computetotalHrs.........");
		Integer totalhrs = 0;
		if (timesheet.getTimesheetLineList() != null) {
			for (TimesheetLines l : timesheet.getTimesheetLineList()) {
				totalhrs = totalhrs + l.getHours();
			}
		}
		timesheet.setGetTotalHrs(totalhrs);
		return timesheet;
	}
}
