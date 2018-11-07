package com.example.hhh.imicmo3.Views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hhh.imicmo3.R;

public class IntroducesFragment extends Fragment {
    private TextView introduces_content;
    public IntroducesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_introduces,container,false);
        introduces_content = view.findViewById(R.id.introduces_content);
        setContent();
        return view;
    }

    private void setContent() {
        introduces_content.setText(Html.fromHtml(getString(R.string.Introduces_Contents)));
    }
}
