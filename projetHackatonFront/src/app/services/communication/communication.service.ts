import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Communication } from '../../interfaces/communication';

@Injectable({
  providedIn: 'root'
})
export class CommunicationService {
  private apiServerUrl = 'http://localhost:8080';
  
  constructor(private http: HttpClient) { }

  public getCommunications(): Observable<Communication[]>{
    return this.http.get<Communication[]>(this.apiServerUrl+'/communication/all');
  }

  public getCommunicationsByCareTeamId(idCareTeam: number): Observable<Communication[]>{
    return this.http.get<Communication[]>(this.apiServerUrl+'/communication/find/'+idCareTeam);
  }

  public addCommunication(communication: Communication): Observable<Communication>{
    return this.http.post<Communication>(this.apiServerUrl+'/communication/add', communication);
  }
}
