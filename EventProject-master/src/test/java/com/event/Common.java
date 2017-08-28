package com.event;

import com.event.bean.Agenda;
import com.event.bean.Event;
import com.event.EventBuilder;
import com.event.AgendaBuilder;
import java.util.ArrayList;
import java.util.List;

public class Common

{
   
public Event tedmethod()
{
   
     Agenda a1=new AgendaBuilder().id(1L).aTime("10:PM").aDesc("debug").aIns("all the best").build();
      Agenda a2=new AgendaBuilder().id(2L).aTime("11:PM").aDesc("paperpresenation").aIns("all the best").build();
   
     ArrayList<Agenda> age1=new ArrayList<Agenda> ();
     age1.add(a1);
     age1.add(a2);
    
     Event e1=new EventBuilder().eId(1L).eFullDte("28aug2017").eDate("28/8/2017").eEdition(1).eMonth("aug").eLocation("block1")
     .eIsActive(true). eAgenda(age1).build();
    return e1;
}
public List<Event> setmethod()
{
     Agenda a1=new AgendaBuilder().id(1L).aTime("10:PM").aDesc("debug").aIns("all the best").build();
      Agenda a2=new AgendaBuilder().id(2L).aTime("11:PM").aDesc("paperpresenation").aIns("all the best").build();
   
     ArrayList<Agenda> age1=new ArrayList<Agenda> ();
     age1.add(a1);
     age1.add(a2);
    
     Event e1=new EventBuilder().eId(1L).eFullDte("28aug2017").eDate("28/8/2017").eEdition(1).eMonth("aug").eLocation("block1")
     .eIsActive(true). eAgenda(age1).build();
     Event e2=new EventBuilder().eId(2L).eFullDte("29aug2017").eDate("29/8/2017").eEdition(2).eMonth("aug").eLocation("block3")
     .eIsActive(true). eAgenda(age1).build();
     Event e3=new EventBuilder().eId(3L).eFullDte("30aug2017").eDate("30/8/2017").eEdition(3).eMonth("aug").eLocation("block2")
     .eIsActive(true). eAgenda(age1).build();
   
    List<Event> eventlist=new ArrayList<Event>();
    eventlist.add(e1);
    eventlist.add(e2);
    eventlist.add(e3);
    return eventlist;
}

}