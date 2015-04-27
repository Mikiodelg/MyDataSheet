package com.platygames.mydatasheet;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
public class TextFragment extends Fragment {
    TextView text,vers;
    private MainActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        activity = (MainActivity)getActivity();
        View view = inflater.inflate(R.layout.text_fragment_2, container, false);
        text= (TextView) view.findViewById(R.id.Sheet);
        vers= (TextView)view.findViewById(R.id.Sheet_Desc);
        change("Inicial","VER: Inicial");
        return view;
    }
    public void change(String txt, String txt1){
        text.setText(txt);
        vers.setText(txt1);
    }
}