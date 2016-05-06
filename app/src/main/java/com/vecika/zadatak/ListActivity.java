package com.vecika.zadatak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vecika.zadatak.Pojo.Mjesto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vecika on 05/05/2016.
 */

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        final ListView list = (ListView) findViewById(R.id.list);

        final List<Mjesto> mjesta;
        mjesta = new ArrayList<>();
        mjesta.add(new Mjesto(getString(R.string.dubrovnik), getString(R.string.grad), getString(R.string.dubrovacka_neretvanska), R.drawable.dubrovnik,R.drawable.dubrovnik1,R.drawable.dubrovnik2,R.drawable.dubrovnik3,getString(R.string.opis_dubrovnik),0));
        mjesta.add(new Mjesto(getString(R.string.plitvice), getString(R.string.nacionalni_park), getString(R.string.licko_senjska), R.drawable.plitvicenew,R.drawable.plitvicenew1,R.drawable.plitvicenew2,R.drawable.plitvicenew3,getString(R.string.opis_plitivce),0));
        mjesta.add(new Mjesto(getString(R.string.zagorje), getString(R.string.podrucje), getString(R.string.krapinsko_zagorska), R.drawable.hrvatsko_zagorje,R.drawable.hrvatsko_zagorje1,R.drawable.hrvatsko_zagorje2,R.drawable.hrvatsko_zagorje3,getString(R.string.opis_zagorje),0));
        mjesta.add(new Mjesto(getString(R.string.makarska), getString(R.string.grad), getString(R.string.splitsko_dalmatinska), R.drawable.makarska,R.drawable.makarska1,R.drawable.makarska2,R.drawable.makarska3,getString(R.string.opis_makarska),0));
        mjesta.add(new Mjesto(getString(R.string.mljet), getString(R.string.otok), getString(R.string.dubrovacka_neretvanska), R.drawable.mljet,R.drawable.mljet1,R.drawable.mljet2,R.drawable.mljet3,getString(R.string.opis_mljet),0));
        mjesta.add(new Mjesto(getString(R.string.split), getString(R.string.grad), getString(R.string.splitsko_dalmatinska), R.drawable.split,R.drawable.split1,R.drawable.split2,R.drawable.split3,getString(R.string.opis_split),0));
        mjesta.add(new Mjesto(getString(R.string.peljesac), getString(R.string.podrucje), getString(R.string.dubrovacka_neretvanska),R.drawable.poluotok_peljesac,R.drawable.poluotok_peljesac1,R.drawable.poluotok_peljesac2,R.drawable.poluotok_peljesac3,getString(R.string.opis_peljesac),0));
        mjesta.add(new Mjesto(getString(R.string.rovinj), getString(R.string.grad), getString(R.string.istarska), R.drawable.rovinj,R.drawable.rovinj1,R.drawable.rovinj2,R.drawable.rovinj3,getString(R.string.opis_rovinj),0));
        mjesta.add(new Mjesto(getString(R.string.zagreb), getString(R.string.grad), getString(R.string.zagrebacka), R.drawable.zagreb,R.drawable.zagreb1,R.drawable.zagreb2,R.drawable.zagreb3,getString(R.string.opis_zagreb),0));
        mjesta.add(new Mjesto(getString(R.string.kornati), getString(R.string.nacionalni_park), getString(R.string.sibensko_kninska), R.drawable.kornati,R.drawable.kornati1,R.drawable.kornati2,R.drawable.kornati3,getString(R.string.opis_kornati),0));

        if (list != null) {
            list.setAdapter(new CustomListAdapter(this,mjesta));
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i= new Intent(ListActivity.this,DetaljiActivity.class);
                    i.putExtra("thumb", mjesta.get(position).getThumb());
                    i.putExtra("naziv",mjesta.get(position).getNaziv());
                    i.putExtra("titula",mjesta.get(position).getTitula());
                    i.putExtra("zupanija", mjesta.get(position).getZupanija());
                    i.putExtra("slika1",mjesta.get(position).getSlika1());
                    i.putExtra("slika2",mjesta.get(position).getSlika2());
                    i.putExtra("slika3",mjesta.get(position).getSlika3());
                    i.putExtra("opis",mjesta.get(position).getOpis());
                    i.putExtra("rating",mjesta.get(position).getRating());
                    startActivity(i);
                }
            });
        }
    }
}


