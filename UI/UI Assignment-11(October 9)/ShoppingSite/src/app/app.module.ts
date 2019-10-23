import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { AllItemsComponent } from './all-items/all-items.component';
import { RouterModule, Routes } from '@angular/router';
import { CheckoutComponent } from './checkout/checkout.component';
import { CartComponent } from './cart/cart.component';
import { OrdersComponent } from './orders/orders.component';
import { PlacedOrderComponent } from './placed-order/placed-order.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { OrderInfoComponent } from './order-info/order-info.component';




@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    AllItemsComponent,
    CheckoutComponent,
    CartComponent,
    OrdersComponent,
    PlacedOrderComponent,
    OrderInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
