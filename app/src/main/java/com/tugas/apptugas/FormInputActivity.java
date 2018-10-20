package com.tugas.apptugas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class FormInputActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    EditText etJudul, etIsbn, etWarna, etRangkuman;
    Spinner spTahun, spPenerbit;
    RadioGroup rgKategori;
    RadioButton rbBukuAgama, rbBukuKomputer, rbNovel, rbLainlain;
    SeekBar sbJumlah;
    RatingBar rbKualitas;
    Button btnSimpan;

    BukuDataSource bukuDataSource;
    Buku buku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_input);




        etJudul=findViewById(R.id.et_judul);
        etIsbn=findViewById(R.id.et_isbn);
        etWarna=findViewById(R.id.et_warna);
        etRangkuman=findViewById(R.id.et_rangkuman);
        spTahun=findViewById(R.id.sp_tahun);
        spPenerbit=findViewById(R.id.sp_penerbit);
        rgKategori=findViewById(R.id.rg_ketegori);
        rbBukuAgama=findViewById(R.id.rb_buku_agama);
        rbBukuKomputer=findViewById(R.id.rb_buku_komputer);
        rbNovel=findViewById(R.id.rb_novel);
        rbLainlain=findViewById(R.id.rb_lainlain);
        sbJumlah=findViewById(R.id.sb_jumlah);
        sbJumlah.setOnSeekBarChangeListener(this);
        rbKualitas=findViewById(R.id.rb_kualitas);
        btnSimpan=findViewById(R.id.btn_simpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String judul=etJudul.getText().toString();
                String isbn=etIsbn.getText().toString();
                String warna=etWarna.getText().toString();
                String rangkuman=etRangkuman.getText().toString();

                String tahun=spTahun.getSelectedItem().toString();
                String penerbit=spPenerbit.getSelectedItem().toString();

                int radiButtonId = rgKategori.getCheckedRadioButtonId();
                String kategori = null;

                switch (radiButtonId){
                    case R.id.rb_buku_agama:
                        kategori ="Buku agama";
                        break;

                    case R.id.rb_buku_komputer:
                        kategori = "Buku komputer";
                        break;

                    case R.id.rb_novel:
                        kategori = "Novel";
                        break;

                    case R.id.rb_lainlain:
                        kategori = "Lain - lain";
                        break;

                }

                String kualitas= String.valueOf(rbKualitas.getRating());
                String jumlah = String.valueOf(sbJumlah.getAnimation());


                buku=new Buku();
                buku.setJudul(judul);
                buku.setIsbn(isbn);
                buku.setWarna(warna);
                buku.setRangkuman(rangkuman);
                buku.setTahun(tahun);
                buku.setPenerbit(penerbit);
                buku.setKategori(kategori);
                buku.setKualitas(kualitas);
                buku.setJumlah(jumlah);

                boolean statusSimpan;

                bukuDataSource = new BukuDataSource(getApplicationContext());
                bukuDataSource.bukaDatabase();
                statusSimpan=bukuDataSource.addBuku(buku);
                bukuDataSource.tutupDatabase();


                if (statusSimpan){
                    finish();
                    Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "gagal Simpan", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int jumlah, boolean fromUser) {
        Toast.makeText(getApplicationContext(), "Jumlah:"+jumlah,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
