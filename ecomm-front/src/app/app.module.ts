import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { HttpClientModule } from '@angular/common/http'
import { ProductService } from './services/product.service';

import { Routes, RouterModule } from '@angular/router';
import { CategoryMenuComponent } from './components/category-menu/category-menu.component';
import { SearchComponent } from './components/search/search.component';
import { InternalServerComponent } from './components/error-pages/internal-server/internal-server.component';
import { ClientSideComponent } from './components/error-pages/client-side/client-side.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';

const routes: Routes = [
  {path: 'cart-details',    component: CartDetailsComponent},
  {path: 'search/:keyword', component: ProductListComponent},
  {path: 'products/:id',    component: ProductDetailsComponent},
  {path: 'products',        component: ProductListComponent},
  {path: 'category/:id',    component: ProductListComponent},
  {path: 'category',        component: ProductListComponent},
  {path: '400',             component: ClientSideComponent},
  {path: '500',             component: InternalServerComponent},
  {path: '',   redirectTo: '/products', pathMatch: 'full'},
  {path: '**', redirectTo: '/products', pathMatch: 'full'}
  
  //there is two ways to handle parameters in angular
    //- snapshop(use ActivatedRoute shapshop property)
    // - using an Observable

]

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    CategoryMenuComponent,
    SearchComponent,
    ProductDetailsComponent,
    CartStatusComponent,
    CartDetailsComponent
    //importam manual asta 
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    NgxPaginationModule
  ],
  providers: [ProductService],//punem referinta la serviciile create, pentru a putea injecta acest serviciu in alte parti in cadru aplicatiei noastre
  bootstrap: [AppComponent]
})
export class AppModule { }
