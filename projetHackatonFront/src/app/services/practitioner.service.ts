import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Practitioner } from '../interfaces/practitioner';

@Injectable({
  providedIn: 'root'
})
export class PractitionerService {
  private apiServerUrl = 'http://localhost:8080';
  
  constructor(private http: HttpClient) { }

  public getPractitioners(): Observable<Practitioner[]>{
    return this.http.get<Practitioner[]>(this.apiServerUrl+'/practitioner/all');
  }
}
