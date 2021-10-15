package com.axelor.project.db.repo;

import com.axelor.project.db.Timesheet;
import java.util.Map;

public class TimesheetRepository extends AbstractTimesheetRepository {
  @Override
  public Map<String, Object> populate(Map<String, Object> json, Map<String, Object> context) {
    if (!context.containsKey("json-enhance")) {
      return json;
    }
    try {
      Long id = (Long) json.get("id");
      Timesheet timesheet = find(id);
      json.put("activityList", timesheet.getActivityList().get(0));

    } catch (Exception e) {
    }

    return json;
  }
}
