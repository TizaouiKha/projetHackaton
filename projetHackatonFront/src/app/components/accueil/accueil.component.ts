import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Practitioner } from '../../interfaces/practitioner';
import { PatientService } from '../../services/patient/patient.service';

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
  practitioners: Practitioner[] = [];
  

  constructor(private router: Router, private route: ActivatedRoute, private patientService: PatientService) {}

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
    this.patientService.getPatients().subscribe(
      (response: Practitioner[]) => {
        this.practitioners = response;
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  showPracticioners(){
    let result= "";
    for(let i = 0; i<this.practitioners.length; i++){
      result += "<p>"+ this.practitioners[i].id+" "+ this.practitioners[i].firstName+ " "+this.practitioners[i].lastName+" " + this.practitioners[i]. createdAt+" " + this.practitioners[i].updatesAt+ + this.practitioners[i].isActive+"</div>";
  }
  return result
}
}