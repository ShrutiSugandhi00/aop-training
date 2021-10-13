package com.axelor.timesheet.web;

import com.axelor.project.db.Timesheet;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.timesheet.service.TimesheetService;
import com.google.inject.Inject;

public class TimesheetController {
  @Inject TimesheetService timesheetService;

  public void test(ActionRequest request, ActionResponse response) {
    Timesheet ts = request.getContext().asType(Timesheet.class);
    // Context parent= request.getContext().getParent();
    // System.err.println("parent:"+ parent);
    System.err.println(ts);
    // ts = Beans.get(TimesheetService.class).computetotalHrs(ts);
    ts = timesheetService.computetotalHrs(ts);
    response.setValue("getTotalHrs", ts.getTotalHrs());
    // Timesheet find = Beans.get(TimesheetRepository.class).find(ts.getId());
    // System.err.println(find);
    // response.setAlert("Hello test onClick");
    response.setAttr("hrs", "title", "Hours");
    response.setReadonly("company", true);
    // response.se
    // response.setReload(true);

    // response.setError("Error : fdfdfdf");
    // response.setFlash("this is a time sheet");
    // response.setNotify("enter working hours..");
  }

  // to fetch record from db
  // Timesheet timeSheetFromDb =
  // Beans.get(TimesheetRepository.class).all().filter("self.id =
  // ?",ts.getId()).fetchOne();
  // or
  public void date(ActionRequest request, ActionResponse response) {
    Timesheet timesheet = request.getContext().asType(Timesheet.class);
    System.err.println(timesheet);
    timesheet = timesheetService.fromDate(timesheet);
    response.setValue("fromdate", timesheet.getFromdate());
  }
}
