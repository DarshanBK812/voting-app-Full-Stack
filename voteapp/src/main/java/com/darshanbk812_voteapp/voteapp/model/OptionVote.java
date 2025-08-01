package com.darshanbk812_voteapp.voteapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class OptionVote {

    @Column(name = "optionText")
    private String optionText;
    private Long voteCount = 0L;

}
