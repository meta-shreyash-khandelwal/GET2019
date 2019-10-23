import { Item } from './item';

export class OrderDetails {

    Name : string;
    Address1 : string;
    Address2 : String;
    City : String;
    OrderDate : Date;
    OrderItems : Item[] = []

    constructor(Name, Address1, Address2, City, OrderDate, OrderItems) {
        this.Name = Name;
        this.Address1 = Address1;
        this.Address2 = Address2;
        this.City = City;
        this.OrderDate = OrderDate;
        this.OrderItems = OrderItems;
    }
}
