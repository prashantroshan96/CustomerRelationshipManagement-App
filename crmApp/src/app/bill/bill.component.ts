import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BillService } from '../bill.service';
import { customer } from '../customer/customer';
import { ProductService } from '../product.service';
import { product } from '../product/product';
import { bill } from './bill';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {

  bills: bill[];
  statusMessage: string;
  bill = new bill();
  customer = new customer();
  product = new product();
  productnew = new product();


  constructor(private _billservice: BillService ,
    private _productservice: ProductService , private _router: Router) { }

  ngOnInit(): void {
    this.bill.customer=this.customer;
    this.bill.product=this.product;
    this.getbills();
  }

  getbills(): void
  {
      this._billservice.getAllbills()
      .subscribe((billData) => this.bills = billData,
      (error) => {
          console.log(error);
          this.statusMessage = 'Problem With service. Please try again later! ';
      }
      );

  }


  addbill(): void{

        this._billservice.addbill(this.bill)
        .subscribe((response) => {console.log(response); this.getbills(); this.reset();},
        (error) => {
          console.log(error);
          this.statusMessage = 'Problem With service. Please try again later! ';
                }
        );

        this.navigate();
  }

private  reset()
{
this.bill.id = null;
// this.bill.customer= null;
// this.bill.author = null;


}

deletebill(billId: string)
{
  console.log("inside the deletebill()::::bill id::::"+billId);
  this._billservice.deletebill(billId)
   .subscribe((response) => {console.log(response); this.getbills(); },
   (error) => {
    console.log(error);
    this.statusMessage = 'Problem With service. Please try again later! ';
      }
   );
   this.reset();
   console.log('end of deletebill():::::::');
}


getbill(billId: string)
{

this._billservice.getbillById(billId)
.subscribe((billData) => {this.bill = billData; this.getbills();}),
(error) => {
  console.log(error);
  this.statusMessage = 'Problem With service. Please try again later! ';
    };
 
 this.reset();


}

calculateBill(productId: string)
{
this._productservice.getproductById(productId)
.subscribe((productData) => {this.productnew = productData; }),
(error) => {
console.log(error);
this.statusMessage = 'Problem With service. Please try again later! ';
  };

this.bill.billAmount=(this.productnew.productQuantity)*(this.productnew.productMRP)

}



// calculateDiscount(billId: string)
// {

// this._billservice.getbillById(billId)
// .subscribe((billData) => {this.billnew = billData; }),
// (error) => {
// console.log(error);
// this.statusMessage = 'Problem With service. Please try again later! ';
//   };

// // this.payment.amount = ((this.billnew.billAmount) - (this.payment.discount));
// //this.payment.amount = ((this.billnew.billAmount) - (this.payment.discount));
// this.payment.amount =   ((this.billnew.billAmount)  -  ((this.billnew.billAmount)* ((this.payment.discount)/(100))))
// }












navigate()
{
  this._router.navigate(['/addPayment']);
}


}
