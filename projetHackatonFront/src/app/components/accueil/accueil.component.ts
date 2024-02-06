import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Practitioner } from '../../interfaces/practitioner';
import { PractitionerService } from '../../services/practitioner.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})

export class AccueilComponent implements OnInit{
  practitioners!: Practitioner[];
  

  constructor(private router: Router, private practitionerService: PractitionerService) {}

  ngOnInit(): void {
    this.getPractitioners();
  }

  deconnexion() {
    // Effectuer les actions de déconnexion
    // Par exemple, vider le localStorage, supprimer les cookies, etc.

    // Rediriger vers la page de connexion
    this.router.navigate(['/login']);
  }
  
  public getPractitioners(): void{
    this.practitionerService.getPractitioners().subscribe(
      (response: Practitioner[]) => {
        this.practitioners = response;
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }
}