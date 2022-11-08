const answersasync = (body) => {
  const answersrequestOptions = {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(body),
  };

  let res = fetch("http://localhost:8081/questions", answersrequestOptions)
    .then((response) => response.json())
    .then((data) => {
      if (data !== undefined) {
        questions.push(data);
      }
    });
};

const questions = [
  {
    id: 1,
    question: "viva",
  },
  {
    id: 2,
    question: "er",
  },
  {
    id: 3,
    question: "beti",
  },
];

let processedQuestions = [
  {
    elements: [
      {
        type: "html",
        html:
          "You are about to start a questionnaire on Business Strategy. <br>Enter your email below and click <b>Start Quiz</b> to begin.",
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

// console.log(processedQuestions);

export const json = {
  title: "Blockchain afinity",
  showProgressBar: "bottom",
  firstPageIsStarted: true,
  startSurveyText: "Start Quiz",
  pages: processedQuestions,
  completedHtml: "<h4>Thank you for your answers</h4>",
  awnsersSubmitHandler,
};
// console.log(json);

let answerArray = [];

const awnsersSubmitHandler = (anwserData) => {
  console.log(anwserData);
  answerArray = anwserData;
  sendAnwsersHandler();
};

const sendAnwsersHandler = () => {
  answerArray.map((item) => {
    let anwserBody = {
      questionid: item.questionid,
      anwser: item.anwser,
    };
    const anwserrequestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(anwserBody),
    };
    console.log(anwserBody);
    let res = fetch("http://localhost:8084/anwsers", anwserrequestOptions)
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
      });
  });
};
