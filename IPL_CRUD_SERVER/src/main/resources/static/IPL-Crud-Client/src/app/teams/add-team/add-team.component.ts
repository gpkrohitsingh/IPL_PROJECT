import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Team } from 'src/app/model/team';
import { Player } from 'src/app/model/player';
import { TeamService } from 'src/app/services/team.service';

@Component({
  selector: 'app-add-team',
  templateUrl: './add-team.component.html',
  styleUrls: ['./add-team.component.scss']
})
export class AddTeamComponent implements OnInit {

  team:Team[] = [];
  players:Player[];
  id:number;
  teamFormInput: FormGroup;
  tm: any;
  newTeam: Team;

  constructor(private activatedRoute:ActivatedRoute, 
              private teamService:TeamService,
              private router:Router) { }

  ngOnInit() {
    this.activatedRoute.url.subscribe(url=>{
      url.forEach(element=>{
        if(element.path === 'edit'){
          this.activatedRoute.params.subscribe(param=>{
            this.id = param['id'];
          })
          // this.team = this.teamService.getTeam(this.id);
          this.teamService.getTeam(this.id, '').subscribe(response=>{
            console.log("data : " + response);
            this.team = response;
          }); 
        }else if(element.path === 'add'){
        //  this.team = new Team();
        this.newTeam = new Team();
        }
      });
    });
  }

  saveData(){
    this.tm = this.team;
    this.teamService.saveTeam(this.tm)
     .subscribe(
       data=>console.log("success", data),
       error=>console.log("error", error)
       )
       this.router.navigate(['/teams'], {relativeTo:this.activatedRoute});

      }

    
}
