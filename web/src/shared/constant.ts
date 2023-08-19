export const hashedSalt =
  "$2a$10$ZLhnHxdpHETcxmtEStgpI./Ri1mksgJ9iDP36FmfMdYyVg9g0b2dq";

export interface LoginObject {
  email: string;
  password: string;
}

export interface RegisterObject {
  name: string;
  email: string;
  password: string;
}

export interface CheckBoxItem {
  id: string;
  label: string;
  name: string;
  disabled: boolean;
}
