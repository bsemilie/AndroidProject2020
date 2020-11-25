import { Injectable } from '@nestjs/common';
import { CandyBar} from "./CandyBar";
import {CandyBarName} from "./CandyBarName";

@Injectable()
export class UsersService {

    private readonly favorites: Map<string, Array<string> >= new Map();

    getUsersFavorites(userId: string): Array<string>{
        return this.favorites.get(userId);
    }

    addUsersFavorites(userId, candyBarName) {
        let userIdFavorites = [];
        if(this.favorites.get(userId) == null){
            userIdFavorites.push(candyBarName.name);
            this.favorites.set(userId, userIdFavorites);
        }
        else{
            userIdFavorites = this.favorites.get(userId);
            if (userIdFavorites.indexOf(candyBarName.name) > -1) {
                return;
            }
            if(candyBarName.name == null){
                return;
            }
            userIdFavorites.push(candyBarName.name);
            this.favorites.set(userId, userIdFavorites);
        }
        return this.favorites.get(userId);
    }

    deleteUsersFavorites(userId: string, candyBarName: string){
        let userIdFavorites = this.favorites.get(userId);
        let pos = userIdFavorites.indexOf(candyBarName);
        userIdFavorites.splice(pos,1);
        this.favorites.set(userId, userIdFavorites);
    }



}
