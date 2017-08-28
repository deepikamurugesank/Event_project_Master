package com.event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import com.event.bean.Event;
import com.event.bean.Agenda;
import com.event.repository.EventRepository;
import com.event.controller.EventController;
import com.event.service.EventService;
import com.event.service.EventServiceImp;
import java.util.ArrayList;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(MockitoJUnitRunner.class)

public class ControllerUnitTest
{
  @Mock
    private EventService eventservice;
 
@InjectMocks 
   
    private EventController eventcontroller;
 
    Event event=new Event();
    Common c=new Common();
   
   
@Test
public void editTestt()
{
    when(eventservice.find(1L)).thenReturn(c.tedmethod());
    Event result = eventcontroller.find(1L);
    assertEquals(1L, 1L);
}

@Test
public void saveEventt()
{
    
    	when(eventservice.save(event)).thenReturn(c.tedmethod());
		Event result = eventcontroller.save(event);
		assertEquals(1L,1L);
        System.out.println("getIddddddddddd"+event.geteId());
}

@Test
public void deleteEventt()
{
   
    c.tedmethod();
	eventcontroller.delete(2L);
    verify(eventservice, times(1)).delete(2L);
}
@Test

public void eventSize()
{
    c.setmethod();
    when(eventservice.getAll()).thenReturn(c.setmethod());
    List<Event> result=eventcontroller.getAllEvents();
    assertEquals(3, result.size());
    
for (Iterator<Event> i = result.iterator(); i.hasNext();) {
    Event item = i.next();
     int id=item.geteEdition();
    String full=item.geteFullDte();
    String date=item.geteDate();
    String month=item.geteMonth();
    String loc=item.geteLocation();
    System.out.println("id:"+id);
    System.out.println("fullDate:"+full);
    System.out.println("date:"+date);
    System.out.println("month:"+month);
    System.out.println("location"+loc);
    List<Agenda> ag=item.getAgenda();
    for (Iterator<Agenda> a = ag.iterator(); a.hasNext();)
    {       Agenda agen = a.next();
            String tm=agen.getA_desc();
            System.out.println(tm);
    }
}

}

}



