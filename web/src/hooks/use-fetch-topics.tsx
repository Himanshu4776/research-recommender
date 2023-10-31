import axios from "axios";
import { CheckBoxItem } from "../shared/constant";
import { baseUrls } from "../shared/base-url";
import { useAtom } from "jotai";
import { useState, useEffect } from "react"; // Import useEffect

export function useFetchTopics(responsecallback: any) {
  const [baseUrl] = useAtom(baseUrls);
  const [apiData, setApiData] = useState<string[]>([]);

  useEffect(() => {
    axios
      .get(`${baseUrl.recommended}/topics`)
      .then((response) => {
        setApiData(response?.data);
      })
      .catch((error) => {
        console.log("error", error?.message);
      });
  }, []);

  useEffect(() => {
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

    responsecallback(modifiedData);
  }, [apiData]);
}
