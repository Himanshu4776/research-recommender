import { CheckBoxItem } from "../shared/constant";

export function useFetchTopics() {
  const apiData = ["artificial", "education", "machine", "learning"];

  let modifiedData: CheckBoxItem[] = [];

  apiData.forEach((item, index) => {
    const valueToModify = {
      id: `${index}`,
      name: `check${item}`,
      label: `${item}`,
      disabled: false,
    };
    modifiedData.push(valueToModify);
  });

  return modifiedData;
}
