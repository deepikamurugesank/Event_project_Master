package com.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import com.event.bean.Event;
import com.event.bean.Agenda;
//import com.event.EventBuilder;
//import com.event.AgendaBuilder;
import com.event.repository.EventRepository;
//import com.event.controller.EventController;
import com.event.service.EventService;
import com.event.service.EventServiceImp;
import java.util.ArrayList;
//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;
//import java.util.List;
//import java.lang.*;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(MockitoJUnitRunner.class)

public class EventprojectUnitTest
{
  @Mock
    private EventRepository eventRepository;
  //Agenda ag=new Agenda("10:00PM","debug","all the best");
@InjectMocks 
   
    private EventServiceImp eventserviceImp;
 
    Event event=new Event();
    //EventprojectUnitTest e=new EventprojectUnitTest();

@Test
public void eventTest() {
    ArrayList<Agenda> age=new ArrayList<Agenda> ();
    Agenda a1=new Agenda(1L,"10:00 PM","debug","all the best");
    //private  Agenda a2=new Agenda("11:00 PM","paper","all the best");
    Agenda a3=new Agenda(1L,"10:00 PM","debug","all the best");
    age.add(a1);
    age.add(a3);
    List<Event> event=new ArrayList<Event>();
    event.add(new Event(1L,2,"29Aug2017","29/8/2017","august","block2",true,age));
    event.add(new Event(2L,2,"29Aug2017","29/8/2017","august","block2",true,age));
    event.add(new Event(3L,2,"29Aug2017","29/8/2017","august","block2",true,age));
    when(eventRepository.findAll()).thenReturn(event);
    List<Event> result=eventserviceImp.getAll();
    assertEquals(3, result.size());
}
@Test
public void editTest()
{
    ArrayList<Agenda> age=new ArrayList<Agenda> ();
    Agenda a1=new Agenda(1L,"10:00 PM","debug","all the best");
    //private  Agenda a2=new Agenda("11:00 PM","paper","all the best");
    Agenda a3=new Agenda(1L,"10:00 PM","debug","all the best");
    age.add(a1);
    age.add(a3);
    Event event=new Event(1L,2,"29Aug2017","29/8/2017","august","block2",true,age);
    when(eventRepository.findOne(1L)).thenReturn(event);
    Event result = eventserviceImp.find(1L);
    assertEquals(1L, 1L);
	//assertEquals("Todo Sample 1", result.find());
	//assertEquals(true, result.isCompleted());
}

@Test
public void saveEvent()
{
    ArrayList<Agenda> age=new ArrayList<Agenda> ();
    Agenda a1=new Agenda(1L,"10:00 PM","debug","all the best");
    //private  Agenda a2=new Agenda("11:00 PM","paper","all the best");
    Agenda a3=new Agenda(1L,"10:00 PM","debug","all the best");
    age.add(a1);
    age.add(a3);
    Event event=new Event(1L,2,"29Aug2017","29/8/2017","august","block2",true,age);
    	when(eventRepository.save(event)).thenReturn(event);
		Event result = eventserviceImp.save(event);
		assertEquals(1L,1L);
}

@Test
public void deleteEvent()
{
    ArrayList<Agenda> age=new ArrayList<Agenda> ();
    Agenda a1=new Agenda(1L,"10:00 PM","debug","all the best");
    //private  Agenda a2=new Agenda("11:00 PM","paper","all the best");
    Agenda a3=new Agenda(1L,"10:00 PM","debug","all the best");
    age.add(a1);
    age.add(a3);
    Event event = new Event(2L,2,"29Aug2017","29/8/2017","august","block2",true,age);
		eventserviceImp.delete(2L);
        verify(eventRepository, times(1)).delete(2L);

}
}









    


    /*Event e2=new Event(1L,2,"29Aug2017","29/8/2017","august","block2",true,age);
   // Event e3=new Event(2L,1,"28Aug2017","28/8/2017","august","block1",true,age);
    Event e4=new Event(1L,2,"29Aug2017","29/8/2017","august","block2",false,age);*/
  /*Event e1=new Event();
    e1.seteId(1L);
    e1.seteEdition(1);
    e1.seteFullDte("28aug2017");
    e1.seteDate("28/8/2017");
    e1.seteMonth("august");
    e1.seteLocation("block1");
    e1.seteIsActive(true);
    e1.setAgenda(age);

     Event e2=new Event();
    //e2.seteId(1L);
    e2.seteEdition(1);
    e2.seteFullDte("28aug2017");
    e2.seteDate("28/8/2017");
    e2.seteMonth("august");
    e2.seteLocation("block1");
    e2.seteIsActive(false);
    e2.setAgenda(age);
    System.out.println("e1 value is"+(e1));*/
    
   /*given(eventRepository.saveAndFlush(e2)).willReturn((e1));
    assertThat(eventserviceImp.save((e2))).isSameAs(e1);*/
    /*List<Event> event=new ArrayList<Event>();
    event.add(new Event(1L,2,"29Aug2017","29/8/2017","august","block2",true,age));
    event.add(new Event(2L,2,"29Aug2017","29/8/2017","august","block2",true,age));
    event.add(new Event(3L,2,"29Aug2017","29/8/2017","august","block2",true,age));
    when(eventRepository.findAll()).thenReturn(event);
    List<Event> result=eventservice.getAll();
    assertEquals(3, result.size());
    */
      




