import { FieldValues, useForm } from "react-hook-form";
import { InputBox } from "./Input-box";
import { Chrome } from "lucide-react";
import bcrypt from "bcryptjs";
import { LoginObject, hashedSalt } from "../shared/constant";
import { UseLogin } from "../hooks/use-login";
import { useAtom } from "jotai";
import { baseUrls } from "../shared/base-url";

export function Login() {
  const { handleSubmit, register } = useForm();
  const [baseUrl] = useAtom(baseUrls);

  function onSubmit(data: FieldValues) {
    const hasedPassword = bcrypt.hashSync(data["password"], hashedSalt);
    const submitData: LoginObject = {
      email: data["email"],
      password: hasedPassword,
    };

    UseLogin(
      submitData,
      baseUrl,
      (response: boolean) => {
        console.log("response", response);
        if (response === true) {
          localStorage.setItem("email", data["email"]);
        }
      },
      (err: string) => {
        console.log("error", err);
      }
    );
  }

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <div className="font-nunito flex flex-col mx-4">
        <div className="py-2 ">
          <InputBox
            placeholder="Your email"
            iconType="email"
            type="email"
            name="email"
            id="email"
            width="36px"
            label=""
            register={register}
          />
        </div>
        <div className="py-2">
          <InputBox
            placeholder="Your password"
            iconType="password"
            type="password"
            name="password"
            id="password"
            register={register}
            width="36px"
            label={""}
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
