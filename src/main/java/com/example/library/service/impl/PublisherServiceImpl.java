package com.example.library.service.impl;

import com.example.library.converter.publisher.PublisherToRes;
import com.example.library.converter.publisher.ReqToPublisher;
import com.example.library.model.publisher.Publisher;
import com.example.library.model.publisher.PublisherReq;
import com.example.library.model.publisher.PublisherRes;
import com.example.library.repository.PublisherRepository;
import com.example.library.service.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository publisherRepository;
    private PublisherToRes publisherToRes;
    private ReqToPublisher reqToPublisher;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository, PublisherToRes publisherToRes, ReqToPublisher reqToPublisher) {
        this.publisherRepository = publisherRepository;
        this.publisherToRes = publisherToRes;
        this.reqToPublisher = reqToPublisher;
    }

    @Override
    public PublisherRes createPublisher(PublisherReq publisherReq) {
        Publisher publisher = reqToPublisher.convert(publisherReq);
        publisherRepository.save(publisher);

        return publisherToRes.convert(publisher);
    }

    @Override
    public List<PublisherRes> getAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();

        List<PublisherRes> resList = new ArrayList<>();

        for (int i = 0; i < publishers.size(); i++) {
            resList.add(publisherToRes.convert(publishers.get(i)));
        }

        return resList;
    }

    @Override
    public PublisherRes getPublisher(UUID publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId).get();

        return publisherToRes.convert(publisher);
    }

    @Override
    public void deletePublisher(UUID publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId).get();

        publisherRepository.delete(publisher);
    }
}
