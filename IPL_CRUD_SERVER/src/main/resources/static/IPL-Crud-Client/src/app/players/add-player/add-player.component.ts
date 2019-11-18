import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/model/player';
import { PlayerService } from 'src/app/services/player.service';
import { Router, ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.scss']
})
export class AddPlayerComponent implements OnInit {
  
  // player:Player[];
  player: Player = new Player();
  id:number;
  param:string;



  constructor(private playerService: PlayerService, private router: Router, 
              private activatedRoute:ActivatedRoute, public location: Location) { }

  ngOnInit() {
    this.activatedRoute.url.subscribe(url=>{
      url.forEach(element=>{
        if(element.path === 'edit'){
          this.activatedRoute.params.subscribe(param=>{
            this.id = param['id'];
          })
          // this.team = this.teamService.getTeam(this.id);
          // this.player = this.playerService.getPlayerById(this.id);
          
          this.playerService.getPlayerById(this.id).subscribe(response=>{
            console.log("data : " + response);
            this.player = response;
          }); 
        }else if(element.path === 'add'){
         this.player = new Player();
        // this.player = [];
        }
      });
    });
  }


  savePlayer(){
    console.log("saving....." + this.player);
    this.playerService.savePlayer(this.player);
    this.router.navigate(['/players']);

    // this.router.navigateByUrl('/players', {skipLocationChange: true}).then(() => {
    //   // console.log(decodeURI(this.location.path()));
    //   // this.router.navigate([decodeURI(this.location.path())]);
    //   this.router.navigate(['/players']);
    // });
  }

  // editPlayer() {
  //   console.log("inside edit block");
  //   this.router.navigate(['/add']);
  // }

}
