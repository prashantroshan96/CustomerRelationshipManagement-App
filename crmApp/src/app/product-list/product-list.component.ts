import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../product.service';
import { product } from '../product/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: product[];
  statusMessage: string;
  product = new product();
  search: string;

  constructor(private _productservice: ProductService , private _router: Router) { }

  ngOnInit(): void {
    this.getproducts();
  }

  getproducts(): void
  {
      this._productservice.getAllproducts()
      .subscribe((productData) => this.products = productData,
      (error) => {
          console.log(error);
          this.statusMessage = 'Problem With service. Please try again later! ';
      }
      );

  }


}
