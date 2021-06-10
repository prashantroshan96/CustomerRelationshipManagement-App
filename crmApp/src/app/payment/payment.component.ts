import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BillService } from '../bill.service';
import { bill } from '../bill/bill';
import { CardService } from '../card.service';
import { card } from '../card/card';
import { PaymentService } from '../payment.service';
import { payment } from './payment';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

 
  payments: payment[];
  statusMessage: string;
  payment = new payment();
  bill = new bill();
  billnew = new bill();

  // card = new card();
  // cardnew = new card();

  cards: card[];


  constructor(private _paymentservice: PaymentService ,private _billservice: BillService ,
    private _cardservice: CardService,
     private _router: Router) {

  }

  ngOnInit(): void {
   this.payment.bill=this.bill;
   this.getpayments();
  

  }

  getpayments(): void
  {
      this._paymentservice.getAllpayments()
      .subscribe((paymentData) => this.payments = paymentData,
      (error) => {
          console.log(error);
          this.statusMessage = 'Problem With service. Please try again later! ';
      }
      );



  }

//   calculateDiscount(cardId: string)
//   {

// this._cardservice.getcardById(cardId)
// .subscribe((cardData) => {this.cardnew = cardData; }),
// (error) => {
//   console.log(error);
//   this.statusMessage = 'Problem With service. Please try again later! ';
//     };

//       if(this.cardnew.cardType=='silver')
//       {
//            this.payment.discount=5;
//       }
//       else{
//         this.payment.discount=10;

//       }

//   }


calculateDiscount()
{

this._cardservice.getAllcards()
.subscribe((cardData) => {this.cards = cardData; }),
(error) => {
console.log(error);
this.statusMessage = 'Problem With service. Please try again later! ';
  };


  // var cumulativeTotal=0;
  for (let i = 0; i < this.cards.length; i++)
  {
         
          
            console.log( this.cards[i].cardType);
            
          if(i==this.cards.length-1 )
          {
     
             console.log(i);

                if(this.cards[i].cardType=='silver')   
                 {
                  this.payment.discount=5;
                   }
                else{
                  this.payment.discount=10;

                }
           }     
  }

  // var j=this.cards.length;
  // console.log(j);
  // console.log(this.cards[j].cardType);

  //  console.log(this.cards[this.cards.length]);


  // for (let i = this.cards.length; i > this.cards.length-1; i--)
  // {
         
          
  //           console.log( this.cards[i].cardType);
  //           if(this.cards[i].cardType=='silver')   
  //          {
  //              this.payment.discount=5;
  //           }
  //         else{
  //           this.payment.discount=10;

  //         }
         
  // }



  // var j=this.cards.length;
  // console.log(j);
  // console.log(this.cards[j].cardType);

  //  console.log(this.cards[this.cards.length]);

  // console.log(this.cards[this.cards.length].cardType);


  //   if(this.cards[this.cards.length].cardType=='silver')   
  //   {
  //        this.payment.discount=5;
  //   }
  //   else{
  //     this.payment.discount=10;

  //   }

}




// calculateDiscount(customerId: string)
// {

// this._cardservice.getAllcards()
// .subscribe((cardData) => {this.cards = cardData; }),
// (error) => {
// console.log(error);
// this.statusMessage = 'Problem With service. Please try again later! ';
//   };

//   this.cards.indexOf
//  console.log(this.cards.lastIndexOf(this.card,1))

// console.log(this.cards[this.cards.length].cardType);


//     if(this.cards[this.cards.length].cardType=='silver')   
//     {
//          this.payment.discount=5;
//     }
//     else{
//       this.payment.discount=10;

//     }

// }














  calculatePayment(billId: string)
  {
  
this._billservice.getbillById(billId)
.subscribe((billData) => {this.billnew = billData; }),
(error) => {
  console.log(error);
  this.statusMessage = 'Problem With service. Please try again later! ';
    };

  this.payment.amount =   ((this.billnew.billAmount)  -  ((this.billnew.billAmount)* ((this.payment.discount)/(100))))
}


  addpayment(): void{

        this._paymentservice.addpayment(this.payment)
        .subscribe((response) => {console.log(response); this.getpayments(); this.reset();},
        (error) => {
          console.log(error);
          this.statusMessage = 'Problem With service. Please try again later! ';
                }
        );
     //   this.payment.amount=1000-1;
      this.navigate();
  }

private  reset()
{
this.payment.id = null;
this.payment.modeOfPay=null;
this.payment.discount = null;
this.payment.amount = null;

//this.payment.title= null;
//this.payment.author = null;


}

deletepayment(paymentId: string)
{
  console.log("inside the deletepayment()::::payment id::::"+paymentId);
  this._paymentservice.deletepayment(paymentId)
   .subscribe((response) => {console.log(response); this.getpayments(); },
   (error) => {
    console.log(error);
    this.statusMessage = 'Problem With service. Please try again later! ';
      }
   );
   this.reset();
   console.log('end of deletepayment():::::::');
}


getpayment(paymentId: string)
{

this._paymentservice.getpaymentById(paymentId)
.subscribe((paymentData) => {this.payment = paymentData; this.getpayments();}),
(error) => {
  console.log(error);
  this.statusMessage = 'Problem With service. Please try again later! ';
    };
 
 this.reset();


}

navigate()
{
  this._router.navigate(['/addCumulativePoint']);
}
}
