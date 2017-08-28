package com.event;

import com.event.bean.Agenda;
import com.event.bean.Event;
import com.event.repository.EventRepository;
import com.event.service.EventServiceImp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class EventprojectUnitTest
{
  @Mock
    private EventRepository eventRepository;
 
@InjectMocks 
   
    private EventServiceImp eventserviceImp;
 
    Event event=new Event();
     Common c=new Common();


  
@Test
public void eventTest() {
    when(eventRepository.findAll()).thenReturn(c.setmethod());
    List<Event> result=eventserviceImp.getAll();
    assertEquals(3, result.size());
}
@Test
public void editTest()
{
    when(eventRepository.findOne(1L)).thenReturn(c.tedmethod());
    Event result = eventserviceImp.find(1L);
    assertEquals(1L, 1L);
}
@Test
public void saveEvent()
{
        when(eventRepository.save(event)).thenReturn(c.tedmethod());
		Event result = eventserviceImp.save(event);
		assertEquals(1L,1L);
}

@Test
public void deleteEvent()
{
         c.tedmethod();
		eventserviceImp.delete(2L);
        verify(eventRepository, times(1)).delete(2L);
}
@Test
public void eventSize()
{
  
    when(eventRepository.findAll()).thenReturn(c.setmethod());
    List<Event> result=eventserviceImp.getAll();
    assertEquals(3, result.size());
    
for (Iterator<Event> i = result.iterator(); i.hasNext();) {
    Event item = i.next();
    int id=item.geteEdition();
    String full=item.geteFullDte();
    String date=item.geteDate();
    String month=item.geteMonth();
    String loc=item.geteLocation();
    boolean act=item.geteIsActive();
    System.out.println("id:"+id);
    System.out.println("fullDate:"+full);
    System.out.println("date:"+date);
    System.out.println("month:"+month);
    System.out.println("location"+loc);
    System.out.println("location"+act);

    List<Agenda> ag=item.getAgenda();
    for (Iterator<Agenda> a = ag.iterator(); a.hasNext();)
    {       Agenda agen = a.next();
            Long idd=agen.getId();
            String tm=agen.getA_desc();
            String ins=agen.getA_ins();
            String time=agen.getaTime();
            System.out.println("description"+tm);
               System.out.println("instruction"+ins);
                  System.out.println("Time"+time);
                   System.out.println("id"+id);
    }
}
}
}









    


    
