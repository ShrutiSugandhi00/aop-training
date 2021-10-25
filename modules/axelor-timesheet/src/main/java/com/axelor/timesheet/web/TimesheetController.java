package com.axelor.timesheet.web;

import com.axelor.inject.Beans;
import com.axelor.meta.schema.actions.ActionView;
import com.axelor.meta.schema.actions.ActionView.ActionViewBuilder;
import com.axelor.project.db.Timesheet;
import com.axelor.project.db.repo.AbstractTimesheetRepository;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.timesheet.service.TimesheetService;
import com.google.inject.Inject;

public class TimesheetController {
  @Inject TimesheetService timesheetService;

  //	public void test(ActionRequest request, ActionResponse response) {
  //		Timesheet ts = request.getContext().asType(Timesheet.class);
  //		// Context parent= request.getContext().getParent();
  //		// System.err.println("parent:"+ parent);
  //		System.err.println(ts);
  //		// ts = Beans.get(TimesheetService.class).computetotalHrs(ts);
  //		ts = timesheetService.computetotalHrs(ts);
  //		response.setValue("totalHrs", ts.getTotalHrs());
  //		// Timesheet find = Beans.get(TimesheetRepository.class).find(ts.getId());
  //		// System.err.println(find);
  //		// response.setAlert("Hello test onClick");
  //		response.setAttr("hrs", "title", "Hours");
  //		response.setReadonly("company", true);
  //		// response.se
  //		// response.setReload(true);
  //
  //		// response.setError("Error : fdfdfdf");
  //		// response.setFlash("this is a time sheet");
  //		// response.setNotify("enter working hours..");
  //	}

  // to fetch record from db

  public void fromDate(ActionRequest request, ActionResponse response) {

    // System.err.println("first....." );

    Timesheet timeSheetFromDb =
        Beans.get(AbstractTimesheetRepository.class).all().order("-todate").fetchOne();
    // System.err.println("second..");
    response.setValue("fromdate", timeSheetFromDb.getTodate());
  }
  // or
  // public void date(ActionRequest request, ActionResponse response) {
  // Timesheet timesheet = request.getContext().asType(Timesheet.class);
  // System.err.println(timesheet);
  // timesheet = timesheetService.fromDate(timesheet);
  // response.setValue("fromdate", timesheet.getFromdate());
  // }

  public void add(ActionRequest request, ActionResponse response) {
    Timesheet tm = request.getContext().asType(Timesheet.class);
    tm = Beans.get(AbstractTimesheetRepository.class).find(tm.getId());
    // ActionViewBuilder avb =
    // ActionView.define("Timesheet").model(Timesheet.class.getName()).add("grid",
    // "timesheet-grid");
    ActionViewBuilder avb =
        ActionView.define("Timesheet")
            .model(Timesheet.class.getName())
            .add("form", "timesheet-form");
    response.setView(avb.map());
  }

  public void sample(ActionRequest request, ActionResponse response) {

    System.err.println("calling controller");
  }
}
