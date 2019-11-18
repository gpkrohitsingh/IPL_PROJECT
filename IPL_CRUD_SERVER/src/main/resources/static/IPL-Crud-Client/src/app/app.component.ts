import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent{
  title = 'IPL-Crud-Client';

  constructor(private router: Router){}
//   ngOnInit(): void {
//     this.router.routeReuseStrategy.shouldReuseRoute = function(){
//       console.log("1111111111111111111111111");
//       return false;
//    }

//    this.router.events.subscribe((evt) => {
//       if (evt instanceof NavigationEnd) {
//          // trick the Router into believing it's last link wasn't previously loaded
//          this.router.navigated = false;
//          // if you need to scroll back to top, here is the right place
//          window.scrollTo(0, 0);
//          console.log("222222222222222222222222");
//       }
//   });
//   console.log("333333333333333333333333333333");
//  }
}
