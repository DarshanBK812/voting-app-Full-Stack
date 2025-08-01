package com.darshanbk812_voteapp.voteapp.repository;

import com.darshanbk812_voteapp.voteapp.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Integer> {
}
