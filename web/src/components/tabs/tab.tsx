import { useState } from "react";
import { TabModels } from "../shared/models/tab";

export function Tab({
  PrimaryComponent,
  primaryTabName,
  SecondaryComponent,
  secondaryTabName,
}: TabModels) {
  const [selectedTab, setSelectedTab] = useState<boolean>(true);

  function renderTabs() {
    if (selectedTab === true) {
      return <PrimaryComponent />;
    } else {
      return <SecondaryComponent />;
    }
  }

  return (
    <div className="flex items-center justify-center">
      <div className="bg-white h-auto m-10 text-center max-w-md items-center justify-center pt-2 pb-5 shadow-lg shadow-slate-300  box-border border-spacing-2 border-solid border-slate-400">
        <div className="flex flex-row pb-5 w-[45%]">
          <div className="pl-2">
            <button
              className={`border-3 font-nunito py-3 px-20 rounded solid ${
                selectedTab === true ? "bg-white" : "bg-slate-100"
              } `}
              onClick={() => {
                setSelectedTab(true);
              }}
              id={primaryTabName}
            >
              {primaryTabName}
            </button>
            <div
              className={`${
                selectedTab === true ? "border-2 border-red-500" : "bg-black"
              }`}
            ></div>
          </div>
          <div className="pr-2">
            <button
              className={`border-3 py-3 px-20 font-nunito rounded  solid ${
                selectedTab === false ? "bg-white" : "bg-slate-100"
              }`}
              onClick={() => {
                setSelectedTab(false);
              }}
              id={secondaryTabName}
            >
              {secondaryTabName}
            </button>
            <div
              className={`${
                selectedTab === false ? "border-2 border-red-500" : "bg-black"
              }`}
            ></div>
          </div>
        </div>
        {renderTabs()}
      </div>
    </div>
  );
}
