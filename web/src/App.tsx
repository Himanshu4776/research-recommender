import { MutableRefObject, useRef } from "react";
import "./index.css";
import bcrypt from "bcryptjs";
import { baseUrls } from "./shared/base-url";
import axios from "axios";
import { useAtom } from "jotai";
import { Tab } from "./components/tabs";
import { Login } from "./components/login";
import { Register } from "./components/register";
import { Options } from "./components/options";

// SALT should be created ONE TIME upon sign up
const salt = bcrypt.genSaltSync(10);

function App() {
  // const emailInputRef: MutableRefObject<HTMLInputElement | null> = useRef(null);
  // const passwordInputRef: MutableRefObject<HTMLInputElement | null> =
  //   useRef(null);
  // const [baseUrl] = useAtom(baseUrls);

  // function handleLoginForm() {
  //   const email = emailInputRef.current?.value ?? "";
  //   const password = passwordInputRef.current?.value ?? "";
  //   const hashedPassword = bcrypt.hashSync(
  //     password,
  //     "$2a$10$ZLhnHxdpHETcxmtEStgpI./Ri1mksgJ9iDP36FmfMdYyVg9g0b2dq"
  //   ); // hash created previously created upon sign up

  //   // const response = fetch("http://localhost:8080/api/user/login", {
  //   //   method: "POST",
  //   //   headers: {
  //   //     Accept: "application/json",
  //   //     "Content-Type": "application/json",
  //   //   },
  //   //   body: JSON.stringify({
  //   //     email: email,
  //   //     password: hashedPassword,
  //   //   }),
  //   // });

  //   // $2a$10$ZLhnHxdpHETcxmtEStgpI.MhV8WUFQ8XjkJthZ8qbkkHh4FVghVQ2
  //   // $2a$10$ZLhnHxdpHETcxmtEStgpI.MhV8WUFQ8XjkJthZ8qbkkHh4FVghVQ2

  //   axios
  //     .post(`${baseUrl.users}/login`, {
  //       email: email,
  //       password: hashedPassword,
  //     })
  //     .then((response) => {
  //       // console.log(response?.data);
  //       // if (response?.data === true) {
  //       //   localStorage.setItem("username", email);
  //       // }
  //       return response?.data;
  //     });
  // }

  return (
    <Options />
    // <Tab
    //   primaryTabName="login"
    //   PrimaryComponent={Login}
    //   secondaryTabName="register"
    //   SecondaryComponent={Register}
    // />
    // <form>
    //   <input
    //     style={{ padding: "15px", borderRadius: "10px", margin: "10px" }}
    //     ref={emailInputRef}
    //     type="email"
    //     placeholder="Email"
    //   />
    //   <input
    //     style={{ padding: "15px", borderRadius: "10px", margin: "10px" }}
    //     ref={passwordInputRef}
    //     type="password"
    //     placeholder="Password"
    //   />
    //   <button
    //     style={{ padding: "15px", borderRadius: "10px", margin: "10px" }}
    //     onClick={(e) => {
    //       e.preventDefault();
    //       handleLoginForm();
    //     }}
    //     type="submit"
    //   >
    //     Login
    //   </button>
    // </form>
  );
}

export default App;

{
  /* <InputBox
    placeholder="Your username or email"
    iconType="password"
    type="text"
    name="username"
    id="username"
    width="36px"
  /> */
}

// <Tab
//   primaryTabName="login"
//   PrimaryComponent={Login}
//   secondaryTabName="register"
//   SecondaryComponent={Register}
// />

// <Tab
//   primaryTabName="login"
//   PrimaryComponent={Login}
//   secondaryTabName="register"
//   SecondaryComponent={Register}
// />
{
  /* <Options /> */
}
// <div className="">
//   <NavBar />
//   <div className="py-4 w-full"></div>
//   <Home />
// </div>
