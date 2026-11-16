import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loading-components',
  templateUrl: './loading-components.html',
  styleUrl: './loading-components.scss',
})
export class LoadingComponents implements OnInit {
  ngOnInit():void {}

  constructor(private router: Router) {}
  onGoMain() {
    this.router.navigateByUrl("/main/etudiants")
  }
}
