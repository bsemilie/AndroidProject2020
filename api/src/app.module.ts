import { Module } from '@nestjs/common';
import { CandyBarsController } from './candyBars.controller';
import { CandyBarsService } from './candyBars.service';
import {UsersController} from "./users.controller";
import {UsersService} from "./users.service";

@Module({
  imports: [],
  controllers: [CandyBarsController, UsersController],
  providers: [CandyBarsService, UsersService],
})
export class AppModule {}
