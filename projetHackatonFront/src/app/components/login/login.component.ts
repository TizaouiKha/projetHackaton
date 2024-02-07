import { HttpErrorResponse } from '@angular/common/http';
import { Component, Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { Practitioner } from '../../interfaces/practitioner';
import { PractitionerService } from '../../services/practitioner/practitioner.service';

interface User {
  id: number;
  name: string;
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
  }

  users: User[] = [
    { id: 1, name: 'Utilisateur 1' },
    { id: 2, name: 'Utilisateur 2' },
    { id: 3, name: 'Utilisateur 3' }
  ];

  selectedUser: any = null;
  idUser: any = null;

  login() {
    // Vous pouvez implémenter la logique de connexion ici, par exemple, naviguer vers une nouvelle page
    console.log('Utilisateur sélectionné :', this.selectedUser);
    this.router.navigate(['/accueil', this.selectedUser.id]);
  }

  onUserChange() {
    // Mettre à jour la variable en fonction du choix de la liste déroulante
    this.idUser = this.selectedUser.id;
    console.log('Variable remplie :', this.idUser);
  }

  
}
