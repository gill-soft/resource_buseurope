package com.gillsoft.model;

import java.io.Serializable;
import java.util.Calendar;

public class FromToDates implements Serializable {

  private static final long serialVersionUID = 7824951406987033845L;

  private String days;
  private Calendar from;
  private Calendar to;

  public String getDays() {
    return days;
  }

  public void setDays(String days) {
    this.days = days;
  }

  public Calendar getFrom() {
    return from;
  }

  public void setFrom(Calendar from) {
    this.from = from;
  }

  public Calendar getTo() {
    return to;
  }

  public void setTo(Calendar to) {
    this.to = to;
  }

  public void union(FromToDates fromToDates) {
    if (fromToDates.getFrom().before(from)) {
      from = fromToDates.getFrom();
    }
    if (fromToDates.getTo().after(to)) {
      to = fromToDates.getTo();
    }
    compareDays(fromToDates.getDays());
  }

  private void compareDays(String days) {
    for (int i = 0; i < days.length(); i++) {
      String day = String.valueOf(days.charAt(i));
      if (!this.days.contains(day)) {
        this.days = this.days + day;
      }
    }
  }

}
