package org.mathsena.eventsapi.services;

import org.mathsena.eventsapi.dto.EventRequestDTO;
import org.mathsena.eventsapi.models.Event;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EventService {

  public Event createEvent(EventRequestDTO event) {

    String imgUrl = null;

    if (event.imgUrl() != null) {
      imgUrl = this.uploadImageUrl(event.imgUrl());
    }

    Event newEvent = new Event();
    newEvent.setName(event.title());
    newEvent.setDescription(event.description());
    newEvent.setImgUrl(imgUrl);
    newEvent.setIsRemote(event.isRemote());
    newEvent.setLocation(event.location());
    newEvent.setDate(event.date());

    return newEvent;
  }

  private String uploadImageUrl(MultipartFile imageUrl) {
    return "";
  }
}
