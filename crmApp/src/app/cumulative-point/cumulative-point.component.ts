import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CumulativePointService } from '../cumulative-point.service';
import { customer } from '../customer/customer';
import { PaymentService } from '../payment.service';
import { payment } from '../payment/payment';
import { cumulativepoint } from './cumulativepoint';

@Component({
  selector: 'app-cumulative-point',
  templateUrl: './cumulative-point.component.html',
  styleUrls: ['./cumulative-point.component.css']
})
export class CumulativePointComponent implements OnInit {

 
  cumulativepoints: cumulativepoint[];
  statusMessage: string;
  cumulativepoint = new cumulativepoint();
  payment = new payment(); 
  customer = new customer();
  paymentnew = new payment(); 


  constructor(private _cumulativepointservice: CumulativePointService ,
    private _paymenttservice: PaymentService , private _router: Router) { }

  ngOnInit(): void {
    this.cumulativepoint.payment=this.payment;
    this.cumulativepoint.customer=this.customer;
    this.getcumulativepoints();
  }

  getcumulativepoints(): void
  {
      this._cumulativepointservice.getAllcumulativepoints()
      .subscribe((cumulativepointData) => this.cumulativepoints = cumulativepointData,
      (error) => {
          console.log(error);
          this.statusMessage = 'Problem With service. Please try again later! ';
      }
      );

  }


  addcumulativepoint(): void{

        this._cumulativepointservice.addcumulativepoint(this.cumulativepoint)
        .subscribe((response) => {console.log(response); this.getcumulativepoints(); this.reset();},
        (error) => {
          console.log(error);
          this.statusMessage = 'Problem With service. Please try again later! ';
                }
        );
        this.navigate();
  }

private  reset()
{
this.cumulativepoint.id = null;
this.cumulativepoint.cumulativeTotal=null;
//this.cumulativepoint.title= null;
//this.cumulativepoint.author = null;


}

deletecumulativepoint(cumulativepointId: string)
{
  console.log("inside the deletecumulativepoint()::::cumulativepoint id::::"+cumulativepointId);
  this._cumulativepointservice.deletecumulativepoint(cumulativepointId)
   .subscribe((response) => {console.log(response); this.getcumulativepoints(); },
   (error) => {
    console.log(error);
    this.statusMessage = 'Problem With service. Please try again later! ';
      }
   );
   this.reset();
   console.log('end of deletecumulativepoint():::::::');
}


getcumulativepoint(cumulativepointId: string)
{

this._cumulativepointservice.getcumulativepointById(cumulativepointId)
.subscribe((cumulativepointData) => {this.cumulativepoint = cumulativepointData; this.getcumulativepoints();}),
(error) => {
  console.log(error);
  this.statusMessage = 'Problem With service. Please try again later! ';
    };
 
 this.reset();


}


calculateCumulative(paymentId: string)
{

this._paymenttservice.getpaymentById(paymentId)
.subscribe((paymentData) => {this.paymentnew = paymentData; }),
(error) => {
console.log(error);
this.statusMessage = 'Problem With service. Please try again later! ';
  };

  this.cumulativepoint.cumulativeTotal=this.paymentnew.amount;
}









navigate()
{
  this._router.navigate(['/addCard']);
}

}
