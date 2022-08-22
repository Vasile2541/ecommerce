import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductMetadata } from 'src/app/common/page-metadata';
import { ErrorHandlerService } from 'src/app/services/error-handler.service';
import { IPage, ProductService } from 'src/app/services/product.service';
import { CartItem } from 'src/app/common/cart-item';
import { CartService } from 'src/app/services/cart.service';


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  currentCategoryId: number;
  searchModel: boolean;
  errorMessage: string = '';
    //pagination
  products: Product[];
  metadata: ProductMetadata;

  pageNr: number  = 1;
  size: number    = 8;
  sortBy: string  = "name";
  sortDir: string = "ASC";


  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private route: ActivatedRoute,
    private errorHandler: ErrorHandlerService) { }

  ngOnInit(): void {
    // this.handleListProductsPaginated();

    this.route.paramMap.subscribe({
      next: () => {
        this.handleProductOutput();
        // this.handleListProducts();
      }
    });
  }

  handleProductOutput(){
    this.searchModel = this.route.snapshot.paramMap.has('keyword');
    if(this.searchModel){
      this.handleSearchProducts();
    }else{
        // this.handleListProductsPaginated();
        this.handleListProducts();
        
    }
  }

  handleSearchProducts(){
    const theKeyword = this.route.snapshot.paramMap.get('keyword');

    if(theKeyword != null){
      this.productService.searchProducts(theKeyword).subscribe({
        next:(data: Product[]) =>{
          this.products = data;
        },
        error: (err: HttpErrorResponse) => {
          this.errorHandler.handleError(err);
          this.errorMessage = this.errorHandler.errorMessage;
        }
      });
    }
    
  }

  handleListProducts(){
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');

     if(hasCategoryId){
      //If you intend not to update your URL parameter within the same component you are accessing it, then you can use the snapshot.
      //As the name suggests, the parameter would only be accessed once, when the component loads. Hence, it won’t be updated, even if you change its value from within the same component.
      //If you intend to update the URL parameter within the same component, then you have to use a subscription.

      this.currentCategoryId = +this.route.snapshot.params['id'];
      // const productId: number  = Number(this.route.snapshot.paramMap.get('id'))
      // this.currentCategoryId = +this.route.snapshot.paramMap.get('id');
     }else{
      this.currentCategoryId = 1;
     }

    this.productService.getProductList(this.currentCategoryId)
      .subscribe({
        next: (data: Product[]) => {
          // console.warn('Products'+ JSON.stringify(data))
          this.products = data;
          // console.warn('Products---'+ JSON.stringify(this.products))
        },//method is invocked once you are subscribe(),will execte async

        error: (err: HttpErrorResponse) => {
          this.errorHandler.handleError(err);
        }
      })


  }

  handleListProductsPaginated(){
    this.productService.getProductListPaginated(this.pageNr-1, this.size, this.sortBy, this.sortDir)
      .subscribe({
        next: (data:  IPage) => {
          this.products = data.data;
          this.metadata = data.metadata;

          // console.warn('Data---'+JSON.stringify(data));
          // console.warn('pageData---'+JSON.stringify(this.products));
          // console.warn('pageMeta---'+JSON.stringify(this.metadata));
        },//method is invocked once you are subscribe(),will execte async

        error: (err: HttpErrorResponse) => {
          this.errorHandler.handleError(err);
        }
      })
  }
  updatePageSize(event: any): void{
  
    this.size = event.target.value;
    // console.log("size---"+this.size);
    this.pageNr = 1;
    this.handleListProducts();
  }

  addToCart(product: Product){
    console.log(product.name)

    this.cartService.addToCart( new CartItem(product));

    
  }
}
