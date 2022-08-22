import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from 'src/app/common/category';
import { ICategory, ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-category-menu',
  templateUrl: './category-menu.component.html',
  styleUrls: ['./category-menu.component.css']
})
export class CategoryMenuComponent implements OnInit {

  categories: Category[];

  constructor(private service: ProductService) { }

  ngOnInit(): void {
    this.listCategories();
  }

  listCategories() {
    this.service.getCategories().subscribe({
      next: (data) => {
        console.log('Categories---'+ JSON.stringify(data));
        this.categories = data;
      }
    })
  }

}
