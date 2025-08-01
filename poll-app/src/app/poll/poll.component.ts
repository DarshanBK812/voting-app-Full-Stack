import { Component, OnInit } from '@angular/core';
import { PollService } from '../poll.service';
import { Poll } from '../poll.models';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-poll',
  imports: [CommonModule, FormsModule],
  templateUrl: './poll.component.html',
  styleUrls: ['./poll.component.css'],
})
export class PollComponent implements OnInit {
  constructor(private pollService: PollService) {}
  ngOnInit(): void {
    this.loadPolls();
  }
  polls: Poll[] = [];

  newPoll: Poll = {
    id: 0,
    question: '',
    options: [
      { optionText: '', voteCount: 0 },
      { optionText: '', voteCount: 0 },
      { optionText: '', voteCount: 0 },
      { optionText: '', voteCount: 0 },
    ],
  };

  loadPolls() {
    // Logic to load polls will go here
    this.pollService.getPolls().subscribe({
      next: (data) => {
        this.polls = data;
      },
      error: (err) => {
        console.error('Error loading polls', err);
      },
    });
  }

  addOption() {
    this.newPoll.options.push({ optionText: '', voteCount: 0 });
  }

  showSuccess: boolean = false;

  createPoll() {
    this.pollService.createPoll(this.newPoll).subscribe({
      next: (data) => {
        this.polls.push(data);
        this.resetPoll();

        // 🎉 Show success toast
        this.showSuccess = true;
        setTimeout(() => {
          this.showSuccess = false;
        }, 3000);
      },
      error: (err) => {
        console.error('Error creating poll', err);
      },
    });
  }

  resetPoll() {
    this.newPoll = {
      id: 0,
      question: '',
      options: [
        { optionText: '', voteCount: 0 },
        { optionText: '', voteCount: 0 },
        { optionText: '', voteCount: 0 },
        { optionText: '', voteCount: 0 },
      ],
    };
  }

  vote(pollId: number, optionIndex: number) {
    const poll = this.polls.find((p) => p.id === pollId);
    if (!poll) return;

    const selectedOptionText = poll.options[optionIndex].optionText;

    this.pollService.vote(pollId, selectedOptionText).subscribe({
      next: () => {
        poll.options[optionIndex].voteCount++;
      },
      error: (err) => {
        console.error('Error voting', err);
      },
    });
  }

  trackByIndex(index: number): number {
    return index;
  }
}
