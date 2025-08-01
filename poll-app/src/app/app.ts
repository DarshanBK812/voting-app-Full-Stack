import { Component, signal } from '@angular/core';
import { PollComponent } from './poll/poll.component';

@Component({
  selector: 'app-root',
  imports: [PollComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('poll-app');
}
