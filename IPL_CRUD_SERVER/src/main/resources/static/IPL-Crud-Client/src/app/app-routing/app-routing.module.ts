import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { PlayerListComponent } from '../players/player-list/player-list.component';
import { AddPlayerComponent } from '../players/add-player/add-player.component';
import { TeamListComponent } from '../teams/team-list/team-list.component';
import { TeamDetailsComponent } from '../teams/team-details/team-details.component';
import { AddTeamComponent } from '../teams/add-team/add-team.component';



export const appRoutes: Routes = [
  { path:'', redirectTo:'/teams', pathMatch:'full' },
  { path:'players', component:PlayerListComponent },
  { path:'players/add', component:AddPlayerComponent },
  { path:'teams', component:TeamListComponent, children: [
    { path:':id/:name', component:TeamDetailsComponent },
    { path:'add', component:AddTeamComponent },
    { path:'edit/:id', component:AddTeamComponent }
  ]},
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports:[RouterModule]
})


export class AppRoutingModule { }
