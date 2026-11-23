export interface EtudiantDetailModel {
  id?: string;
  nom: string;
  prenom: string;
  dateDeNaissance: string;
  sexe: string;
  addresse: string;
  photoProfile?: string;
  qrCode?: string;
  nomPere?: string;
  telephonePere?: string;
  professionPere?: string;
  nomMere?: string;
  telephoneMere?: string;
  professionMere?: string;
  isTuteur: boolean;
  noteSupplementaire?: string;
}
