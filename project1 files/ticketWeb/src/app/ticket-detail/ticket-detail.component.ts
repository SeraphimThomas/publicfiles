import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Tickets } from '../tickets';
import { TicketsService } from '../tickets.service';
import { Location } from '@angular/common';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-ticket-detail',
  templateUrl: './ticket-detail.component.html',
  styleUrls: ['./ticket-detail.component.css']
})
export class TicketDetailComponent implements OnInit {


  @Input() ticket?: Tickets;
  login?: LoginComponent;

  constructor(private route: ActivatedRoute,
              private ticketService: TicketsService,
              private location: Location
              ) { }

  ngOnInit(): void {
    // this.getTicket();
  }

  // getTicket(): void{
  //   const id = Number(this.route.snapshot.paramMap.get('ticketNum'));
  //   this.ticketService.getIdTickets(id).subscribe
  //     (ticket=> this.ticket = ticket);
  // }

  // goBack(): void{
  //   this.location.back();
  // }

}
