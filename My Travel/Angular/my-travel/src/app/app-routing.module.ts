import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { HotelsComponent } from './hotels/hotels.component';
import { HotelRegistrationComponent } from './hotel-registration/hotel-registration.component';
import { HotelDetailsComponent } from './hotels/hotel-details/hotel-details.component';

const routes: Routes = [
  {
    component: LoginComponent,
    path: 'login'
  },
  {
    component: RegistrationComponent,
    path: 'registration'
  },
  {
    component: UserDetailsComponent,
    path: 'user-details '
  },
  {
    component: HotelsComponent,
    path: 'home'
  },
  {
    component: HotelDetailsComponent,
    path: "hotel/details"
  },
  {
    component: HotelRegistrationComponent,
    path: 'creat-hotel'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
