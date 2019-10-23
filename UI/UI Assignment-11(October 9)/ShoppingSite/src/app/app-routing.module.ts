import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AllItemsComponent } from './all-items/all-items.component';
import { AppComponent } from './app.component';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { PlacedOrderComponent } from './placed-order/placed-order.component';
import { OrdersComponent } from './orders/orders.component';
import { OrderInfoComponent } from './order-info/order-info.component';


const routes: Routes = [ { path : 'all-items/:category', component : AllItemsComponent },
{path : 'all-items', component : AllItemsComponent},
{path : 'app', component : AppComponent},
{path : 'cart', component : CartComponent},
{path : 'checkOut', component : CheckoutComponent},
{path : 'confirmed', component : PlacedOrderComponent},
{path : 'orders', component : OrdersComponent},
{path : 'OrderInfo/:OrderDate', component : OrderInfoComponent} ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
