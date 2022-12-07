package examples.typeinfo;//: typeinfo/Position.java

import examples.initialization.Person;

class Position {
  private String title;
  private examples.initialization.Person person;
  public Position(String jobTitle, examples.initialization.Person employee) {
    title = jobTitle;
    person = employee;
    if(person == null)
      person = examples.initialization.Person.NULL;
  }
  public Position(String jobTitle) {
    title = jobTitle;
    person = examples.initialization.Person.NULL;
  }	
  public String getTitle() { return title; }
  public void setTitle(String newTitle) {
    title = newTitle;
  }
  public examples.initialization.Person getPerson() { return person; }
  public void setPerson(examples.initialization.Person newPerson) {
    person = newPerson;
    if(person == null)
      person = examples.initialization.Person.NULL;
  }
  public String toString() {
    return "Position: " + title + " " + person;
  }
} ///:~
