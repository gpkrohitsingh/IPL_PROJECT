import { Team } from './team';

export class Player{
    id:number;
    playerName:string;
    preference:string;
    matchesPlayed:number;
    runs?:number;
    wickets?:number;
    highestScore?:number;
    bestWickets?:number;
    fifties?:number;
    centuries?:number;
    thirties?:number;
    catches?:number;
    stumpings?:number;
    strikeRate:number;
    average?:number;
    foures?:number;
    sixes?:number;
    // teamName?:string;
    team?:Team;
}