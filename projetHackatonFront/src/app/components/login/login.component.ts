import { Component } from '@angular/core';
import { Router } from '@angular/router';

interface User {
  id: number;
  name: string;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private router: Router) { }
  users: User[] = [
    { id: 1, name: 'Utilisateur 1' },
    { id: 2, name: 'Utilisateur 2' },
    { id: 3, name: 'Utilisateur 3' }
  ];

  selectedUser: number = 1;

  login() {
    // Vous pouvez implémenter la logique de connexion ici, par exemple, naviguer vers une nouvelle page
    console.log('Utilisateur sélectionné :', this.selectedUser);
    this.router.navigate(['/accueil']);
  }
}