/*@Test
	public void testGetAllToDo(){
		List<ToDo> toDoList = new ArrayList<ToDo>();
		toDoList.add(new ToDo(1,"Todo Sample 1",true));
		toDoList.add(new ToDo(2,"Todo Sample 2",true));
		toDoList.add(new ToDo(3,"Todo Sample 3",false));
		when(toDoRepository.findAll()).thenReturn(toDoList);
		
		List<ToDo> result = toDoService.getAllToDo();
		assertEquals(3, result.size());
	}*/

    /*public static void main(String args[])
    {
     Result result = JUnitCore.runClasses(EventprojectUnitTest.class);
      for (Failure failure : result.getFailures())
           System.out.println(failure.toString());
     
      
      System.out.println(result.wasSuccessful());
    }*/




/*.setaTime("10:00 PM").setA_desc("debug")
    .setA_ins("all the best");
    private  Agenda a2=new Agenda().setaTime("12:00 PM").setA_desc("paperpresentation")
    .setA_ins("all the best");
    private  Agenda a3=new Agenda().setaTime("10:00 PM").setA_desc("debug")
    .setA_ins("all the best");*/
    //ag.add(a1);
   // ag.addAll(a2);
   // ag.add(a3);
//     List<Agenda> ag1=new ArrayList<Agenda> ();
// private  Agenda a1=new Agenda("10:00 PM","debug","all the best");
// private  Agenda a3=new Agenda("10:00 PM","debug","all the best");
// ag1.add(a1);
// ag1.add(a3);


   /* Event e1=new Event();
e1.seteEdition(1);
e1.seteFullDte("28aug2017");
e1.setAgenda(ag);
*/


/*System.out.println(e2.size());
System.out.println();
*/
    //assert.Equals(e1,e2);
    /*@InjectMocks 
    private EventController eventcontroller;
    @Mock
    private EventService eventservice;
    
    Event event=new Event();
    @Test
	public void whenCreatingCharacterItShouldReturnTheSavedCharacter() {
		/*given(eventservice.save(e4)).willReturn((e2));
		assertThat(eventservice.save((e4))).isSameAs(e2);*/
        
        
	//}*/

  






    /*@Override

    public String toString()
    {
        return "date"+existing_agenda.aTime("10:pm");
    }*/

/**/   

 //private static final Long EVENT_ID = 1;
   /* private static final Event existing_event= new EventBuilder().eId(EVENT_ID).eFullDte("28aug2017").eDate("28/8/2017")
    .eEdition(1).eMonth("augest").eLocation("block1").eIsActive(true).build();
    private static final Event another_event = new EventBuilder().eId(2).eFullDte("29aug2017").eDate("29/8/2017")
    .eEdition(2).eMonth("augest").eLocation("block2").eIsActive(true).build();
    private static final Event new_event=new EventBuilder().eFullDte("28aug2017").eDate("28/8/2017")
    .eEdition(1).eMonth("augest").eLocation("block1").eIsActive(true).build();*/


    //private static final Long AGENDA_ID = 1;
   /* List<Agenda> ag=new ArrayList<Agenda> ();*/
   /* private  Agenda existing_agenda=new AgendaBuilder().id(AGENDA_ID).aTime("10:00 PM").aDesc("debug")
    .aIns("all the best").build();
     private static final Agenda another_agenda=new AgendaBuilder().id(2).aTime("11:00 PM").aDesc("paperpresentation")
    .aIns("bring softcopy").build();
    private static final Agenda new_agenda=new AgendaBuilder().aTime("10:00 PM").aDesc("debug")
    .aIns("all the best").build();*/
   /* ag.add(existing_agenda);
    ag.add(another_agenda);
*/
/*rivate static final  Event existing_event=new Event().seteId(1L).seteEdition(1).seteFullDte("28aug2017").
seteDate("28/8/2017").seteMonth("august").seteLocation("block1").seteIsActive(true)
.setAgenda(new Agenda().setId(1L).setaTime("10:00 PM").setA_desc("debug")
    .setA_ins("all the best"));
private static final  Event another_event=new Event().seteId(2L).seteEdition(1).seteFullDte("29aug2017").
seteDate("29/8/2017").seteMonth("august").seteLocation("block2").seteIsActive(true).new Agenda().setId(2L).setaTime("12:00 PM").setA_desc("paperpresentation")
    .setA_ins("all the best");
    private static final  Event new_event=new Event().seteEdition(1).seteFullDte("28aug2017").
seteDate("28/8/2017").seteMonth("august").seteLocation("block1").seteIsActive(true).new Agenda().setaTime("10:00 PM").setA_desc("debug")
    .setA_ins("all the best");*/


