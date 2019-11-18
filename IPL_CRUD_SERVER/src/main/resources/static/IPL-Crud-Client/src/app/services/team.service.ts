import { Team } from '../model/team';
import { Injectable } from '@angular/core';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class TeamService {
  // data: Data = new Data();
  teams:Team[] = [];
  basic: '';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };
  

  constructor(private http:HttpClient) {
    var headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': this.basic });
    var options = { headers: headers };
    // this.data.rcb.players = [this.data.sachin, this.data.vk];
    // this.teams = [this.data.rcb, this.data.mi];
   }

   public getTeams(): Observable<any> {
    return this.http.get<Team[]>('/api/teams');
  }
  
  getTeam(id:number, team:string): Observable<any> {
    if(team === ''){
      return this.http.get<Team[]>('/api/teams/' + id);
    } else{
      return this.http.get<Team[]>('/api/teams/' + id +'/' + team);
     }
    }

   saveTeam(team: Team) : Observable<Team> {
    return this.http.post<any>('/api/teams/save',  team);
    
  }

  deleteTeam(id: number, team: string): Observable<any> {
    let api = '/api/teams/delete/' + id +'/' + team;
    return this.http.get<Team[]>(api);
  }
}
