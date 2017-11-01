package edu.upc.eseiaat.pma.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private int ids_answers[]={ //creem un atribut de la classe
            R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4 // es una taula de 4 caselles amb les respostes
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView text_question = (TextView) findViewById(R.id.text_question); //creem el textview
        text_question.setText(R.string.question_content); //escollim el contingut de la pregunta

        String[] answers = getResources().getStringArray(R.array.answers);//obtenim el array de strings

        for (int i=0; i<ids_answers.length;i++){
            RadioButton rb = (RadioButton) findViewById(ids_answers[i]);
            rb.setText(answers[i]);//iterem sobre la taula
        }

        final int correct_answer = getResources().getInteger(R.integer.correct_answer);//obtenim l'enter de la resposta correcta, posem final perque sigui com una constant

        final RadioGroup group = (RadioGroup) findViewById(R.id.answer_group);//obtenim una referencia del radiogroup

        Button btn_check = (Button) findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
               int id = group.getCheckedRadioButtonId(); //diguem qui esta activat
               int answer= -1; //inicialitzem amb -1 perq estiguin buides les respostes al principi
                for (int i=0;i<ids_answers.length;i++){
                    if(ids_answers[i]==id){//si coincideixen els ints de la taula de respostes i de id
                        answer=i;
                    } //CANVIAR NOMS VARIABLES TOT EL PROGRAMA AMB SHIFT+F6
                }
                if (answer==correct_answer){
                    Toast.makeText(QuizActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();//creem new TOAST
                }else {
                    Toast.makeText(QuizActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();// el 2n param pot ser un int o un string
                }

            }
        });
    }
}
