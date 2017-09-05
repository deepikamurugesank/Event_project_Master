package com.event;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.when;
import com.jayway.restassured.http.ContentType;
import com.event.bean.Agenda;
import com.event.bean.Event;
import com.event.repository.EventRepository;
import com.event.service.EventServiceImp;
import java.util.List;
import java.util.ArrayList;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = EventApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application.properties")

  public class EventcontrollerIT {
      private static final String NAME_FIELD = " eFullDte";
	private static final String EVENTS_RESOURCE = "/api/events";
	private static final String EVENT_RESOURCE = "/api/events/{id}";
    private static final String fulldate="13/10/2017";
	 private static final String EDATE =  "eDate";
	  private static final String DA =  "14/10/2017";

static final Agenda a1=new AgendaBuilder().id(1L).aTime("10M").aDesc("debug").aIns("all the best").build();
static final List<Agenda> agenda1=new ArrayList<Agenda>() {{
add(a1);
}};
private static final Long EVENT_ID = 1L;
private static final Event FIRST_EVENT = new EventBuilder().eId(EVENT_ID).eEdition(1).eFullDte("13/10/2017").eDate("23/09/2017").eMonth("09").eLocation("CBE").eIsActive(true).eAgenda(agenda1).build();
//private static final Event EXISTING_EVENT = new EventBuilder().seteId(EVENT_ID).seteEdition(1).seteFullDte("13/10/2017").seteDate("23/09/2017").seteMonth("09").seteLocation("CBE").seteIsActive(true).setAgenda(agenda1).build();
//private static final Event SECOND_EVENT = new EventBuilder().eId(2L).eEdition(2).eFullDte("").eDate().eMonth().eLocation().eIsActive().eAgenda().build();
private static final Event SECOND_EVENT = new EventBuilder().eId(2L).eEdition(2).eFullDte("13/10/2017").eDate("14/10/2017").eMonth("08").eLocation("SALEM").eIsActive(true).eAgenda(agenda1).build();
private static final Event THIRD_EVENT = new EventBuilder().eId(3L).eEdition(1).eFullDte("13/10/2017").eDate("15/10/2017").eMonth("09").eLocation("CBE").eIsActive(true).eAgenda(agenda1).build();

  @Autowired
	private EventRepository eventrepository;

	@Value("${local.server.port}")
	private int serverPort;
	private Event firstevent;
	private Event secondevent;

	@Before
	public void setUp() {
		eventrepository.deleteAll();
		firstevent = eventrepository.save(FIRST_EVENT);
		secondevent = eventrepository.save(SECOND_EVENT);
		RestAssured.port = serverPort;
	}
    @Test
	public void addItemShouldReturnSavedItem() {
		given().body( THIRD_EVENT).contentType(ContentType.JSON).when().post(EVENTS_RESOURCE).then()
				.statusCode(HttpStatus.SC_OK).body(NAME_FIELD, is(fulldate));
		System.out.println("addItemShouldReturnSavedItem completed !!!");
	}


	@Test
	public void findoneItemShouldReturnfindoneItem() {
		// Given an unchecked first item
		/*Event item = new EventBuilder().eId(3L).eEdition(1)
        .eFullDte("13/10/2017").eDate("13/10/2017").eMonth("09").eLocation("CBE").eIsActive(true).eAgenda(agenda1).build();*/
		given().body(firstevent).contentType(ContentType.JSON).when().get(EVENT_RESOURCE, firstevent.geteId()).then()
				.statusCode(HttpStatus.SC_OK).body(NAME_FIELD, is(fulldate));
                
	}
   
    /*public void findallitem()
        {
			 given().body(THIRD_EVENT).contentType(ContentType.JSON).when().get(EVENTS_RESOURCE).then()
			 .statusCode(HttpStatus.SC_OK).body(NAME_FIELD, is(fulldate));
			 System.out.println("dateeeeeeeeee"+secondevent.geteId());


        }
    */


	@Test
	public void getItemsShouldReturnBothItems() {
		when().get(EVENTS_RESOURCE).then().statusCode(HttpStatus.SC_OK).body(NAME_FIELD,
				hasItems(fulldate, fulldate));
	}

	@Test
	public void deleteItemShouldReturnNoContent() {
		when().delete(EVENT_RESOURCE, secondevent.geteId()).then().statusCode(HttpStatus.SC_OK);
	}
    }
  