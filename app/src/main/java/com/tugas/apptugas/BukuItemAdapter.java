package com.tugas.apptugas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class BukuItemAdapter extends ArrayAdapter<Buku> {
    private Context context;
    private List<Buku> bukuList;
    LayoutInflater layoutInflater;
    public BukuItemAdapter(Context context, List<Buku> bukus){
        super(context,R.layout.buku_item, bukus);
        this.context=context;
        bukuList=bukus;
        layoutInflater=LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;


        if (view==null){
            view=layoutInflater.inflate(R.layout.buku_item, null);
        }

        TextView tvGambar = view.findViewById(R.id.tv_gambar);
        TextView tvJudul = view.findViewById(R.id.tv_judul);
        TextView tvJenis = view.findViewById(R.id.tv_jenis);
        TextView tvPenerbit = view.findViewById(R.id.tv_penerbit);
        RatingBar rbBuku = view.findViewById(R.id.rb_buku);

        Buku buku=getItem(position);

        tvGambar.setText(buku.getWarna());
        tvJudul.setText(buku.getJudul());
        tvJenis.setText(buku.getKategori());
        tvPenerbit.setText(buku.getPenerbit());
        rbBuku.setRating(buku.getKualitas());
        return view;

    }
}
