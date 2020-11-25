export interface CandyBar{
    bar: number, //is it a candy bar
    caramel: number, //is there caramel in the candy
    chocolate: number, //does it contain chocolate
    competitorname: string, //Name of the candy
    crispedricewafer: number, //Does it contain crisped rice, wafers, or a cookie component?
    fruity: number, //Is it fruit flavored ?
    hard: number, //It is a hard candy?
    nougat: number, //Does it contain nougat ?
    peanutyalmondy: number, //Does it contain peanuts, peanut butter or almonds ?
    pluribus: number,//Is it one or many candy in a bag or box ?
    pricepercent: number, //Unit price percentile compared to the rest of the set
    sugarpercent: number, //Percentile of sugar it falls under within the data set
    winpercent: number, //Overall win percentage according to 269,000 matchups
    image: string, //Image represnting the candybar
}