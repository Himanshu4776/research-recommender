import { Home } from "./components/home";
import NavBar from "./components/navbar/navbar";
import "./index.css";

function App() {
  // return <Home />;
  return (
    <div className="">
      <NavBar />
      <div className="py-4 w-full"></div>
      <Home />
    </div>
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
