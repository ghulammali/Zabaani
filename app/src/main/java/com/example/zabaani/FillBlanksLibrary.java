package com.example.zabaani;

public class FillBlanksLibrary {

    private String[] mQuestions = new String[]{
            "سورج _____ میں غروب ہوتا ہے.",
            "ایک ہفتے میں _____ دن ہوتے ہیں.",
            "_____ ایک خوبصورت شہر ہے",
            "ایک درجن انڈوں میں _____ انڈے ہوتے ہیں.",
            "کیلے کا رنگ _____ ہوتا ہے.",
            "ایک ہفتے میں _____ دن ہوتے ہیں."
    };
    private String[][] mChoices = {
            {"مشرق" ,"مغرب" ,"شمال" ,"جنوب"},
            {"تین", "چار", "سات" ,"چھے"},
            {"امریکہ", "انڈیا" ,"سندھ" ,"لاہور"},
            {"دس", "بارہ", "چھے", "چار"},
            {"سرخ","سبز","سفید","پیلا"},
            {"تین", "چار", "سات" ,"چھے"}
    };
    private String[] mCorrectAnswers = {"مغرب", "سات", "لاہور", "بارہ", "پیلا","سات"};

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
