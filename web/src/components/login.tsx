import { useForm } from "react-hook-form";
import { InputBox } from "./Input-box";
import { Chrome } from "lucide-react";

export function Login() {
  const { handleSubmit, register } = useForm();

  function onSubmit() {
    // const submitData = {};
  }

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <div className="font-nunito flex flex-col mx-4">
        <div className="py-2 ">
          <InputBox
            placeholder="Your username or email"
            iconType="username"
            type="text"
            name="username"
            id="username"
            width="36px"
          />
        </div>
        <div className="py-2">
          <InputBox
            placeholder="Your password"
            iconType="password"
            type="password"
            name="password"
            id="password"
            width="36px"
          />
        </div>
        <div className="py-4"></div>
        <div className="flex justify-between">
          <div className="flex">
            <input type="checkbox" id="rememberMe" name="rememberMe" />
            <div className="pl-2">Remember me</div>
          </div>
          <div className="text-blue-500 hover:underline">
            <a href="http://">Forgot your password?</a>
          </div>
        </div>
        <div className="flex-row-reverse flex py-2">
          <button
            type="submit"
            className="font-nunito px-7 py-2 bg-red-500 rounded-sm text-white"
          >
            Login
          </button>
        </div>
        <div className="flex flex-row mt-2">
          <div className="h-px w-1/4 bg-gray-300 mt-2.5"></div>
          <div className="grow text-gray-300">Or connect with</div>
          <div className="h-px w-1/4 bg-gray-300 mt-2.5"></div>
        </div>
        <div className="justify-center flex pt-1">
          <a href="http://">
            <Chrome color="#3b88f6" size={40} />
          </a>
        </div>
      </div>
    </form>
  );
}
