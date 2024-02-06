import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from '../../interfaces/patient';
import { Practitioner } from '../../interfaces/practitioner';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  private apiServerUrl = 'http://localhost:8080';
  
  constructor(private http: HttpClient) { }

  public getPatients(): Observable<Practitioner[]>{
    return this.http.get<Patient[]>(this.apiServerUrl+'/patient/all');
  }
}