import { registerLocaleData } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import localeFr from "@angular/common/locales/fr";
import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { careTeam } from '../../interfaces/careTeam';
import { Communication } from '../../interfaces/communication';
import { Patient } from '../../interfaces/patient';
import { Practitioner } from '../../interfaces/practitioner';
import { CareTeamService } from '../../services/careTeam/care-team.service';
import { CommunicationService } from '../../services/communication/communication.service';
import { PatientService } from '../../services/patient/patient.service';
import { PractitionerService } from '../../services/practitioner/practitioner.service';

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
  isPractitioner: any;
  careTeam: any ;
  messages : any[]=[];
  showAllMessages: boolean = true;
  userId:any;
  date: Date;
  time: any;
  practitioner: Practitioner;
  patient: Patient;
  sidebarOuvert: boolean = false;
  
  constructor(private router: Router, private route: ActivatedRoute, private practitionerService: PractitionerService, private patientService: PatientService, private communicationService: CommunicationService, private careTeamService: CareTeamService) {
  }

  ngOnInit(): void {
    registerLocaleData(localeFr, "fr");
    this.date = new Date();
    this.time = "2024-02-01 10:20:20";
    this.getPatients();
    this.route.params.subscribe(params => {
      this.userId = params['userId'];
      this.isPractitioner = params['isPractitioner'];
      console.log('ID de l\'utilisateur:',this.userId);
      return this.isPractitioner;

    });
    this.showMessages();
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

  public getCareTeamBySubjectId(idSubject: number): void{
    this.careTeamService.getCareTeamBySubjectId(idSubject).subscribe(
      (response: careTeam) => {
        this.careTeam = response;
        console.log(this.careTeam);
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  public getPractitionerById(id: number): void{
    this.practitionerService.getPractitionerById(id).subscribe(
      (response: Practitioner) => {
        this.practitioner = response;
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  public getPatientById(id: number): void{
    this.patientService.getPatientById(id).subscribe(
      (response: Patient) => {
        this.patient = response;
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
    if(this.isPractitioner == 1) {
      console.log('Cest un isPractitioner');
      this.getCareTeamBySubjectId(this.selectedPatient.id);
    }
    return this.idPatient;
  }

  showMessages(){
    this.messages = [];
    let msg = {};
    this.getCommunicationsByCareTeamId(10);
    let  nameUser: any;
    nameUser = "test";
    for(let i = 0; i<this.communications.length; i++){
      if(this.communications[i].isEntrePro==null){
        this.getPatientById(this.communications[i].idSender);
        nameUser = this.patient?.firstName +" " + this.patient?.lastName;
      }
      else if(this.communications[i].isEntrePro==1 ||this.communications[i].isEntrePro==0 ){
        this.getPractitionerById(this.communications[i].idSender);
        nameUser = this.practitioner?.firstName +" " + this.practitioner?.lastName;
      }
      msg = {
        content: this.communications[i].textMsg,
        type: this.communications[i].isEntrePro,
        timestamp: this.communications[i].dateReceived,
        name: String = nameUser,
      }
      this.messages.push(msg);
    }
  }

  onAddCommunication(addForm: NgForm): void{
    this.communicationService.addCommunication(addForm.value).subscribe(
      (response: Communication)=>{
        console.log(response);
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
    this.showMessages();
    console.log(this.messages);
  }
  
  toggleMessages(showProOnly: boolean): void {
    this.showAllMessages = !showProOnly;
  }
}
