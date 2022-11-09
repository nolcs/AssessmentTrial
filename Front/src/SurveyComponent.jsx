import React from "react";

import { StylesManager, Model } from "survey-core";
import { Survey } from "survey-react-ui";

import "survey-core/defaultV2.css";
import { json } from "./json";

StylesManager.applyTheme("defaultV2");

function SurveyComponent() {
  const survey = new Model(json);
  let user;
  survey.onValueChanged.add((survey, { name }) => {
    saveQuestion(survey, name);
  });

  function saveQuestion(survey, name) {
    const xhr = new XMLHttpRequest();
    let question = survey.getQuestionByName(name);
    let answerObj = new Object();
    if (name === "email") {
      xhr.open("POST", "http://localhost:8085/users/createUser");

      user = question.value;
      answerObj.email = question.value;
    } else {
      xhr.open("POST", "http://localhost:8085/answers");

      let questionObj = {
        id: question.name,
      };
      let userObj = {
        email: user,
      };

      answerObj.question = questionObj;
      answerObj.answer = question.value;
      answerObj.user = userObj;
    }

    xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
    xhr.send(JSON.stringify(answerObj));
    console.log(answerObj);
  }

  return <Survey model={survey} />;
}

export default SurveyComponent;
