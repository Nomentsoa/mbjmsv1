import { Component, computed, inject, input, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  ValidatorFn,
  Validators
} from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { EtudiantsService } from '../../../services/etudiants/etudiants.service';
import { EtudiantDetailModel } from '../../../models/etudiant/etudiantDetailModel.model';
import { atLeastOneRequiredValidator } from '../../../utils/atLeastOneRequiredValidator';



@Component({
  selector: 'app-etudiant-ajout-component',
  imports: [FormsModule, ReactiveFormsModule, RouterLink],
  templateUrl: './etudiant-ajout-component.html',
  styleUrl: './etudiant-ajout-component.scss',
})
export class EtudiantAjoutComponent implements OnInit {
  private router = inject(Router);
  private etudiantService = inject(EtudiantsService);
  private numeroRegexp: RegExp = /^0(32|33|34|37|38|39)[0-9]{7}$/;
  private numeroMaTriculRegexp: RegExp = /^(G|F)[-][0-9]{3,7}$/;
  messageErrorParentFormGroup?: string;
  genres = [
    { value: 'GARCON', label: 'Garçon' },
    { value: 'FILLE', label: 'Fille' }
  ]

  photoUrl = 'https://i.pravatar.cc/200?u=new';

  registerForm!: FormGroup;
  parentsFormGroup!: FormGroup;

  ngOnInit() {
    this.parentsFormGroup = new FormGroup({
      nomPere: new FormControl(''),
      telephonePere: new FormControl('', Validators.pattern(this.numeroRegexp)),
      professionPere: new FormControl(''),
      nomMere: new FormControl(''),
      telephoneMere: new FormControl('', Validators.pattern(this.numeroRegexp)),
      professionMere: new FormControl(''),
      isTuteur: new FormControl(false)
    }, { validators: atLeastOneRequiredValidator(['nomPere', 'nomMere'])});


    this.registerForm = new FormGroup({
      matricule: new FormControl('', [Validators.required, Validators.pattern(this.numeroMaTriculRegexp)]),
      nom: new FormControl('', Validators.required),
      prenom: new FormControl('', Validators.required),
      dateDeNaissance: new FormControl('', [
        Validators.required,
        Validators.pattern(
          /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/
        )]),
      sexe: new FormControl(this.genres.at(0)?.value, [Validators.required]),
      addresse: new FormControl('', [Validators.required]),
      parentsFormGroup: this.parentsFormGroup,
      noteSupplementaire: new FormControl('')
    });
  }

  onSubmitFormulaire(){
    console.log("test pour le submit");
     let registerValueForm = this.registerForm.value;
    let parentValueForm = this.parentsFormGroup.value

    let etudiantDetailValue: EtudiantDetailModel = {
      id: registerValueForm.matricule,
      nom: registerValueForm.nom,
      prenom: registerValueForm.prenom,
      dateDeNaissance: registerValueForm.dateDeNaissance,
      sexe: registerValueForm.sexe,
      addresse: registerValueForm.addresse,
      photoProfile: this.photoUrl,
      isActive: true,
      qrCode: "",
      nomPere: parentValueForm.nomPere,
      telephonePere: parentValueForm.telephonePere,
      professionPere: parentValueForm.professionPere,
      nomMere: parentValueForm.nomMere,
      telephoneMere: parentValueForm.telephoneMere,
      professionMere: parentValueForm.professionMere,
      isTuteur: parentValueForm.isTuteur,
      noteSupplementaire:registerValueForm.noteSupplementaire,
    }
    console.log("data => ", etudiantDetailValue );
    this.etudiantService
      .saveNewEtudiant(etudiantDetailValue)
      .subscribe((response) => {
        console.log(response)
      });
  }
}
