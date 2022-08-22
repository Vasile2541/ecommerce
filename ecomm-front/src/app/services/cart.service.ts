import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { CartItem } from '../common/cart-item';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() { }

  cartItems: CartItem[] = [];

  totalPrice: Subject<number> = new Subject<number>();

  //Subject is a sunclass of Observable, we can use it to publich events in our code , and the event will be sent to all subscribers
  totalQuantity: Subject<number> = new Subject<number>();

  addToCart(item: CartItem){
    let itemExists: boolean = false;

    if(this.cartItems.length > 0){

      // let cartitem = this.cartItems.find(itemm => itemm.id === item.id);//intoarce primul elemente care corespunde la lambda

      for( let cartItem of this.cartItems){
        if(cartItem.id === item.id){
          cartItem.quantity++;
          itemExists = true;
          break;
        }
      }
    }

    if(!itemExists){
      this.cartItems.push(item);
    }

    this.computeCartTotals();

  }
  computeCartTotals() {
    let totalCartPrice: number = 0.00;
    let totatCartQuantity: number = 0;

    for(let cartItem of this.cartItems){
      totalCartPrice += cartItem.quantity * cartItem.unitPrice;
      totatCartQuantity += cartItem.quantity;
    }

    //public new data(send the event)
    this.totalPrice.next(totalCartPrice);
    this.totalQuantity.next(totatCartQuantity);

    //log cart data 
    this.logCartData(totalCartPrice, totatCartQuantity);
  }

  logCartData(totalCartPrice1: number, totatCartQuantity1: number) {
    for(let item of this.cartItems){
      let totalPrice = item.quantity * item.unitPrice;
      console.log(
        `name: ${item.name} 
         quantity: ${item.quantity}
         unitPrice: ${item.unitPrice}
         totalPrice: ${totalPrice}`
      );
      console.log(
        `totalQuantity: ${totatCartQuantity1}
         totalPrice: ${totalCartPrice1.toFixed(3)}
         `
      )
      console.log("-------")
    }
  }

}
