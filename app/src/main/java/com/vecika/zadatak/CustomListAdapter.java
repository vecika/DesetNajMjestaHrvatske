package com.vecika.zadatak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vecika.zadatak.Pojo.Mjesto;

import java.util.List;

/**
 * Created by vecika on 05/05/2016.
 */
public class CustomListAdapter extends ArrayAdapter<Mjesto> {

    List<Mjesto> myList;

    public CustomListAdapter(Context _context, List<Mjesto> _mylist) {
        super(_context, R.layout.item_view, _mylist);
        this.myList = _mylist;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(inflater);

        if(view==null)
        view = layoutInflater.inflate(R.layout.item_view, parent, false);

        Mjesto mjesto = getItem(position);

        TextView txtNaziv = (TextView) view.findViewById(R.id.tvNaziv);
        TextView txtTitula = (TextView) view.findViewById(R.id.tvTitula);
        TextView txtZupanija = (TextView) view.findViewById(R.id.tvZupanija);

        txtNaziv.setText(mjesto.getNaziv());
        txtTitula.setText(mjesto.getTitula());
        txtZupanija.setText(mjesto.getZupanija());

        ImageView img = (ImageView)view.findViewById(R.id.imageView);
        img.setImageResource(mjesto.getThumb());

        return view;
    }

}
