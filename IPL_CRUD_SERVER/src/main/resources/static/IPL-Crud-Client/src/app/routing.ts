import { PlayerListComponent } from "./players/player-list/player-list.component";
import { AddPlayerComponent } from './players/add-player/add-player.component';
import { TeamListComponent } from './teams/team-list/team-list.component';
import { TeamDetailsComponent } from './teams/team-details/team-details.component';
import { AddTeamComponent } from './teams/add-team/add-team.component';
import { Routes } from '@angular/router';
import { from } from 'rxjs';

export const appRoutes: Routes = [
    { path:'', redirectTo:'/teams', pathMatch:'full', runGuardsAndResolvers:'always'},
    { path:'players', component:PlayerListComponent, runGuardsAndResolvers:'always' },
    { path:'players/edit/:id', component:AddPlayerComponent, runGuardsAndResolvers:'always' },
    { path:'players/add', component:AddPlayerComponent, runGuardsAndResolvers:'always' },
    
    { path:'teams', component:TeamListComponent, children: [
      { path:'edit/:id', component:AddTeamComponent },
      { path:':id/:name', component:TeamDetailsComponent },
      { path:'add', component:AddTeamComponent } 
    ], runGuardsAndResolvers:'always' },
  ];
