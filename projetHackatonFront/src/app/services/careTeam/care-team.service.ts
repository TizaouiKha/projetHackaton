import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { careTeam } from '../../interfaces/careTeam';

@Injectable({
  providedIn: 'root'
})
export class CareTeamService {

  private apiServerUrl = 'http://localhost:8080';
  
  constructor(private http: HttpClient) { }

  public getCareTeamBySubjectId(idSubject: number): Observable<careTeam>{
    return this.http.get<careTeam>(this.apiServerUrl+'/careTeam/find/'+idSubject);
  }
}
