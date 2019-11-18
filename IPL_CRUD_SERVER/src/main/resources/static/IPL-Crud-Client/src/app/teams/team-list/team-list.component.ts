import { Component, OnInit } from '@angular/core';
import { Team } from 'src/app/model/team';
import { TeamService } from 'src/app/services/team.service';
import { Router } from '@angular/router';

import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-team-list',
  templateUrl: './team-list.component.html',
  styleUrls: ['./team-list.component.scss']
})
export class TeamListComponent implements OnInit {

  teams:Team[];
  display = 'none';
  tm: any;
  id: number;
  isShow = true;

  constructor(private teamService:TeamService, private router:Router, private http:HttpClient) { }

  ngOnInit() {
    // this.teams = this.teamService.getTeams();
    console.log("innnnnnnnnnnnnnnnnnnnnn");
    this.teamService.getTeams().subscribe(response=>{
      this.teams = response;
      // this.ngOnInit();
    });
  }

  openModal(team: Team){
    this.tm = team;
    this.display = 'block';
  }

  onCloseHandled(){
    this.display = 'none';
  }

  deleteTeam(){
    this.isShow = false;
    console.log("deleting data.......");
    // this.teamService.deleteTeam(this.tm.id, this.tm.team);
    this.teamService.deleteTeam(this.tm.id, this.tm.team).subscribe((data)=>{
      console.log("successsssssssssssssssssssssssss");
    });
    this.display = 'none';
    this.teamService.getTeams().subscribe(response=>{
      this.teams = response;
    });
    this.router.navigate(['/teams']);
  }

  editTeam(team: Team){
    this.isShow = false;
    this.router.navigate(['/teams/edit', team.id]);
  }

  teamDetails(team: Team){
    this.isShow = false;
    this.router.navigate(['/teams', team.id, team.team]);
  }

}
