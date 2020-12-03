import {Body, Controller, Delete, Get, Param, Post, Query} from '@nestjs/common';
import {UsersService} from "./users.service";
import {CandyBarName} from "./CandyBarName";


@Controller("users")
export class UsersController {
    constructor(private readonly appService: UsersService) {}

    @Get('/:userId/favorites')
    getUsersFavorites(@Param('userId') userId: string): string[]{
        return this.appService.getUsersFavorites(userId);
    }

    @Post('/:userId/favorites')
    addUsersFavorites(@Param('userId') userId:string, @Body() candyBarName: CandyBarName): string[]{
        return this.appService.addUsersFavorites(userId, candyBarName);
    }

    @Delete('/:userId/favorites/:candyBarName')
    deleteUsersFavorites(@Param('userId') userId, @Param('candyBarName') candyBarName): string[]{
        return this.appService.deleteUsersFavorites(userId, candyBarName);
    }

}
