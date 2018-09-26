package br.com.opet.tds.roomproject_modelo1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import br.com.opet.tds.roomproject_modelo1.R;
import br.com.opet.tds.roomproject_modelo1.model.Filme;

/**
 * Created by Diego on 24/09/2018.
 */

public class FilmeAdapter extends ArrayAdapter<Filme> {
    private int rId;

    public FilmeAdapter(@NonNull Context context, int resource, @NonNull List<Filme> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        View mView = currentView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Filme filme = getItem(position);

        TextView textTitulo = mView.findViewById(R.id.textNomeFilme);
        TextView textGenero = mView.findViewById(R.id.textGeneroFilme);
        TextView textAno = mView.findViewById(R.id.textAnoFilme);
        RatingBar rating = mView.findViewById(R.id.ratingNotaFilme);

        textTitulo.setText(filme.getTitulo().toUpperCase());
        textGenero.setText(filme.getGenero());
        textAno.setText("Ano: " + String.valueOf(filme.getAno_producao()));
        rating.setRating((float)filme.getAvaliacao());

        return mView;
    }
}
