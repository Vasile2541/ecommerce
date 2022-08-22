import { Component, OnInit } from '@angular/core';
import { ErrorHandlerService } from 'src/app/services/error-handler.service';

@Component({
  selector: 'app-client-side',
  templateUrl: './client-side.component.html',
  styleUrls: ['./client-side.component.css']
})
export class ClientSideComponent implements OnInit {
  errorMessage: string = "Client SIDE ERROR, CONTACT ADMINISTRATOR!!!!";


  constructor(private errorHandler: ErrorHandlerService) { }

  ngOnInit(): void {
    this.errorMessage = this.errorHandler.errorMessage;
  }

}
