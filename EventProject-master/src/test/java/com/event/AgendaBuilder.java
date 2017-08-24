package com.event;
import com.event.bean.Agenda;

public class AgendaBuilder {
  private Agenda agenda = new Agenda();
  
  public AgendaBuilder id(long id) {
	  agenda.setId(id);
    return this;
  }
  
  public AgendaBuilder aTime(String a_time) {
	  agenda.setaTime(a_time);
    return this;
  }
  public AgendaBuilder aDesc(String a_desc) {
	  agenda.setA_desc(a_desc);
    return this;
  }
  public AgendaBuilder aIns(String a_ins) {
	  agenda.setA_ins(a_ins);
    return this;
  }
  
  public Agenda build() {
    return agenda;
  }
}