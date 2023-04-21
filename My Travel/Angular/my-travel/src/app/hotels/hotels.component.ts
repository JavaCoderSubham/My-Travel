import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HotelDetailsComponent } from './hotel-details/hotel-details.component';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent {

  hotelDetails:any;
  

  constructor(private http:HttpClient) {
    
  }

  ngOnInit() {
    // http://localhost:8001/hotel/getAll
    this.http.get("http://localhost:8001/hotel/getAll").subscribe((data) => {
      this.hotelDetails = data;
      console.log(data)
    })
  }

  onClientGet(hotelId:string) {
    // this.hotelDetailsCompoment.findByIdHotel();
  }

}
