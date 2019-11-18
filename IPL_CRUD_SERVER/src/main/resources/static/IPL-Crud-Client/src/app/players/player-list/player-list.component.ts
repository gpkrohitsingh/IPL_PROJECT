import { Component, OnInit, Output, EventEmitter, OnDestroy } from '@angular/core';
import { Team } from 'src/app/model/team';
import { TeamService } from 'src/app/services/team.service';
import { Player } from 'src/app/model/player';
import { PlayerService } from 'src/app/services/player.service';
import { Router, NavigationEnd } from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.scss']
})
export class PlayerListComponent implements OnInit, OnDestroy {
  
  navigationSubscription;
  teams:Team[] = [];
  players:Player[] = [];
  display = 'none';
  player: any;

  constructor(private teamService:TeamService, 
              private playService:PlayerService,
              private router:Router,
              public location: Location) { 
                this.navigationSubscription = this.router.events.subscribe((e:any)=>{
                  if(e instanceof NavigationEnd){
                    this.fetchDate();
                  }
                });
              }

  ngOnInit() {
  // console.log("plllllllllllllllllllllllllll");
  //   this.playService.getAllPlayers().subscribe(Response=>{
  //     this.players = Response;
  //     // this.ngOnInit();
  //   })
  }

  fetchDate() {
    this.playService.getAllPlayers().subscribe(Response=>{
      this.players = Response;
    })
  }

  ngOnDestroy(): void {
    console.log("destroyyy");
    if(this.navigationSubscription){
      this.navigationSubscription.unsubscribe();
    }
  }

  editPlayer(player: Player){
    this.router.navigate(['/players/edit', player.id]);
  }

  deletePlayer(){
    this.playService.deletePlayer(this.player.id).subscribe((data)=>{
      console.log("successsssssssssssssssssssssssss");
    });
    this.display = 'none';
    this.playService.getAllPlayers().subscribe(Response=>{
      this.players = Response;
    })
    this.router.navigate(['/players']);
  }

  openModal(player){
    this.player = player;
    this.display = 'block';
  }

  onCloseHandled(){
    this.display = 'none';
  }
}
