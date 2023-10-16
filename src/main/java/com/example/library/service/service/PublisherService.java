package com.example.library.service.service;

import com.example.library.model.publisher.PublisherReq;
import com.example.library.model.publisher.PublisherRes;

import java.util.List;
import java.util.UUID;

public interface PublisherService {

    PublisherRes createPublisher(PublisherReq publisherReq);

    List<PublisherRes> getAllPublishers();

    PublisherRes getPublisher(UUID publisherId);

    void deletePublisher(UUID publisherId);
}
