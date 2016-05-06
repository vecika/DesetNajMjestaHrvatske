package com.vecika.zadatak;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

@SuppressWarnings("ConstantConditions")
public class DetaljiActivity extends AppCompatActivity implements View.OnClickListener{

    SharedPreferences prefs;
    private int thumb,slika1,slika2,slika3;
    private TextView tvNaziv,tvTitula,tvZupanija, tvOpis;
    private ImageView slikaVelika, ivSlika1,ivSlika2,ivSlika3;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_detalji);

        prefs = this.getSharedPreferences("ratingBar", Context.MODE_PRIVATE);

        findByViews();

        final String naziv=getIntent().getExtras().getString("naziv");
        String titula = getIntent().getExtras().getString("titula");
        String zupanija = getIntent().getExtras().getString("zupanija");
        thumb = getIntent().getExtras().getInt("thumb");
        slika1 = getIntent().getExtras().getInt("slika1");
        slika2 = getIntent().getExtras().getInt("slika2");
        slika3 = getIntent().getExtras().getInt("slika3");
        String opis = getIntent().getExtras().getString("opis");
        float mjestoRating = getIntent().getExtras().getFloat("rating");

        getSupportActionBar().setTitle(naziv);
        tvNaziv.setText(naziv);
        tvTitula.setText(titula);
        tvZupanija.setText(zupanija);
        tvOpis.setText(opis);
        slikaVelika.setImageResource(thumb);
        ivSlika1.setImageResource(slika1);
        ivSlika2.setImageResource(slika2);
        ivSlika3.setImageResource(slika3);

        switch (naziv) {
            case "Makarska":
                ratingBar.setRating(prefs.getFloat("ratingBarMakarska", mjestoRating));
                break;
            case "Rovinj":
                ratingBar.setRating(prefs.getFloat("ratingBarRovinj", mjestoRating));
                break;
            case "Kornati":
                ratingBar.setRating(prefs.getFloat("ratingBarKornati", mjestoRating));
                break;
            case "Plitvička jezera":
                ratingBar.setRating(prefs.getFloat("ratingBarPlitvice", mjestoRating));
                break;
            case "Hrvatsko zagorje":
                ratingBar.setRating(prefs.getFloat("ratingBarZagorje", mjestoRating));
                break;
            case "Mljet":
                ratingBar.setRating(prefs.getFloat("ratingBarMljet", mjestoRating));
                break;
            case "Split":
                ratingBar.setRating(prefs.getFloat("ratingBarSplit", mjestoRating));
                break;
            case "Poluotok Pelješac":
                ratingBar.setRating(prefs.getFloat("ratingBarPeljesac", mjestoRating));
                break;
            case "Zagreb":
                ratingBar.setRating(prefs.getFloat("ratingBarZagreb", mjestoRating));
                break;
            case "Dubrovnik":
                ratingBar.setRating(prefs.getFloat("ratingBarDubrovnik", mjestoRating));
                break;
        }
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                final float numStars = ratingBar.getRating();
                switch (naziv){
                    case "Dubrovnik":
                        prefs.edit().putFloat("ratingBarDubrovnik", numStars).apply();
                        break;
                    case "Makarska":
                        prefs.edit().putFloat("ratingBarMakarska", numStars).apply();
                        break;
                    case "Kornati":
                        prefs.edit().putFloat("ratingBarKornati", numStars).apply();
                        break;
                    case "Rovinj":
                        prefs.edit().putFloat("ratingBarRovinj", numStars).apply();
                        break;
                    case "Plitvička jezera":
                        prefs.edit().putFloat("ratingBarPlitvice", numStars).apply();
                        break;
                    case "Hrvatsko zagorje":
                        prefs.edit().putFloat("ratingBarZagorje", numStars).apply();
                        break;
                    case "Mljet":
                        prefs.edit().putFloat("ratingBarMljet", numStars).apply();
                        break;
                    case "Split":
                        prefs.edit().putFloat("ratingBarSplit", numStars).apply();
                        break;
                    case "Poluotok Pelješac":
                        prefs.edit().putFloat("ratingBarPeljesac", numStars).apply();
                        break;
                    case "Zagreb":
                        prefs.edit().putFloat("ratingBarZagreb", numStars).apply();
                        break;
                }
            }
        });

        slikaVelika.setOnClickListener(this);
        ivSlika1.setOnClickListener(this);
        ivSlika2.setOnClickListener(this);
        ivSlika3.setOnClickListener(this);

    }

    private void findByViews() {
        tvNaziv = (TextView)findViewById(R.id.tvNaziv);
        tvTitula = (TextView)findViewById(R.id.tvTitula);
        tvZupanija = (TextView)findViewById(R.id.tvZupanija);
        slikaVelika = (ImageView)findViewById(R.id.imageView2);
        ivSlika1 = (ImageView)findViewById(R.id.imageView3);
        ivSlika2 = (ImageView)findViewById(R.id.imageView4);
        ivSlika3 = (ImageView)findViewById(R.id.imageView5);
        tvOpis = (TextView)findViewById(R.id.tvOpis);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        int[] slikeGalerija ={thumb,slika1,slika2,slika3};
        switch(v.getId()) {

            case R.id.imageView2:
                i = new Intent(DetaljiActivity.this,GalerijaActivity.class);

                i.putExtra("slikeGalerija", slikeGalerija);
                i.putExtra("pozicija", 0);
                startActivity(i);
                break;
            case R.id.imageView3:
                i = new Intent(DetaljiActivity.this,GalerijaActivity.class);
                i.putExtra("slikeGalerija", slikeGalerija);
                i.putExtra("pozicija", 1);
                startActivity(i);
                break;
            case R.id.imageView4:
                i = new Intent(DetaljiActivity.this,GalerijaActivity.class);
                i.putExtra("slikeGalerija", slikeGalerija);
                i.putExtra("pozicija", 2);
                startActivity(i);
                break;
            case R.id.imageView5:
                i = new Intent(DetaljiActivity.this,GalerijaActivity.class);
                i.putExtra("slikeGalerija", slikeGalerija);
                i.putExtra("pozicija", 3);
                startActivity(i);
                break;
        }
    }
}
