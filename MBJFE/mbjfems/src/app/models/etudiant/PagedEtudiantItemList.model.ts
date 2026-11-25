import { EtudiantItemListModel } from './etudiantItemList.model';

export interface PagedEtudiantItemListModel {
  currentPage: number;
  totalPage: number;
  pageSize: number;
  etudiantItemListDTOs: Array<EtudiantItemListModel>;
}
