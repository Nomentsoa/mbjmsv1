import { EtudiantItemListModel } from './etudiantItemList.model';

export interface PagedEtudiantItemListModel {
  currentPage: number;
  totalPages: number;
  pageSize: number;
  etudiantItemListDTOs: Array<EtudiantItemListModel>;
}
