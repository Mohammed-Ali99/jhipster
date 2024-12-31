import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '9e58df31-1986-4023-b0cf-5ab3e36bec24',
};

export const sampleWithPartialData: IAuthority = {
  name: '0cb0aff0-d559-4ed5-9f00-588c123f4be6',
};

export const sampleWithFullData: IAuthority = {
  name: 'bcff4eae-13bc-457d-9669-b1f9dbba4c2a',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
