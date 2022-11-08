import React from "react";

import { StylesManager, Model } from "survey-core";
import { Survey } from "survey-react-ui";

import "survey-core/defaultV2.css";
import "./index.css";
import { json } from "./json";

StylesManager.applyTheme("defaultV2");

function SurveyComponent() {
  const survey = new Model(json);

  survey.onComplete.add(function(sender, options) {
    options.showDataSaving();
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "your/server/url");
    xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
    xhr.onload = xhr.onerror = function() {
      if (xhr.status == 200) {
        options.showDataSavingSuccess();
        // options.showDataSavingClear();
      } else {
        options.showDataSavingError();
      }
    };

    console.log(sender.data);
    xhr.send(JSON.stringify(sender.data));
  });

  return <Survey model={survey} />;
}

export default SurveyComponent;
