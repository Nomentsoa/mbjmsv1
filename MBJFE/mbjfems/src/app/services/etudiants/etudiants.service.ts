import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { EtudiantDetailModel } from '../../components/models/etudiant/etudiantDetailModel.model';

@Injectable({
  providedIn: 'root',
})
export class EtudiantsService {
  apiUrlEtudiants = `${environment.apiUrl}/etudiants`;
  private http = inject(HttpClient);

  getTestString(): Observable<string> {
    return this.http.get<string>(this.apiUrlEtudiants, { responseType: 'text' as 'json' });
  }

  saveNewEtudiant(etudiant: EtudiantDetailModel): Observable<EtudiantDetailModel>{
    console.log('appel saveNewEtudiant dans EtudiantService: ' + etudiant)
    return this.http.post<EtudiantDetailModel>(this.apiUrlEtudiants, etudiant)
  }
}
