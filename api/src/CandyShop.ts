import {ChocolateBar} from "./ChocolateBar";

export class CandyShop {
    candyshop: ChocolateBar[];

    constructor() {
        this.candyshop = [];
    }

    addChocolateBar(chocolateBar : ChocolateBar){
        if (this.candyshop.length == 0){
            this.candyshop.push(chocolateBar);
        }
        else{
            for(let i=0; i<this.candyshop.length; i++){
                if(this.candyshop[i].ref === chocolateBar.ref)
                {
                    return;
                }
                this.candyshop.push(chocolateBar);
            }
        }
    }

    getChocolateBar(ref: string){
        for (let i=0; i <this.candyshop.length; i++)
        {
            if(this.candyshop[i].ref === ref)
                return this.candyshop[i];
        }
    }

    getAllChocolateBars(){
        let array = [];
        for(let i=0; i<this.candyshop.length ; i++){
            array.push(this.candyshop[i]);
        }
        array.sort((chocolateBarA, chocolateBarB) => chocolateBarA.ref.localeCompare(chocolateBarB.ref));
        return array;
    }

    getChocolateBarsOf(company: string){
        let array = [];
        for(let i=0; i<this.candyshop.length ; i++){
            if(this.candyshop[i].company === company)
                array.push(this.candyshop[i]);
        }
        return array;
    }
}