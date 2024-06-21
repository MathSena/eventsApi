package org.mathsena.eventsapi.services;

import com.amazonaws.services.s3.AmazonS3;
import lombok.extern.slf4j.Slf4j;
import org.mathsena.eventsapi.dto.EventRequestDTO;
import org.mathsena.eventsapi.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class EventService {

  @Value("${aws.bucket}")
  private String bucketName;

  @Autowired private AmazonS3 s3Client;

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

  private String uploadImageUrl(MultipartFile multipartFile) {
    String imgName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

    try {
      File file = this.convertMultipartFile(multipartFile);
      s3Client.putObject(bucketName, imgName, file);
      file.delete();
      return s3Client.getUrl(bucketName, imgName).toString();
    } catch (Exception e) {
      log.error("Error uploading image to S3: {}", e.getMessage());
      return null;
    }
  }

  private File convertMultipartFile(MultipartFile multipartFile) throws IOException {
    File convertFile = new File(multipartFile.getOriginalFilename());
    FileOutputStream out = new FileOutputStream(convertFile);
    out.write(multipartFile.getBytes());
    out.close();
    return convertFile;
  }
}
