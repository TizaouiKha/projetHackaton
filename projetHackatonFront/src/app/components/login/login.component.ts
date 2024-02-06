import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Practitioner } from '../../interfaces/practitioner';
import { PractitionerService } from '../../services/practitioner.service';

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
  constructor(private router: Router, private practitionerService: PractitionerService) { }
  practitioners!: Practitioner[];

  public getPractitioners(): void{
    this.practitionerService.getPractitioners().subscribe(
      (response: Practitioner[]) => {
        this.practitioners = response;
        console.log('TEST : ');
        console.log(response);
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  ngOnInit(): void {
    let listePractitioners = this.getPractitioners();
    // console.log('LISTE : ');
    // console.log(listePractitioners);
  }

  users: User[] = [
    { id: 1, name: 'Utilisateur 1' },
    { id: 2, name: 'Utilisateur 2' },
    { id: 3, name: 'Utilisateur 3' }
  ];

  selectedUser: number = 1;
  userId = this.selectedUser;

  login() {
    // Vous pouvez implémenter la logique de connexion ici, par exemple, naviguer vers une nouvelle page
    console.log('Utilisateur sélectionné :', this.selectedUser);
    this.router.navigate(['/accueil', this.userId]);
  }
}
