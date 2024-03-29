import { HttpErrorResponse } from '@angular/common/http';
import { Component, Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { Patient } from '../../interfaces/patient';
import { Practitioner } from '../../interfaces/practitioner';
import { PatientService } from '../../services/patient/patient.service';
import { PractitionerService } from '../../services/practitioner/practitioner.service';

interface User {
  id: number;
  name: string;
  type: string;
}


@Pipe({name: "safeHtml" })
export class SafeHtmlPipe implements PipeTransform{ 

  constructor(private sanitizer: DomSanitizer){}

  transform(value: string){
    return this.sanitizer.bypassSecurityTrustHtml(value);
  }

}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  constructor(private router: Router, private practitionerService: PractitionerService, private patientService: PatientService) { }
  practitioners!: Practitioner[];
  patients: Patient[] = [];

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

  public getPatients(): void{
    this.patientService.getPatients().subscribe(
      (response: Patient[]) => {
        this.patients = response;
        console.log(response);
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  ngOnInit(): void {
    let listePractitioners = this.getPractitioners();
    let listePatients = this.getPatients();
  }

  selectedUser: any = null;
  idUser: any = null;
  isPractitioner: any = 0;

  login() {
    // Vous pouvez implémenter la logique de connexion ici, par exemple, naviguer vers une nouvelle page
    console.log('Utilisateur sélectionné :', this.selectedUser);
    const isPractitioner = 0;
    if(!('diabetesType' in this.selectedUser)) {
      console.log("C'est un practitioner ");
      this.isPractitioner = 1;
    }
    this.router.navigate(['/accueil', this.selectedUser.id, this.isPractitioner]);
  }

  onUserChange() {
    this.idUser = this.selectedUser.id;
    console.log('Variable remplie :', this.idUser);
  }

  
}
