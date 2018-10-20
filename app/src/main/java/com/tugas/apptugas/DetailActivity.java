package com.tugas.apptugas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvGambar, tvJudul, tvIsbn, tvTahun, tvPenerbit, tvKategori, tvJumlah, tvRangkuman;
    RatingBar rbBuku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvGambar=findViewById(R.id.tv_gambar);
        tvJudul=findViewById(R.id.tv_judul);
        tvIsbn=findViewById(R.id.tv_isbn);
        tvTahun=findViewById(R.id.tv_tahun);
        tvPenerbit=findViewById(R.id.tv_penerbit);
        tvKategori=findViewById(R.id.tv_kategori);
        tvJumlah=findViewById(R.id.tv_jumlah);
        tvRangkuman=findViewById(R.id.tv_rangkuman);
        rbBuku=findViewById(R.id.rb_buku);

        long idBuku=getIntent().getLongExtra("idBuku", 0);

        BukuDataSource bukuDataSource = new BukuDataSource(this);
        bukuDataSource.bukaDatabase();
        Buku buku = bukuDataSource.getBuku(idBuku);
        bukuDataSource.tutupDatabase();


        String warna=buku.getWarna();
        String judul=buku.getJudul();
        String isbn=buku.getIsbn();
        String tahun=buku.getTahun();
        String penerbit=buku.getPenerbit();
        String kategori=buku.getKategori();
        String jumlah=buku.getJumlah();
        String rangkuman=buku.getRangkuman();
        Float kualitas=buku.getKualitas();

        tvGambar.setText(warna);
        tvJudul.setText(judul);
        tvIsbn.setText(isbn);
        tvTahun.setText(tahun);
        tvPenerbit.setText(penerbit);
        tvKategori.setText(kategori);
        tvJumlah.setText(jumlah);
        tvRangkuman.setText(rangkuman);
        rbBuku.setRating(kualitas);
    }
}
