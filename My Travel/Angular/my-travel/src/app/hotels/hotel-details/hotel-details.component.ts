import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-hotel-details',
  templateUrl: './hotel-details.component.html',
  styleUrls: ['./hotel-details.component.css']
})
export class HotelDetailsComponent {

  hotelDetails:any;

  constructor(private http:HttpClient) {

  }

  findByIdHotel(hotelId:string) {
    // http://localhost:8001/hotel/findEmail
    this.http.get(`http://localhost:8001/hotel/findEmail/${hotelId}`).subscribe((data) => {
      this.hotelDetails = data;
      console.log(data)
    })
  }

}
