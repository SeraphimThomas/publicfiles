import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Tickets } from './tickets';
import { catchError, map, tap} from 'rxjs/operators';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class TicketsService {

  private ticketsUrl = 'http://localhost:8080/ticketreimb/home'

  constructor(private http: HttpClient, private messageService: MessageService) { }

  getTickets(): Observable<Tickets[]>{
    return this.http.get<Tickets[]>(this.ticketsUrl).pipe(tap(_=> this.log('fetched tickets')),
    catchError(this.handleError<Tickets[]>('getTickets',[]))
    );
  }

  // getIdTickets(id: number): Observable<Tickets>{
  //   const url = `${this.ticketsUrl}/${id}`;
  //   return this.http.get<Tickets>(url).pipe(
  //     tap(_ => this.log(`fetched tickets id =${id}`)),
  //     catchError(this.handleError<Tickets>(`getIdTickets id=${id}`))
  //   )
  // }

  private handleError<T>(operation = 'operation', result?: T){
    return (error: any): Observable<T> => {
      console.error(error);

      this.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    }
  }

  private log(message: String){
    this.messageService.add('TicketService: $(message)');
  }
}
