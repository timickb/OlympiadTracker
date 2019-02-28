package com.timickb.olympiadnotifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static android.content.Context.MODE_PRIVATE;


public class SettingsFragment extends Fragment {
    private Spinner classChooser;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);

        classChooser = view.findViewById(R.id.userClassChooser);
        ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(getContext(), R.array.classes, android.R.layout.simple_spinner_item);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classChooser.setAdapter(classAdapter);
        classChooser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getSelectedItem().toString();
                String class_ = text.split(" ")[0];
                SharedPreferences prefs = getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("class", class_);
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        return view;
    }
}
