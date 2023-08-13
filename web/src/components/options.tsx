import { useState } from "react";
import { useForm } from "react-hook-form";
import { CheckBox } from "./checkbox";

export function Options() {
  const [isCheck, setIsCheck] = useState<boolean>(false);

  const { register } = useForm();

  function clicked() {
    setIsCheck(!isCheck);
  }

  return (
    <div className="bg-blue-100 h-screen">
      <div className="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 flex items-center justify-around flex-row gap-2">
        <CheckBox
          isChecked={isCheck}
          id={"check1"}
          name={"check1"}
          label={"Artificail intelligence"}
          register={register}
          disabled={false}
          errorMessage={""}
          onClick={clicked}
        />
        <CheckBox
          isChecked={isCheck}
          id={"check2"}
          name={"check2"}
          label={"Machine Learning"}
          register={register}
          disabled={true}
          errorMessage={""}
          onClick={clicked}
        />
        <CheckBox
          isChecked={isCheck}
          id={"check3"}
          name={"check3"}
          label={"Web dev"}
          register={register}
          disabled={false}
          errorMessage={""}
          onClick={clicked}
        />
        <CheckBox
          isChecked={isCheck}
          id={"check3"}
          name={"check3"}
          label={"Web"}
          register={register}
          disabled={false}
          errorMessage={""}
          onClick={clicked}
        />
      </div>
    </div>
  );
}
