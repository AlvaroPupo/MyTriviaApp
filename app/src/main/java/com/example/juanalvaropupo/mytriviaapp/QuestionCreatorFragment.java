package com.example.juanalvaropupo.mytriviaapp;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuestionCreatorFragment extends Fragment {

    @BindView(R.id.question_edittext)
    protected EditText questionInput;
    @BindView(R.id.correct_answer_edittext)
    protected EditText correctAnswer;
    @BindView(R.id.first_wrong_answer_edittext)
    protected EditText firstWrongAnswer;
    @BindView(R.id.second_wrong_answer_edittext)
    protected EditText secondWrongAnswer;
    @BindView(R.id.third_wrong_answer_edittext)
    protected EditText thirdWrongAnswer;

    private Callback callback;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_creator, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void attachView(Callback callback) {
        this.callback = callback;
    }

    public static QuestionCreatorFragment newInstance() {

        Bundle args = new Bundle();
        QuestionCreatorFragment fragment = new QuestionCreatorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.go_back_button)
    protected void goBack() {
        getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_holder)).commit();
        }


    @OnClick(R.id.save_question_button)
    protected void saveQuestionClicked() {

        String questionTitle = questionInput.getText().toString();
        String correct = correctAnswer.getText().toString();
        String firstWrong = firstWrongAnswer.getText().toString();
        String secondWrong = secondWrongAnswer.getText().toString();
        String thirdWrong = thirdWrongAnswer.getText().toString();

        if (TextUtils.isEmpty(questionTitle) || TextUtils.isEmpty(correct) || TextUtils.isEmpty(firstWrong) || TextUtils.isEmpty(secondWrong) || TextUtils.isEmpty(thirdWrong)){
            Toast.makeText(getActivity(), "All fields are required", Toast.LENGTH_LONG).show();
        } else {
            Question question = new Question(questionTitle, correct, firstWrong, secondWrong, thirdWrong);
            callback.saveQuestion(question);
            }
    }

    public interface Callback {
        void saveQuestion(Question question);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}
