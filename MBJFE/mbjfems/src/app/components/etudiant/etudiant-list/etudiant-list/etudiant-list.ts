import { Component, OnInit } from '@angular/core';
import { EtudiantsService } from '../../../../services/etudiants/etudiants.service';

@Component({
  selector: 'app-etudiant-list',
  imports: [],
  templateUrl: './etudiant-list.html',
  styleUrl: './etudiant-list.scss',
})
export class EtudiantList implements OnInit {
  constructor(private etudiantsService: EtudiantsService) {}

  ngOnInit(): void {
    this.etudiantsService.getTestString().subscribe((data) => {
      console.log(data);
    });
  }
}
