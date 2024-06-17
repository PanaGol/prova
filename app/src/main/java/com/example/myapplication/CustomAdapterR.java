package com.example.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapterR  extends RecyclerView.Adapter<CustomAdapterR.ViewHolder> {
    private List<ItemModelR> itemList;
    private Context context;

    public CustomAdapterR(List<ItemModelR> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapterR.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row_item1, parent, false);
        return new CustomAdapterR.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterR.ViewHolder holder, int position) {
        ItemModelR item = itemList.get(position);
        holder.numberTextView.setText(item.getNumber());
        holder.nameTextView.setText(item.getName());
        holder.lutech.setText(item.getLutech());
        holder.ct.setText(item.getCt());

        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Effettua una chiamata
                String phoneNumber = item.getNumber();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    context.startActivity(intent);
                } else {
                    // Richiedi i permessi per effettuare la chiamata
                    ActivityCompat.requestPermissions((L1) context, new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView numberTextView;
        public TextView nameTextView;
        public Button callButton;

        public TextView lutech;
        public TextView ct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            numberTextView = itemView.findViewById(R.id.numberTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            callButton = itemView.findViewById(R.id.callButton);
            ct = itemView.findViewById(R.id.textView4);
            lutech = itemView.findViewById(R.id.textView5);

        }
    }
}