import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../../interfaces/patient';
import { PatientService } from '../../services/patient/patient.service';
import {MatSidenavModule} from '@angular/material/sidenav';

@Pipe({name: "safeHtml" })
export class SafeHtmlPipe implements PipeTransform{ 

  constructor(private sanitizer: DomSanitizer){}

  transform(value: string){
    return this.sanitizer.bypassSecurityTrustHtml(value);
  }

}

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})

export class AccueilComponent implements OnInit{
  patients: Patient[] = [];
  

  constructor(private router: Router, private route: ActivatedRoute, private patientService: PatientService) {}

  ngOnInit(): void {
    this.getPatients();
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

 
  
  public getPatients(): void{
    this.patientService.getPatients().subscribe(
      (response: Patient[]) => {
        this.patients = response;
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  showPatients(){
    let result= "";
    for(let i = 0; i<this.patients.length; i++){
      result += "<p>"+ this.patients[i].id+" "+ this.patients[i].firstName+ " "+this.patients[i].lastName+" " +" "+this.patients[i].email+" "+this.patients[i].insulinScheme+" "+this.patients[i].diabetesType+ " " + this.patients[i]. createdAt+" " + this.patients[i].updatesAt+ + this.patients[i].isActive+"</div>";
  }
  return result
}
}