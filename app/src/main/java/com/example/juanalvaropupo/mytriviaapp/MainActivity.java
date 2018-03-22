package com.example.juanalvaropupo.mytriviaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /* Main Activity
        add question button
        OnClick goto add question fragment
    Take quiz Button
        OnClick goto quiz fragment
    Delete quiz button
        Alert Dialog
            text: are you sure you want to delete this quiz?
            2 options:
            yes = delete quiz data
            cancel = do nothing

    /* Question Class
        model of a question
            question title
            correct answer
            wrong answer 1
            wrong answer 2
            wrong answer 3
        constructor
            require all items
        getters only
    implement Parceable
            need to research before implementation

    /* Add question fragment
        5 editTexts
        1 button
             OnClick
                check for blank entries
                    dont save
                    task all fields required
                save question
                    Parceable will handle saving
                    Toast question is saved
                    Go back to Main Activity
    /* Quiz Fragment
        1 textview
        4 answer buttons
            OnClick
                if Right answer
                    update textView to correct
                    disable all answer buttons
                if wrong answer
                    update textview to say
                    incorrect the correct answer is [insert correct answer]
                    disable all answer buttons
         1 next button
            OnClick
                if more questions
                    display next question
                    enable answer button
                if no question left
                    go to the back menu
                    display activity

    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
