import { atom } from "jotai";

export const baseUrls = atom({
  users: "http://localhost:8080/api/user",
  recommended: "http://localhost:8080/api/recommend",
});
