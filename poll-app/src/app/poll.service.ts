import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Poll } from './poll.models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PollService {
  private baseUrl = 'http://localhost:8080/api/polls';

  constructor(private http: HttpClient) {}

  createPoll(poll: Poll): Observable<Poll> {
    return this.http.post<Poll>(this.baseUrl, poll);
  }

  getPolls(): Observable<Poll[]> {
    return this.http.get<Poll[]>(this.baseUrl);
  }

  vote(pollId: number, optionText: string): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/vote`, { pollId, optionText });
  }
}
