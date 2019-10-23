import { Injectable } from '@angular/core';
import { Item } from './item';
import { Observable } from 'rxjs';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { OrderDetails } from './order-details';

@Injectable({
  providedIn: 'root'
})
export class ShoppingService {

  Orders :  OrderDetails[] = [];
  order : OrderDetails
  cartCount : number = 0;
  itemsArr : Item[] = [];
  cart :  any[];


  /**
   * to get data from server.
   * @param httpClient 
   */
  constructor(private httpClient : HttpClient) {
   this.httpClient.get<Item[]>('http://localhost:8080/RESTAPI/rest/items/getItems').subscribe(data => {
     data.forEach(item => {
       this.itemsArr.push(item);
     })
   })
}

/**
 * Storing orders
 * @param orderModel
 */
placeOrder(orderModel: OrderDetails) {
  localStorage.setItem(orderModel.OrderDate.toString(), JSON.stringify(orderModel));
}

/**
 * To get all orders
 */
getAllOrder() {
  this.Orders = [];
  for (let key in localStorage) {
    if (localStorage.getItem(String(key)) != null) {
        this.Orders.push(this.stringToOrders(localStorage.getItem(String(key))));
    }
}
return this.Orders;
}

/**
 * converting string into orders
 * @param str 
 */
stringToOrders(str) {
      this.order = JSON.parse(str);
      return this.order;
}
  
/**
 * To get all items
 */
getAllItems(){
    return this.itemsArr;
  }

  
  addToCart(itemId) {  
    this.cartCount++;
    for(var i = 0; i < this.itemsArr.length; i++) {
      if(this.itemsArr[i].id == itemId) {
          this.itemsArr[i].quantity++;
      }
    }
    return this.cartCount;
  }

  /**
   * To increment count of an item into cart.
   * @param itemId 
   */
  incrementItem(itemId) {
    this.cartCount++;
    for(var i = 0; i < this.itemsArr.length; i++) {
      if(this.itemsArr[i].id == itemId) {
          this.itemsArr[i].quantity++;
      }
    }
    return this.cartCount
  }

    /**
   * To decrement count of an item into cart.
   * @param itemId 
   */
  decrementItem(itemId) {
    for(var i = 0; i < this.itemsArr.length; i++) {
      if(this.itemsArr[i].id == itemId) {
          if(this.itemsArr[i].quantity > 0) {
            this.itemsArr[i].quantity--;
            this.cartCount--;
          }
      }
    }
    return this.cartCount;
  }

  /**
   * To clear the cart
   */
  reset() {
    for(var i = 0; i < this.itemsArr.length; i++) {
      this.itemsArr[i].quantity = 0;
      this.cartCount = 0;
  }
}

/**
 * To calculate total of cart items.
 */
getTotal() {
  var total = 0;
  for(var i = 0; i < this.itemsArr.length ; i++) {
    total = +total + +(this.itemsArr[i].quantity * Number(this.itemsArr[i].price));
  }
  return total;
}
}
