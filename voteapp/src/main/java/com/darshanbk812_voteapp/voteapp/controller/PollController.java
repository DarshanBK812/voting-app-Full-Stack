package com.darshanbk812_voteapp.voteapp.controller;

import com.darshanbk812_voteapp.voteapp.dto.Vote;
import com.darshanbk812_voteapp.voteapp.model.Poll;
import com.darshanbk812_voteapp.voteapp.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@CrossOrigin(origins = "http://localhost:4200/")
public class PollController {

    @Autowired
    private PollService pollService;

    private Vote vote;

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        return pollService.creatPoll(poll);
    }

    @GetMapping
    public List<Poll> getAllPoll(){
        return pollService.getAllPoll();
    }

    @GetMapping("/{pollId}")
    public ResponseEntity<Poll> getPoll(@PathVariable Integer pollId){
        return pollService.getPoll(pollId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/vote")
    public void vote(@RequestBody  Vote vote){
        pollService.vote(vote.getPollId(), vote.getOptionIndex());
    }




}
