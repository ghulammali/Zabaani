package com.example.zabaani;

public class MCQ_Question_Library {
    private String[] mQuestions = new String[]{
            "میرے پاس ایک ٹوپی ہے . اس جملے میں ٹوپی  ہے:",
            "یہ ایک خرگوش ہے. اس جملے میں خرگوش کیا ہے:",
            "وہ کرکٹ کھیل رہے ہیں. اس جملے میں فعل کیا ہے:",
            "گاڑی کے کتنے پہیے ہوتے ہیں",
            "ان میں کونسا پھل ہے:",
            "گاڑی کے کتنے پہیے ہوتے ہیں",
            "میرے پاس ایک ٹوپی ہے . اس جملے میں ٹوپی  ہے:",
            "وہ کرکٹ کھیل رہے ہیں. اس جملے میں فعل کیا ہے:",
            "ان میں کونسا پھل ہے:"


    };
    private String[][] mChoices = {
            {"فعل", "اسم", "حرف", "مصدر"},
            { "اسم","فعل", "حرف", "مصدر"},
            {"وہ", "ہیں", "کرکٹ", "کھیل"},
            {"ایک", "دو", "تین", "چار"},
            {"کریلا", "آلو", "سیب", "ٹوپی"},
            {"ایک", "دو", "تین", "چار"},
            {"فعل", "اسم", "حرف", "مصدر"},
            {"وہ", "ہیں", "کرکٹ", "کھیل"},
            {"کریلا", "آلو", "سیب", "ٹوپی"}


    };
    private String[] mCorrectAnswers = {"اسم", "اسم", "کھیل", "چار","سیب","چار","اسم","کھیل","سیب"};

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }
    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }
    public String getChoice3(int a) {
        return mChoices[a][2];
    }
    public String getChoice4(int a) {
        return mChoices[a][3];
    }
    public String getCorrectAnswer(int a){
        return mCorrectAnswers[a];
    }


}
