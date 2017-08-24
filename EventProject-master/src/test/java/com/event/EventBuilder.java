package com.event;
import com.event.bean.Event;
import com.event.bean.Agenda;
import java.util.List;
public class EventBuilder
{
    private Event event=new Event();
    public EventBuilder eId(long eId)
    {
   event.seteId(eId);
    return this;
    }
    public EventBuilder eFullDte(String eFullDte)
    {
    event.seteFullDte(eFullDte);
    return this;
    }
    public EventBuilder eDate(String eDate)
    {
    event.seteDate(eDate);
    return this;
    }
    public EventBuilder eEdition(int eEdition)
    {
    event.seteEdition(eEdition);
    return this;
    }
    public EventBuilder eMonth(String eMonth)
    {
   event.seteMonth(eMonth);
    return this;
    }
    public EventBuilder eLocation(String eLocation)
    {
    event.seteLocation(eLocation);
    return this;
    }
    public EventBuilder eIsActive(boolean eIsActive)
    {
   event.seteIsActive(eIsActive);
    return this;
    }
     
    private List<Agenda> agenda;
    public EventBuilder eAgenda(List<Agenda> agenda)
    {
   event. setAgenda(agenda);
    return this;
    }


public Event build() {
    return event;
  }


}




















