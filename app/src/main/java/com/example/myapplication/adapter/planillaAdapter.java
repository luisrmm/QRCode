package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.planilla;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class planillaAdapter extends FirestoreRecyclerAdapter<planilla, planillaAdapter.ViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public planillaAdapter(@NonNull FirestoreRecyclerOptions<planilla> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int position, @NonNull planilla planilla) {
        viewHolder.Cuidad.setText(planilla.getCuidad());
        viewHolder.ID.setText(planilla.getID());
        viewHolder.Nombre.setText(planilla.getNombre());
        viewHolder.Pais.setText(planilla.getPais());
        viewHolder.Salario.setText(planilla.getSalario());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_planilla_single, parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Cuidad, ID, Nombre, Pais, Salario;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Cuidad = itemView.findViewById(R.id.Ciudad);
            ID = itemView.findViewById(R.id.ID);
            Nombre = itemView.findViewById(R.id.Nombre);
            Pais = itemView.findViewById(R.id.Pais);
            Salario = itemView.findViewById(R.id.Salario);
        }
    }
}
