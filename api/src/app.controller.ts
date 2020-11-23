import {Body, Controller, Delete, Get, Param, Post, Query} from '@nestjs/common';
import { AppService } from './app.service';
import { CandyBar} from "./CandyBar";

@Controller("CandyBars")
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getCandyBars(): CandyBar[]{
    return this.appService.getAllCandyBars();
  }

  @Post()
  createCandyBar(@Body() CandyBar: CandyBar): CandyBar{
    const lclCandyBar: CandyBar = {
      bar: CandyBar["bar"],
      caramel: CandyBar["caramel"],
      chocolate: CandyBar["chocolate"],
      competitorname: CandyBar["competitorname"],
      crispedricewafer: CandyBar["crispedricewafer"],
      fruity: CandyBar["fruity"],
      hard: CandyBar["hard"],
      nougat: CandyBar["nougat"],
      peanutyalmondy:  CandyBar["peanutyalmondy"],
      pluribus: CandyBar["pluribus"],
      pricepercent: CandyBar["pricepercent"],
      sugarpercent: CandyBar["sugarpercent"],
      winpercent: CandyBar["winpercent"]
    };
    this.appService.addCandyBar(lclCandyBar);
    return lclCandyBar;
  }

  @Get('/:competitorname')
  getCandyBar(@Param('competitorname') competitorname: string): CandyBar{
    return this.appService.getCandyBar(competitorname);
  }

  @Delete('/:competitorname')
  deleteCandyBar(@Param('ref') competitorname: string): void{
    this.appService.deleteCandyBar(competitorname);
  }
}
