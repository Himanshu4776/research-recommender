import { useState } from "react";
import { FieldValues, useForm } from "react-hook-form";
import { CheckBox } from "./checkbox";

export function Options() {
  const [isCheck, setIsCheck] = useState<boolean>(false);

  const { register, handleSubmit, getValues, setValue } = useForm();

  function clicked(field: number) {
    // setValue(field, !value);
  }

  function onsubmit(data: FieldValues) {
    //
  }

  return (
    <form onSubmit={handleSubmit(onsubmit)}>
      <div className="bg-blue-100 h-screen">
        <div className="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 flex items-center justify-around flex-row gap-2">
          <CheckBox
            key={1}
            isChecked={getValues("check1")?.value === 1 ? true : false}
            id={"check1"}
            name={"check1"}
            label={"Artificail intelligence"}
            register={register}
            disabled={false}
            errorMessage={""}
            onClick={() => {
              clicked(1);
            }}
          />
          <CheckBox
            isChecked={isCheck}
            id={"check2"}
            name={"check2"}
            label={"Machine Learning"}
            register={register}
            disabled={true}
            errorMessage={""}
            onClick={clicked("check2")}
          />
          <CheckBox
            isChecked={isCheck}
            id={"check3"}
            name={"check3"}
            label={"Web dev"}
            register={register}
            disabled={false}
            errorMessage={""}
            onClick={clicked("check3")}
          />
          <CheckBox
            isChecked={isCheck}
            id={"check4"}
            name={"check4"}
            label={"Web"}
            register={register}
            disabled={false}
            errorMessage={""}
            onClick={clicked("check4")}
          />
        </div>
      </div>
    </form>
  );
}
