package com.axelor.timesheet.web;

import com.axelor.project.db.Timesheet;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.timesheet.service.TimesheetService;
import com.google.inject.Inject;

public class TimesheetController {
	@Inject
	TimesheetService timesheetService;

	public void test(ActionRequest request, ActionResponse response) {
		Timesheet ts = request.getContext().asType(Timesheet.class);
		// ts = Beans.get(TimesheetService.class).computetotalHrs(ts);
		ts = timesheetService.computetotalHrs(ts);
		System.err.println("printing");

		response.setValue("getTotalHrs", ts.getGetTotalHrs());
		// response.setAlert("Hello test onClick");
		// response.setError("Error : fdfdfdf");
	}

	// to fetch record from db
	// Timesheet timeSheetFromDb =
	// Beans.get(TimesheetRepository.class).all().filter("self.id =
	// ?",ts.getId()).fetchOne();
	// or
	// Timesheet find = Beans.get(TimesheetRepository.class).find(ts.getId());

}
