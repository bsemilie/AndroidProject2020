import {Body, Controller, Delete, Get, Param, Post, Query} from '@nestjs/common';
import { AppService } from './app.service';
import { ChocolateBar} from "./ChocolateBar";

@Controller("chocolateBars")
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getChocolateBars(@Query('company') company: string): ChocolateBar[]{
    if(company)
      return this.appService.getChocolateBarsOf(company);
    return this.appService.getAllChocolateBars();
  }

  @Post()
  createChocolateBar(@Body() chocolateBar: ChocolateBar): ChocolateBar{
    const lclChocolateBar: ChocolateBar = {
      company: chocolateBar["company"],
      name: chocolateBar["name"],
      date: chocolateBar["date"],
      cocoa_percent: chocolateBar["cocoa_percent"],
      company_location: chocolateBar["company_location"],
      rating: chocolateBar["rating"],
      bean_origin: chocolateBar["bean_origin"],
      bean_type: chocolateBar["bean_type"],
      ref:  chocolateBar["ref"]
    };
    this.appService.addChocolateBar(lclChocolateBar);
    return lclChocolateBar;
  }

  @Get('/:ref')
  getChocolateBar(@Param('ref') ref: string): ChocolateBar{
    return this.appService.getChocolateBar(ref);
  }

  @Delete('/:ref')
  deleteChocolateBar(@Param('ref') ref: string): void{
    this.appService.deleteChocolateBar(ref);
  }
}
