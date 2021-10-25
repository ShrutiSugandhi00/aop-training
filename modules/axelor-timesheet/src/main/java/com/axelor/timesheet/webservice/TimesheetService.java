package com.axelor.timesheet.webservice;

import com.axelor.project.db.Timesheet;
import com.axelor.project.db.repo.AbstractTimesheetRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/timesheet")
public class TimesheetService {

  @Inject AbstractTimesheetRepository timerepo;
  JsonNodeFactory jsonf = JsonNodeFactory.instance;

  @Path("/all")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public JsonNode getTimesheet() {
    ObjectNode mainnode = jsonf.objectNode();

    List<Timesheet> timesheetlist = timerepo.all().fetch();
    ArrayNode arraynode = jsonf.arrayNode();
    for (Timesheet t : timesheetlist) {
      ObjectNode timesheetnode = jsonf.objectNode();
      timesheetnode.put("company", t.getCompany());
      timesheetnode.putPOJO("field", t);
    }
    mainnode.put("status", 0);
    mainnode.set("data", arraynode);

    return mainnode;
  }
}
