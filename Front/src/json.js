let questions = [
  {
    id: 1,
    question: "How big is your company?",
  },
  {
    id: 2,
    question: "How many users you have?",
  },
  {
    id: 3,
    question: "What was your IT budget last year?",
  },
];

// function getAnswers() {
//   const xhr = new XMLHttpRequest();
//   // xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
//   xhr.open("GET", "http://localhost:8085/questions/listquestions", true);
//   xhr.send();
//   xhr.onreadystatechange = function () {
//     if (xhr.readyState == XMLHttpRequest.DONE) {
//       const arr = JSON.parse(xhr.responseText);
//       arr.forEach((element) => {
//         questions.push(element);
//       });
//     }
//   };
// }
// window.onload = function () {
//   getAnswers();
// };

let processedQuestions = [
  {
    elements: [
      {
        type: "html",
        html: "You are about to start a questionnaire on Business Strategy. <br>Enter your email below and click <b>Start Quiz</b> to begin.",
      },
      {
        type: "text",
        name: "email",
        titleLocation: "hidden",
        isRequired: true,
        validators: [{ type: "email", text: "Value must be an email" }],
      },
    ],
  },
];

questions.forEach((item) => {
  const processedElement = {
    elements: [
      {
        type: "text",
        name: "" + item.id + "",
        title: "" + item.question + "",
        isRequired: true,
      },
    ],
  };

  processedQuestions.push(processedElement);
});

export const json = {
  title: "Blockchain afinity",
  showProgressBar: "bottom",
  firstPageIsStarted: true,
  startSurveyText: "Start Quiz",
  pages: processedQuestions,
  completedHtml: "<h4>Thank you for your answers</h4>",
};
