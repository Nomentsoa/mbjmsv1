import { Routes } from '@angular/router';
import { EtudiantList } from './components/etudiant/etudiant-list/etudiant-list/etudiant-list';
import { LoadingComponents } from './components/loading-components/loading-components';
import { Menu } from './components/menu/menu';
import { Main } from './components/main/main';
import { EtudiantsService } from './services/etudiants/etudiants.service';
import { EtudiantAjoutComponent } from './components/etudiant/etudiant-ajout-component/etudiant-ajout-component';
import { TableauComponent } from './components/tableau-component/tableau-component';

export const routes: Routes = [
  { path: '', component: LoadingComponents },
  { path: 'main',
    component: Main,
    children: [
      {
        path: 'tableau',
        component: TableauComponent
      },
      {
        path: 'etudiants',
        component: EtudiantList
      },
      {
        path: 'etudiants-ajout',
        component: EtudiantAjoutComponent
      }
    ]
  }
];
