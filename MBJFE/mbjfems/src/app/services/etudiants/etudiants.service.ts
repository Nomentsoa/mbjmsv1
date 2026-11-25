import { inject, Injectable, signal } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { EtudiantDetailModel } from '../../models/etudiant/etudiantDetailModel.model';
import { EtudiantItemListModel } from '../../models/etudiant/etudiantItemList.model';
import { PagedEtudiantItemListModel } from '../../models/etudiant/PagedEtudiantItemList.model';

@Injectable({
  providedIn: 'root',
})
export class EtudiantsService {
  apiUrlEtudiants = `${environment.apiUrl}/etudiants`;
  private http = inject(HttpClient);

  private etudiantsSignal = signal<EtudiantItemListModel[]>([]);
  readonly etudiants = this.etudiantsSignal.asReadonly();


  saveNewEtudiant(etudiant: EtudiantDetailModel): Observable<EtudiantDetailModel>{
    console.log('appel saveNewEtudiant dans EtudiantService: ' + etudiant)
    return this.http.post<EtudiantDetailModel>(this.apiUrlEtudiants, etudiant)
  }


  getListEtudiants(paged: { recherche: string, isActive: boolean, page: number, size: number }):Observable<PagedEtudiantItemListModel>{
    console.log('call pagedListEtudiant');
    let params = new HttpParams()
      .set('recherche', paged.recherche)
      .set('isActive', paged.isActive)
      .set('page', paged.page)
      .set('size', paged.size);

    return this.http.get<PagedEtudiantItemListModel>(this.apiUrlEtudiants, { params: params });

  }

}
