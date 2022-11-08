import React from "react";

import { StylesManager, Model } from "survey-core";
import { Survey } from "survey-react-ui";

import "survey-core/defaultV2.css";
import "./index.css";
import { json } from "./json";

StylesManager.applyTheme("defaultV2");

function SurveyComponent() {
  const survey = new Model(json);
  let user;
  survey.onValueChanged.add((survey, { name }) => {
    // console.log(`The ${name} question value has changed to ${value}.`);
    saveQuestion(survey, name);
  });

  function saveQuestion(survey, name) {
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8085/users/createUser");
    xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
    let question = survey.getQuestionByName(name);
    let answerObj = new Object();
    if (name == "email") {
      user = question.value;
      answerObj.email = question.value;
    } else {
      let questionObj = new Object();
      let userObj = new Object();
      questionObj.id = question.name;
      answerObj.question = questionObj;
      answerObj.answer = question.value;
      // userObj.id = user;
      // answerObj.user = userObj; GET userId
    }

    console.log(answerObj);
    xhr.send(JSON.stringify(answerObj));
  }

  //   survey.onComplete.add(function(sender, options) {
  //     options.showDataSaving();
  //     const xhr = new XMLHttpRequest();
  //     xhr.open("POST", "your/server/url");
  //     xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
  //     xhr.onload = xhr.onerror = function() {
  //       if (xhr.status == 200) {
  //         options.showDataSavingSuccess();
  //         // options.showDataSavingClear();
  //       } else {
  //         options.showDataSavingError();
  //       }
  //     };

  //     console.log(sender.data);
  //     console.log(JSON.stringify(sender.data));
  //     xhr.send(JSON.stringify(sender.data));
  //   });

  return <Survey model={survey} />;
}

export default SurveyComponent;
