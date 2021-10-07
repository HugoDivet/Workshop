package com.example.workshop;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.ViewHolder> {

    LayoutInflater inflater;
    List<NoteContacts> contacts;

    AdapterContact(Context context, List<NoteContacts> contacts) {
        this.inflater = LayoutInflater.from(context);
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public AdapterContact.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_view_contact, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterContact.ViewHolder holder, int position) {
        String prenom = contacts.get(position).getPrenom();
        String nom = contacts.get(position).getNom();
        String relation = contacts.get(position).getRelation();
        holder.textViewPrenom.setText(prenom);
        holder.textViewNom.setText(nom);
        holder.textViewRelation.setText(relation);
        Log.d("test", ""+prenom+" "+nom+" "+relation);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewPrenom,textViewNom,textViewRelation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewPrenom = itemView.findViewById(R.id.textViewPrenom);
            textViewNom = itemView.findViewById(R.id.textViewNom);
            textViewRelation = itemView.findViewById(R.id.textViewRelation);
        }
    }
}
