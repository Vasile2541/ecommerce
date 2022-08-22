import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../common/product';
import { map } from 'rxjs/operators';
import { Category } from '../common/category';
import { ProductMetadata } from '../common/page-metadata';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productsUrl   = 'http://localhost:8080/api/products';
  private categoriesUrl = 'http://localhost:8080/api/categories';

  constructor(private httpClient: HttpClient) { }

  getProductById(productId: number): Observable<Product>{
    const searchUrl = `${this.productsUrl}/${productId}`;
    return this.httpClient.get<Product>(searchUrl);
  }

  searchProducts(theKeyword: string): Observable<Product[]> {
    const searchUrl = `${this.productsUrl}/search/findByNameContaining/?name=${theKeyword}`;
    
    return this.httpClient.get<Product[]>(searchUrl);
  }

  getProductListPaginated(page      : number, 
                          pageSize  : number, 
                          sortBy    : string,
                          sortDir   : string
                          // categoryId: number
                          ): Observable<IPage>{
    const searchUrl =`${this.productsUrl}/?` //search/byCategoryId/${categoryId}
                      + `&page=${page}`     + `&size=${pageSize}`
                      + `&sortBy=${sortBy}` + `&sortDir=${sortDir}`;
    
    return this.httpClient.get<IPage>(searchUrl);
    //  .pipe(
    //     map((response: IPage) => {
    //       response.products,
    //       response.metadata
    //     })
    //   );
  }


  getProductList(categoryId: number): Observable<Product[]>{
    const searchUrl =`${this.productsUrl}/search/byCategoryID/${categoryId}`; 
    
    return this.httpClient.get<Product[]>(searchUrl);
  }
  
  //observable means that this code is going to resolve later point in time, becouse we make a network call, and we want to be notifient when we get some data back 

  getCategories() :Observable<Category[]>{
    const searchUrl = this.categoriesUrl;
    //http - will deserialize this data when we get the  response, adn its going to parse it as an array of ICategory 
    return this.httpClient.get<Category[]>(searchUrl);
      // .pipe(
      //   map((response: ICategory[]) => {
      //     response._embedded.categories;
      //   })
      // );
  }

}

export interface IPage{
    data: Product[];
    metadata: ProductMetadata;
  }

  export interface ICategory{ //Unwraps the JSON from Spring rest API and make use of _embedded entry taht comes back from API
    _embedded: {
      categories: Category[];
    }
  }

