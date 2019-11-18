import { Component, OnInit } from '@angular/core';
import { Team } from 'src/app/model/team';
import { ActivatedRoute } from '@angular/router';
import { TeamService } from 'src/app/services/team.service';
import { PlayerService } from 'src/app/services/player.service';
import { Player } from 'src/app/model/player';

@Component({
  selector: 'app-team-details',
  templateUrl: './team-details.component.html',
  styleUrls: ['./team-details.component.scss']
})
export class TeamDetailsComponent implements OnInit {

  team: Team[];
  id: number;
  name: string;

  constructor(private router: ActivatedRoute, private teamService: TeamService) { }

  ngOnInit() {
    this.router.params.subscribe(params => {
      this.id = params['id'];
      this.name = params['name'];
      // this.team = this.teamService.getTeam(this.id);
      this.teamService.getTeam(this.id, this.name).subscribe(response=>{
        this.team = response;
        // this.ngOnInit();
      }); 
    });
  } 

}
