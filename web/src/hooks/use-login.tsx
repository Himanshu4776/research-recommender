import axios from "axios";
import { LoginObject } from "../shared/constant";

export function UseLogin(
  loginObject: LoginObject,
  baseUrl: any,
  responseCallback: any,
  errorCallback: any
) {
  axios
    .post(`${baseUrl.users}/login`, loginObject)
    .then((response) => {
      return responseCallback(response?.data);
    })
    .catch((error) => {
      return errorCallback(error?.message);
    });
}
