import { useState } from "react";
import { Home } from "./components/home";
import NavBar from "./components/navbar/navbar";
import "./index.css";

function App() {
  // return <Home />;
  const [password, setPassword] = useState("");
  console.log("submit", password);

  return (
    // <div className="">
    //   <NavBar />
    //   <div className="py-4 w-full"></div>
    //   <Home />
    // </div>\
    <form>
      <input
        type="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        placeholder="enter password"
      />
      <input type="submit" />
    </form>
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
