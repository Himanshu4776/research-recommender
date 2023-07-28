import { KeyRound, Mail, User2 } from "lucide-react";
import {
  DeepMap,
  FieldError,
  FieldValues,
  Path,
  RegisterOptions,
  UseFormRegister,
} from "react-hook-form";

export type InputBoxProps = React.DetailedHTMLProps<
  React.InputHTMLAttributes<HTMLInputElement>,
  HTMLInputElement
> & {
  placeholder: string;
  iconType: any;
  name: string;
  type: string;
  width: string;
  id: string;
  label: Path<FieldValues>;
  register: UseFormRegister<FieldValues>;
  inputPattern?: RegisterOptions;
  error?: DeepMap<FieldValues, FieldError>;
};

export function InputBox(props: InputBoxProps) {
  const {
    label,
    width,
    iconType,
    id,
    disabled,
    type,
    placeholder,
    inputPattern,
    register,
    name,
    error,
    ...rest
  } = props;
  return (
    <div className="h-10 flex flex-row border-solid border hover:border-2 border-black">
      <div className="m-2">
        {iconType === "password" ? (
          <KeyRound />
        ) : iconType === "email" ? (
          <Mail />
        ) : (
          <User2 />
        )}
      </div>
      <input
        style={{
          outline: "none",
        }}
        placeholder={placeholder}
        width={width}
        type={type}
        id={id}
        {...register(name || "", inputPattern)}
        {...rest}
      />
    </div>
  );
}
