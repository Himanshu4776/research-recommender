import axios from "axios";
import { RegisterObject } from "../shared/constant";

export function UseRegister(
  registerObject: RegisterObject,
  baseUrl: any,
  responseCallback: any,
  errorCallback: any
) {
  axios
    .post(`${baseUrl?.users}`, registerObject)
    .then((response) => {
      return responseCallback(response?.data);
    })
    .catch((error) => {
      return errorCallback(error?.message);
    });
}
