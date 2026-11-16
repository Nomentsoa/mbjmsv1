import { Component, signal, inject } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';


@Component({
  selector: 'app-menu',
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './menu.html',
  styleUrl: './menu.scss',
})
export class Menu {
  private router = inject(Router)
  mobileOpen = signal(false);
   u = "Admin Laza Nomenosa";

  get initial(): string {

    return this.u;
  }

  toggleMobile(): void {
    this.mobileOpen.update((v) => !v);
  }

  closeMobile(): void {
    this.mobileOpen.set(false);
  }

  logout(): void {
    this.router.navigate(['']);
  }
}
