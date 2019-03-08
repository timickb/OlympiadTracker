package com.timickb.olympiadnotifier;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class OlympiadFragment extends Fragment {

    private TextView olTitle;
    private TextView subjectsInfo;
    private TextView classesInfo;
    private TextView dateInfo;
    private TextView orgsInfo;
    private TextView olympiadSite;
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_olympiad, container, false);
        olTitle = view.findViewById(R.id.olTitle);
        subjectsInfo = view.findViewById(R.id.subjectsInfo);
        classesInfo = view.findViewById(R.id.classesInfo);
        dateInfo = view.findViewById(R.id.dateInfo);
        orgsInfo = view.findViewById(R.id.orgsList);
        olympiadSite = view.findViewById(R.id.olympiadLink);

        String title = getArguments().getString("title");
        String classes = Tools.getStringFromClasses(getArguments().getStringArrayList("classes"));
        String subjects = Tools.getStringFromSubjects(getArguments().getStringArrayList("subjects"));
        String date = Tools.getStringFromMonths(getArguments().getString("date_start"), getArguments().getString("date_end"));
        String organizers = new String();
        String link = getArguments().getString("link");
        if(getArguments().getStringArrayList("organizers").size() == 0) {
            organizers = getString(R.string.unknown);
        } else {
            organizers = Tools.getStringFromOrganizers(getArguments().getStringArrayList("organizers"));
        }

        olTitle.setText(title);
        subjectsInfo.setText(subjects);
        classesInfo.setText(classes);
        dateInfo.setText(date);
        orgsInfo.setText(organizers);
        if(link.equals("undefined")) olympiadSite.setText(R.string.unknown);
        else olympiadSite.setText(link);

        return view;
    }
}
