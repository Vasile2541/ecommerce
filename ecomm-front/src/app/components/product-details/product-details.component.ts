import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from 'src/app/common/cart-item';
import { Product } from 'src/app/common/product';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  constructor(private productService: ProductService,
              private cartService: CartService,
              private route: ActivatedRoute) { }

  product: Product = new Product();

  ngOnInit(): void {
    this.route.paramMap.subscribe(
      ()=>{
        this.getProdutById();
      }
    )
  }

  getProdutById(){
    const productId: number = Number(this.route.snapshot.paramMap.get('id'));
    // const id = this.route.snapshot.paramMap.get('id') || 'yourDefaultString';

    this.productService.getProductById(productId).subscribe({
      next: (data: Product) =>{
        this.product = data;
      }
    })
    
  }
    
  addToCart(product: Product){
    this.cartService.addToCart(new CartItem(product));
  }
  
  
}
