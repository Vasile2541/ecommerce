import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart-status',
  templateUrl: './cart-status.component.html',
  styleUrls: ['./cart-status.component.css']
})
export class CartStatusComponent implements OnInit {

  constructor(private cartService: CartService) { }

  totalPrice: number = 0.00;
  totalQuantity: number = 0;

  ngOnInit(): void {
    this.updateCartStatus();
  }

  updateCartStatus() {
    // subscribe for the events on cartService 
    this.cartService.totalPrice.subscribe(
      data => this.totalPrice = data
    );
    this.cartService.totalQuantity.subscribe(
      data => this.totalQuantity = data
    );

  }

}
