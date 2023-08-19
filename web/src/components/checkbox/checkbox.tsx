import { BadgeCheck } from "lucide-react";
import { FieldValues, UseFormRegister } from "react-hook-form";

export type CheckBoxProps = React.DetailedHTMLProps<
  React.InputHTMLAttributes<HTMLInputElement>,
  HTMLInputElement
> & {
  isChecked: boolean;
  id: string;
  name: string;
  label: string;
  disabled: boolean;
  register: UseFormRegister<FieldValues>;
  errorMessage: string;
};

export function CheckBox(props: CheckBoxProps) {
  const {
    label,
    id,
    isChecked,
    register,
    name,
    disabled,
    errorMessage,
    ...rest
  } = props;
  return (
    <div className="h-auto relative ">
      <input
        id={id}
        type="checkbox"
        className={`appearance-none absolute h-full w-full rounded-[20px] outline-none shadow-black border-solid border-4
         pt-10 border-transparent shadow-md cursor-pointer bg-checkedColor ${
           disabled
             ? "bg-slate-300"
             : isChecked
             ? "bg-checkedColor"
             : "bg-white"
         }`}
        {...register(name || "")}
        disabled={disabled}
        {...rest}
      />
      <label
        htmlFor={id}
        className="flex-row flex relative items-center justify-center bottom-0 gap-2 px-2 h-80% cursor-pointer"
      >
        <div className="py-3">
          <BadgeCheck
            color={disabled ? "#000000" : isChecked ? "#ffffff" : "#000000"}
          />
        </div>
        <h6
          className={`text-lg ${
            disabled
              ? "text-slate-700"
              : isChecked
              ? "text-white"
              : "text-gray-600"
          }`}
        >
          {label}
        </h6>
      </label>
    </div>
  );
}
//change starts
