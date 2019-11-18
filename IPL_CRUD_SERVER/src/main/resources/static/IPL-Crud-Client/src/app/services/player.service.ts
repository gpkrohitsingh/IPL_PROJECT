import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Player } from '../model/player';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) { }

  getPlayersByNoTeam() {
    // return this.http.get<Player[]>('/ipl/players/team/0');
    return this.http.get<Player[]>('/api/players/team/0');
  }

  savePlayer(player: Player) {
    // this.http.post('ipl/players/add', player).subscribe();
    this.http.post('/api/players/save', player).subscribe();
  }
  deletePlayer(id: number): Observable<any> {
    return this.http.get<Player[]>('/api/players/delete/' + id);
  }
  getAllPlayers() {
    // return this.http.get<Player[]>('/ipl/players');
    return this.http.get<Player[]>('/api/players');
  }

  getPlayerByTeam(team:string): Observable<any> {
    return this.http.get<Player[]>('/api/players/' + team);
   }

  getPlayerById(id:number): Observable<any> {
    return this.http.get<Player[]>('/api/players/' + id);
   }
}
