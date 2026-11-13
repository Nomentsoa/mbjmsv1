import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EtudiantsService {
  apiUrlEtudiants = `${environment.apiUrl}/etudiants`;
  constructor(private http: HttpClient) {}

  getTestString(): Observable<string> {
    return this.http.get<string>(this.apiUrlEtudiants, { responseType: 'text' as 'json' });
  }
}
