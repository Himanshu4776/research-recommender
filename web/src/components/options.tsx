import { useState } from "react";
import { FieldValues, useForm } from "react-hook-form";
import { CheckBox } from "./checkbox";
import { useFetchTopics } from "../hooks/use-fetch-topics";
import Modal from "./modal/modal";
import React from "react";

export function Options() {
  const [selectedData, setSelectedData] = useState<number[]>([]);
  const [isModalOpen, setIsModalOpen] = useState(false);

  const modifiedData = useFetchTopics();

  const { register, handleSubmit } = useForm();

  function openModal() {
    setIsModalOpen(true);
  }

  function closeModal() {
    setIsModalOpen(false);
  }

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
    }

    openModal();
    console.log("data: ", data);
  }

  return (
    <>
      <form onSubmit={handleSubmit(onsubmit)}>
        <div className="bg-blue-100 min-h-screen flex flex-col justify-between">
          <div className="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 flex items-center justify-around flex-row gap-2">
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
          <button
            type="submit"
            className="font-nunito px-7 py-2 bg-checkedColor rounded-sm text-white absolute bottom-4 right-4"
          >
            submit
          </button>
        </div>
      </form>
      <div className="h-screen flex items-center justify-center">
        <Modal isOpen={isModalOpen} onClose={closeModal}>
          <h2 className="text-lg font-semibold mb-2">Modal Content</h2>
          <p>This is the content of the modal.</p>
        </Modal>
      </div>
    </>
  );
}

// make login function return the selected topics and user name
