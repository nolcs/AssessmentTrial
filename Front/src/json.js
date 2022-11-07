export const json = {
  title: "Blockchain afinity",
  showProgressBar: "bottom",
  firstPageIsStarted: true,
  startSurveyText: "Start Quiz",
  pages: [
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
        },
      ],
    },
    {
      elements: [
        {
          type: "radiogroup",
          name: "civilwar",
          title: "When was the American Civil War?",
          choices: ["1796-1803", "1810-1814", "1861-1865", "1939-1945"],
        },
      ],
    },
    {
      elements: [
        {
          type: "radiogroup",
          name: "libertyordeath",
          title: 'Whose quote is this: "Give me liberty, or give me death"?',
          choicesOrder: "random",
          choices: [
            "John Hancock",
            "James Madison",
            "Patrick Henry",
            "Samuel Adams",
          ],
        },
      ],
    },
    {
      elements: [
        {
          type: "radiogroup",
          name: "magnacarta",
          title: "What is Magna Carta?",
          choicesOrder: "random",
          choices: [
            "The foundation of the British parliamentary system",
            "The Great Seal of the monarchs of England",
            "The French Declaration of the Rights of Man",
            "The charter signed by the Pilgrims on the Mayflower",
          ],
        },
      ],
    },
  ],
  completedHtml: "<h4>Thank you for your answers.</h4>",
};
