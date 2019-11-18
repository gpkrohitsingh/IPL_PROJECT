import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './nav/header/header.component';
import { FooterComponent } from './nav/footer/footer.component';
import { TeamListComponent } from './teams/team-list/team-list.component';
import { TeamDetailsComponent } from './teams/team-details/team-details.component';
import { AddTeamComponent } from './teams/add-team/add-team.component';
import { DashboardDockComponent } from './teams/dashboard-dock/dashboard-dock.component';
import { PlayerListComponent } from './players/player-list/player-list.component';
import { AddPlayerComponent } from './players/add-player/add-player.component';
import { Routes, RouterModule } from '@angular/router';
import { AngularFontAwesomeModule } from 'angular-font-awesome'
import { appRoutes } from './routing';
import { Team } from './model/team';
import { Player } from './model/player';
import { from } from 'rxjs';
import { HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    TeamListComponent,
    TeamDetailsComponent,
    AddTeamComponent,
    DashboardDockComponent,
    PlayerListComponent,
    AddPlayerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    AngularFontAwesomeModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'My-Xsrf-Cookie',
      headerName: 'My-Xsrf-Header',
    }),
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
