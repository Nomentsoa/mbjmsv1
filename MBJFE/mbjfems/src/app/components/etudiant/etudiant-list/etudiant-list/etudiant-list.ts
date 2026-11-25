import { Component, computed, inject, input, OnInit, output, signal } from '@angular/core';
import { EtudiantsService } from '../../../../services/etudiants/etudiants.service';
import { EtudiantItemListModel } from '../../../../models/etudiant/etudiantItemList.model';
import { environment } from '../../../../../environments/environment';
import { Observable, tap } from 'rxjs';
import { PagedEtudiantItemListModel } from '../../../../models/etudiant/PagedEtudiantItemList.model';
import { AsyncPipe } from '@angular/common';
import { isActive } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-etudiant-list',
  imports: [AsyncPipe, FormsModule],
  templateUrl: './etudiant-list.html',
  styleUrl: './etudiant-list.scss',
})
export class EtudiantList implements OnInit {
  etudiantsService = inject(EtudiantsService);

  currentPage: number = 0;
  totalPage: number = 7;
  recherche: string = '';
  size: number = environment.pageSizeList;
  nombrePageToShow!: number;

  defaultNombrePageToShow = 4;
  pageRestanteToShow = 0;
  sizeLoop = 0;
  multiplePagination = 0;

  pageEtudiantListObservable$!: Observable<PagedEtudiantItemListModel>;
  protected readonly tableauPage = Array;

  filters = [
    { label: 'Inscrits', value: true },
    { label: 'Anciens', value: false },
  ];
  isActiveFilter: boolean = this.filters.at(0)!!.value;

  ngOnInit(): void {
    this.getList();

    this.pageRestanteToShow = this.totalPage - this.defaultNombrePageToShow;
    if(this.totalPage > this.defaultNombrePageToShow)
      this.sizeLoop = this.defaultNombrePageToShow;
    else
      this.sizeLoop = this.totalPage;
  }

  getList() {
    this.pageEtudiantListObservable$ = this.etudiantsService
      .getListEtudiants({
        recherche: this.recherche,
        isActive: this.isActiveFilter!!,
        page: this.currentPage,
        size: this.size,
      })
      .pipe(
        tap((value) => {
         /* this.currentPage = value.currentPage;
          this.totalPage = value.totalPage;*/

          this.pageRestanteToShow = this.totalPage - this.currentPage;
          if(this.pageRestanteToShow > this.defaultNombrePageToShow){

          }

        }),
      );
  }

  onChangeIsActive() {
    this.isActiveFilter = !this.isActiveFilter;
    this.getList();
  }

  doResearch() {
    console.log(this.recherche);
    this.getList();
  }
  onClearResearch(){
    this.recherche = '';
  }

  getPageNumber(page: number){
    this.currentPage = page;
  }
  onPrecedent(){
    if(this.currentPage > 0){
      this.currentPage--;
      if(this.currentPage %  this.defaultNombrePageToShow == (this.defaultNombrePageToShow - 1)){
        this.multiplePagination--;
        this.sizeLoop = this.defaultNombrePageToShow;
      }

    }

  }
  onSuivant(){
    if(this.currentPage < this.totalPage){
      this.currentPage ++;
      if(this.currentPage %  this.defaultNombrePageToShow == 0){
        this.multiplePagination++;
        if((this.totalPage - this.currentPage) > this.defaultNombrePageToShow)
          this.sizeLoop = this.defaultNombrePageToShow;
        else
          this.sizeLoop = this.totalPage - this.currentPage;
      }
    }

  }


}
