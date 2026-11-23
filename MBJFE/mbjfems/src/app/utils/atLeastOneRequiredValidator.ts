import { AbstractControl, FormGroup, ValidationErrors, ValidatorFn } from '@angular/forms';

export function atLeastOneRequiredValidator(controlNames?: string[]): ValidatorFn {
  return (group: AbstractControl): ValidationErrors | null => {
    const formGroup = group as FormGroup;
    const keys = controlNames ?? Object.keys(formGroup.controls);

    const hasAtLeastOneValue = keys.some((key) => {
      const value = formGroup.get(key)?.value;
      return value !== null && value !== undefined && String(value).trim() !== '';
    });

    return hasAtLeastOneValue ? null : { atLeastOneRequired: true };
  };
}
