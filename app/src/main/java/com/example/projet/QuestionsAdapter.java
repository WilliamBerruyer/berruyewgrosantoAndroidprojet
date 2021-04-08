package com.example.projet;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.projet.db.DatabaseClient;
import com.example.projet.dbQuestion.Question;


import java.util.List;



public class QuestionsAdapter extends ArrayAdapter<Question> {

    public QuestionsAdapter(Context mCtx, List<Question> taskList) {
        super(mCtx, R.layout.template_questions, taskList);
    }

    /**
     * Remplit une ligne de la listView avec les informations de la multiplication associée
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Récupération de la multiplication
        final Question question = getItem(position);


        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_user, parent, false);

        // Récupération des objets graphiques dans le template

        TextView textViewDesc = (TextView) rowView.findViewById(R.id.textViewDesc);

        //
        textViewDesc.setText(question.getQuestion() );


        // + " "+ question.getBonneRéponse() + " " + question.getFausseRéponseUn() + " " + question.getFausseRéponseDeux()
        return rowView;
    }

}