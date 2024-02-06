import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Practitioner } from '../../interfaces/practitioner';
import { PractitionerService } from '../../services/practitioner.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})

export class AccueilComponent implements OnInit{
  practitioners!: Practitioner[];
  

  constructor(private router: Router, private route: ActivatedRoute, private practitionerService: PractitionerService) {}

  ngOnInit(): void {
    this.getPractitioners();
    this.route.params.subscribe(params => {
      const userId = params['userId'];
      console.log('ID de l\'utilisateur:', userId);
      // Utilisez l'ID de l'utilisateur comme vous le souhaitez dans votre page de connexion
    });
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