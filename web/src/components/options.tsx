import { useState } from "react";
import { FieldValues, useForm } from "react-hook-form";
import { CheckBox } from "./checkbox";
import { useFetchTopics } from "../hooks/use-fetch-topics";
import Modal from "./modal/modal";
import { CheckBoxItem } from "../shared/constant";

export function Options() {
  const [selectedData, setSelectedData] = useState<number[]>([]);
  const [isModalOpen, setIsModalOpen] = useState(false);

  const { register, handleSubmit } = useForm();

  function openModal() {
    setIsModalOpen(true);
  }

  function closeModal() {
    setIsModalOpen(false);
  }

  const [modifiedData, setModifiedData] = useState<CheckBoxItem[]>([]);
  useFetchTopics((response: CheckBoxItem[]) => {
    setModifiedData(response);
  });

  function checkboxHandler(e: any) {
    let isSelected = e.target.checked;
    let value = parseInt(e.target.value);

    if (isSelected) {
      setSelectedData([...selectedData, value]);
    } else {
      setSelectedData((previousData) => {
        return previousData.filter((id) => {
          return id !== value;
        });
      });
    }
  }

  function onsubmit(data: FieldValues) {
    console.log("selectedData", selectedData);
    if (selectedData.length > 0) {
      // continue submitting
      if (localStorage.getItem("topics") === null) {
        // register the user
      } else {
        // update the topics
      }
    } else {
      openModal();
    }
  }

  return (
    <>
      <form onSubmit={handleSubmit(onsubmit)}>
        <div className="p-4 text-center text-red-500 decoration-4 leading-8 text-3xl">
          <h1>Select your faviourite topics for Research 🧑‍💻</h1>
        </div>
        <div className=" min-h-screen h-full grid grid-cols-6 justify-between">
          <div className="absolute transform grid grid-cols-7 gap-4 max-w-full w-full ">
            {modifiedData.map((item, index) => (
              <CheckBox
                key={index}
                isChecked={selectedData.includes(parseInt(item.id))}
                id={item.id}
                name={item.name}
                value={item.id}
                label={item.label}
                register={register}
                disabled={item.disabled}
                errorMessage={""}
                onChange={checkboxHandler}
              />
            ))}
          </div>
        </div>
        <button
          type="submit"
          className="font-nunito px-7 py-2 bg-checkedColor rounded-sm text-white fixed bottom-4 right-4"
        >
          submit
        </button>
      </form>
      <div className="flex items-center justify-center">
        <Modal isOpen={isModalOpen} onClose={closeModal}>
          <img
            src="../../public/404-error.png"
            alt=""
            height="240px"
            width="240px"
          />
          <h2 className="text-lg font-semibold mb-2">Select Topics first</h2>
          <p>Please select topics before submit.</p>
        </Modal>
      </div>
    </>
  );
}

// make login function return the selected topics and user name

// starting fix
