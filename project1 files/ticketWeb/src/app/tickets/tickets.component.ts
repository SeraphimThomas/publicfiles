import { Component, OnInit } from '@angular/core';
import { Tickets } from '../tickets';
import { Router } from '@angular/router';
import { TicketsService } from '../tickets.service';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Login } from '../login/login';

@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrls: ['./tickets.component.css']
})
export class TicketsComponent implements OnInit {

  tickets: Tickets[] = [];
  login: Login | undefined;
  ticket: Tickets = {
    employeeID: 0,
    ticketNum: 0,
    ticketType: '',
    ticketVal: 0.0,
    comment: ''
  }
  

  constructor(private router:Router, private ticketService: TicketsService,
              private http:HttpClient) { }

  ngOnInit(): void {
    this.getTickets();
  }

  getTickets(): void {
    this.ticketService.getTickets()
    .subscribe(ticketList => {
      console.log(ticketList)
      this.tickets = ticketList
    });
  }

  selectedTicket?: Tickets;

  onSelect(ticket: Tickets): void{
    this.selectedTicket = ticket;
    console.log(ticket.ticketNum);
  }

  logout(){
    localStorage.clear()
    this.router.navigate(['login'])
  }
  onSubmit(form:NgForm){
    console.log(form)
    this.http.post("http://localhost:8080/ticketreimb/home", 
                    JSON.stringify({
                    employeeid: form.value.employeeid, 
                    comment: form.value.comment,
                    ticketType: form.value.ticketType,
                    ticketVal: form.value.ticketVal}))
                    .subscribe({
                      next: (data:any)=>{
                      if(data.status === 'success'){
                        this.router.navigate(['tickets'])
                      }
                    }})
  }

}
