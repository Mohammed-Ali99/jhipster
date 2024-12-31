import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 700,
  login: 'mAsF',
};

export const sampleWithPartialData: IUser = {
  id: 32055,
  login: 'g5@9AY2v\\`j26iJF\\;ElRm6u\\aY3rr8C\\;ZAzb',
};

export const sampleWithFullData: IUser = {
  id: 845,
  login: 'OOuqK',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
