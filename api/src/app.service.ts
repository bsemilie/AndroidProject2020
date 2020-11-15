import { Injectable } from '@nestjs/common';
import { ChocolateBar} from "./ChocolateBar";

@Injectable()
export class AppService {

  private readonly candyshop: ChocolateBar[] = [];

  getAllChocolateBars(): ChocolateBar[] | undefined{
    this.candyshop.sort((chocolateBarA, chocolateBarB) => {
      return chocolateBarA.ref.localeCompare(chocolateBarB.ref);
    });
    return this.candyshop;
  }

  addChocolateBar(chocolateBar: ChocolateBar){
    if(this.candyshop.length == 0){
      console.log(chocolateBar.company);
      this.candyshop.push(chocolateBar);
    }
    else
    {
      for(let i=0; i< this.candyshop.length ; i++)
      {
        if(this.candyshop[i].ref === chocolateBar.ref){
          return;
        }
      }
      this.candyshop.push(chocolateBar);
    }
  }

  getChocolateBar(ref: string): ChocolateBar | undefined {
    let array = [];
    for(let i=0; i< this.candyshop.length; i++){
      if(this.candyshop[i].ref === ref){
        return this.candyshop[i];
      }
    }
  }

  getChocolateBarsOf(company: string): ChocolateBar[] | undefined{
    let array= [];
    for(let i=0; i<this.candyshop.length; i++){
      if(this.candyshop[i].company === company){
        array.push(this.candyshop[i]);
      }
    }
    return array;
  }

  deleteChocolateBar(ref: string){
    for(let i=0; i< this.candyshop.length ; i++){
      if(this.candyshop[i].ref === ref) {
        this.candyshop.splice(i, 1);
        break;
      }
    }
  }

}
