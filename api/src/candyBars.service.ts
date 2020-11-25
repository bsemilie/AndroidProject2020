import { Injectable } from '@nestjs/common';
import { CandyBar} from "./CandyBar";
import * as data from 'candy-data_json.json';

@Injectable()
export class CandyBarsService {

  readonly candyshop: CandyBar[] =<CandyBar[]><unknown>data;

  getAllCandyBars(): CandyBar[] | undefined{
    this.candyshop.sort((CandyBarA, CandyBarB) => {
      return CandyBarA.competitorname.localeCompare(CandyBarB.competitorname);
    });
    return this.candyshop;
  }

  addCandyBar(CandyBar: CandyBar){
    if(this.candyshop.length == 0){
      this.candyshop.push(CandyBar);
    }
    else
    {
      for(let i=0; i< this.candyshop.length ; i++)
      {
        if(this.candyshop[i].competitorname === CandyBar.competitorname){
          return;
        }
      }
      this.candyshop.push(CandyBar);
    }
  }

  getCandyBar(competitorname: string): CandyBar | undefined {
    let array = [];
    for(let i=0; i< this.candyshop.length; i++){
      if(this.candyshop[i].competitorname === competitorname){
        return this.candyshop[i];
      }
    }
  }


  deleteCandyBar(competitorname: string){
    for(let i=0; i< this.candyshop.length ; i++){
      if(this.candyshop[i].competitorname === competitorname) {
        this.candyshop.splice(i, 1);
        break;
      }
    }
  }


}
