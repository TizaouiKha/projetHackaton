import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Communication } from '../../interfaces/communication';
import { Patient } from '../../interfaces/patient';
import { CommunicationService } from '../../services/communication/communication.service';
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
  styleUrls: ['./accueil.component.scss']
})

export class AccueilComponent implements OnInit{
  patients: Patient[] = [];
  communications: Communication[]=[];
  selectedPatient: any = null;
  idPatient: any = null;
  isPractitioner: any = 1;
  
  constructor(private router: Router, private route: ActivatedRoute, private patientService: PatientService, private communicationService: CommunicationService) {}

  ngOnInit(): void {
    this.getPatients();
    this.route.params.subscribe(params => {
      const userId = params['userId'];
      this.isPractitioner = params['isPractitioner'];
      console.log('ID de l\'utilisateur:', userId);
      if(this.isPractitioner == 1) {
        console.log('Cest un isPractitioner');
      }
      return this.isPractitioner;

    });
    this.getCommunicationsByCareTeamId(10);
  }

  deconnexion() {
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
  

  public getCommunicationsByCareTeamId(idCareTeam: number): void{
    this.communicationService.getCommunicationsByCareTeamId(idCareTeam).subscribe(
      (response: Communication[]) => {
        this.communications = response;
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  onPatientChange() {
    // Mettre à jour la variable en fonction du choix de la liste déroulante
    this.idPatient = this.selectedPatient.id;
    console.log('Patient sélectionné :', this.idPatient);
    return this.idPatient;
  }

  showPatients(){
    let result= "";
    for(let i = 0; i<this.patients.length; i++){
      // result += "<p>"+ this.patients[i].id+" "+ this.patients[i].firstName+ " "+this.patients[i].lastName+" " +" "+this.patients[i].email+" "+this.patients[i].insulinScheme+" "+this.patients[i].diabetesType+ " " + this.patients[i]. createdAt+" " + this.patients[i].updatesAt+ + this.patients[i].isActive+"</div>";
  }
  return result
}
}