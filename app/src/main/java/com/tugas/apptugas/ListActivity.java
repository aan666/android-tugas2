package com.tugas.apptugas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ListActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {

    BukuItemAdapter bukuItemAdapter;
    BukuDataSource bukuDataSource;
    List<Buku> bukuList;
    ListView lvBuku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lvBuku=findViewById(R.id.lv_buku);
        lvBuku.setOnItemClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //aksi ketika menu di klik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId=item.getItemId();

        switch (menuId) {

            case R.id.menu_input:
                //pindah ke activity forminputactivity
                startActivity(new Intent(this, FormInputActivity.class));
                break;

        }


        return super.onOptionsItemSelected(item);
    }

    protected void onResume() {
        super.onResume();

        bukuDataSource = new BukuDataSource(getApplicationContext());
        bukuDataSource.bukaDatabase();
        bukuList = bukuDataSource.getAllBuku();

        bukuItemAdapter = new BukuItemAdapter(this, bukuList);
        lvBuku.setAdapter(bukuItemAdapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        long idBuku = bukuList.get(position).getId();

        Intent intent= new Intent(this, DetailActivity.class);
        intent.putExtra("idBuku", idBuku);
        startActivity(intent);

    }
}
