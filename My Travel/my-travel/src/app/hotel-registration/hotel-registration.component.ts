import { Component } from '@angular/core';
import { HotelDetails } from '../model-share/hotel.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-hotel-registration',
  templateUrl: './hotel-registration.component.html',
  styleUrls: ['./hotel-registration.component.css']
})
export class HotelRegistrationComponent {

  model:HotelDetails = {
    hotelId:'',
    hotelName:'',
    mobileNumber:'',
    city:'',
    state:'',
    description:'',
    imageLink:'',
    email:'',
    password:''
  }

  constructor(private http:HttpClient) {

  }

  onSubmit() {
    // http://localhost:8001/hotel/create
    this.http.post("http://localhost:8001/hotel/create",this.model).subscribe((data) => {
      console.log(data)
      window.location.reload();
    })
  }

}
