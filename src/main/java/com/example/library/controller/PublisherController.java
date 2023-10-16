package com.example.library.controller;

import com.example.library.model.publisher.PublisherReq;
import com.example.library.model.publisher.PublisherRes;
import com.example.library.service.service.PublisherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(tags = "publishers")
@RequestMapping("/publishers")
public class PublisherController {

    private PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    @ApiOperation(value = "Get all Publishers" , notes = "Get List of publishers" , response = PublisherRes.class , responseContainer = "List")
    public List<PublisherRes> getAllPublishers(){
        return publisherService.getAllPublishers();
    }

    @GetMapping("/{publisherId}")
    @ApiOperation(value = "Get a publisher" , notes = "Get publisher by ID" , response = PublisherRes.class)
    public PublisherRes getPublisher(@PathVariable UUID publisherId){
        return publisherService.getPublisher(publisherId);
    }

    @PostMapping
    @ApiOperation(value = "Create Publisher" , notes = "Create Publisher" , response = PublisherRes.class)
    public PublisherRes createPublisher(@RequestBody PublisherReq publisherReq){
        return publisherService.createPublisher(publisherReq);
    }

    @DeleteMapping("/{publisherId}")
    @ApiOperation(value = "Delete publisher" , notes = "Delete publisher by ID")
    public void deletePublisher(@PathVariable UUID publisherId){
        publisherService.deletePublisher(publisherId);
    }
}
