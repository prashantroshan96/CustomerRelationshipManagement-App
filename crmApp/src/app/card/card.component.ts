import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { toInteger } from '@ng-bootstrap/ng-bootstrap/util/util';
import { CardService } from '../card.service';
import { CumulativePointService } from '../cumulative-point.service';
import { cumulativepoint } from '../cumulative-point/cumulativepoint';
import { customer } from '../customer/customer';
import { card } from './card';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  
  cards: card[];
 
  statusMessage: string;
  
  card = new card();
  
  customer = new customer();

  sum: number=0;
  

  cumulativepoints: cumulativepoint[];
 
 // cumulativePoint = new cumulativepoint();

  constructor(private _cardservice: CardService ,private _cumulativepointservice: CumulativePointService , private _router: Router) { }

  ngOnInit(): void {
   
    //this.card.cumulativePoint=this.cumulativePoint;
    this.card.customer=this.customer;
 //  this.card.cardType='silver';
    this.getcards();
  }

  getcards(): void
  {
      this._cardservice.getAllcards()
      .subscribe((cardData) => this.cards = cardData,
      (error) => {
          console.log(error);
          this.statusMessage = 'Problem With service. Please try again later! ';
      }
      );

  }


  addcard(): void{

        this._cardservice.addcard(this.card)
        .subscribe((response) => {console.log(response); this.getcards(); this.reset();},
        (error) => {
          console.log(error);
          this.statusMessage = 'Problem With service. Please try again later! ';
                }
        );

        this.navigate();
  }

private  reset()
{
this.card.id = null;
//this.card.title= null;
//this.card.author = null;


}

deletecard(cardId: string)
{
  console.log("inside the deletecard()::::card id::::"+cardId);
  this._cardservice.deletecard(cardId)
   .subscribe((response) => {console.log(response); this.getcards(); },
   (error) => {
    console.log(error);
    this.statusMessage = 'Problem With service. Please try again later! ';
      }
   );
   this.reset();
   console.log('end of deletecard():::::::');
}


getcard(cardId: string)
{

this._cardservice.getcardById(cardId)
.subscribe((cardData) => {this.card = cardData; this.getcards();}),
(error) => {
  console.log(error);
  this.statusMessage = 'Problem With service. Please try again later! ';
    };
 
 this.reset();


}



// updatecard(customerId: string)
// {

//   this._cumulativePointservice.calculatecumulativepointById(customerId)
//   .subscribe((sumData) => {this.cumulative= sumData; }),
// (error) => {
//   console.log(error);
//   this.statusMessage = 'Problem With service. Please try again later! ';
//     };


// }

updatecard()
{
  this._cumulativepointservice.getAllcumulativepoints()
  .subscribe((cumulativepointData) => this.cumulativepoints = cumulativepointData,


  
  (error) => {
   
    console.log(this.sum);
    console.log(error);
      this.statusMessage = 'Problem With service. Please try again later! ';
  }
  );
 
var cumulativeTotal=0;
  for (let i = 0; i < this.cumulativepoints.length; i++)
  {
         if(this.cumulativepoints[i].customer.id==this.customer.id)
         {
          
            console.log( this.cumulativepoints[i].cumulativeTotal);
            
              this.sum+=(this.cumulativepoints[i].cumulativeTotal);
         }
  }

console.log(this.sum);
if(this.sum>2500)
this.card.cardType='gold'
 else
 this.card.cardType='silver'



//var jan = 0; //this should solve it

// for (var i=0;i<data.length;i++){ 
//     if(data[i].jan != null){    
//         jan += parseFloat(data[i].jan);
//         console.log(jan);
//     }
// }



}

navigate()
{
  this._router.navigate(['/addBill']);
}




}
