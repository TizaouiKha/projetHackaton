import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent {
  constructor(private router: Router) {}

  deconnexion() {
    // Effectuer les actions de déconnexion
    // Par exemple, vider le localStorage, supprimer les cookies, etc.

    // Rediriger vers la page de connexion
    this.router.navigate(['/login']);
  }
}
