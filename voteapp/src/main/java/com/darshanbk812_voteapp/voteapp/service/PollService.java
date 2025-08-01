package com.darshanbk812_voteapp.voteapp.service;

import com.darshanbk812_voteapp.voteapp.model.OptionVote;
import com.darshanbk812_voteapp.voteapp.model.Poll;
import com.darshanbk812_voteapp.voteapp.repository.PollRepository;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    @Autowired
   private PollRepository pollRepository;

    public Poll creatPoll(Poll poll) {

        return pollRepository.save(poll);

    }

    public List<Poll> getAllPoll() {
        return  pollRepository.findAll();
    }

    public Optional<Poll> getPoll(Integer pollId) {
            return pollRepository.findById(pollId);
    }

    public void vote(Integer pollId, int optionIndex) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() ->  new RuntimeException("Poll is not found"));

        List<OptionVote> optionVotes = poll.getOptions();

        if(optionIndex < 0 || optionIndex >= optionVotes.size()){
            throw new IllegalIdentifierException("Ivalid option Index");
        }

        OptionVote selectedOption = optionVotes.get(optionIndex);

        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);

        pollRepository.save(poll);
    }
}
