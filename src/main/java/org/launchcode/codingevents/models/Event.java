package org.launchcode.codingevents.models;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message = "Event location is required.")
    @NotNull(message= "")
    private String eventLocation;


    @Min(value = 1, message = "Must be more than 0 attendees.")
    @NotNull(message = "Must have attendees at event.")
            private Integer numAttendees;

@AssertTrue(message="Registration to the event must be required.")
    private Boolean eventRegistration;

    public Event(String name, String description, String contactEmail, String eventLocation, Integer numAttendees, Boolean eventRegistration) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.eventLocation = eventLocation;
        this.eventRegistration = eventRegistration;
        this.numAttendees = numAttendees;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Integer getNumAttendees() {
        return numAttendees;
    }

    public void setNumAttendees(Integer numAttendees) {
        this.numAttendees = numAttendees;
    }

    public Boolean getEventRegistration() {
        return eventRegistration;
    }

    public void setEventRegistration(Boolean eventRegistration) {
        this.eventRegistration = eventRegistration;
    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
