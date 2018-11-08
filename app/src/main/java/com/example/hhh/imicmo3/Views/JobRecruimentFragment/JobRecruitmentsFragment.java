package com.example.hhh.imicmo3.Views.JobRecruimentFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;


import com.example.hhh.imicmo3.Adapters.JobRecruimentAdapter;
import com.example.hhh.imicmo3.Entities.CareerEntity;
import com.example.hhh.imicmo3.Entities.JobRecruimentEntity;
import com.example.hhh.imicmo3.Entities.LocationEntity;
import com.example.hhh.imicmo3.Entities.TypeOfWorkEntity;
import com.example.hhh.imicmo3.Presenters.JobRecruimentPresenter;
import com.example.hhh.imicmo3.R;
import com.example.hhh.imicmo3.Utilities.Commons;

import java.util.ArrayList;
import java.util.List;

public class JobRecruitmentsFragment extends Fragment implements CallBackJobRecruimentFragment {
    private ProgressBar pbJobRecruiment;
    private ListView listView;
    private Spinner noi_lam_viec_spinner,
            nganh_nghe_spinner,
            loai_cv_spinner;
    private ArrayAdapter<String> spinnerAdapter;
    private JobRecruimentAdapter jobRecruimentAdapter;
    private List<String> typeOfWorkNameList,locationNameList, careerNameList;
    private JobRecruimentPresenter jobRecruimentPresenter;


    public JobRecruitmentsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job_recruitment, container, false);
        listView = view.findViewById(R.id.cong_viec_list);
        noi_lam_viec_spinner = view.findViewById(R.id.noi_lam_viec_spinner);
        nganh_nghe_spinner = view.findViewById(R.id.nganh_nghe_spinner);
        loai_cv_spinner = view.findViewById(R.id.loai_cv_spinner);
        pbJobRecruiment = view.findViewById(R.id.pbJobRecruiment);
        jobRecruimentPresenter = new JobRecruimentPresenter(this);
        jobRecruimentPresenter.getListCareer();
        jobRecruimentPresenter.getListLocation();
        jobRecruimentPresenter.getListTypeOfWork();
        jobRecruimentPresenter.getListJobRecruimentAll();
        return view;
    }

    @Override
    public void getListTypeOfWorkThanhCong(final List<TypeOfWorkEntity> typeOfWorkEntities) {
        typeOfWorkNameList = new ArrayList<>();
        typeOfWorkNameList.add("Tất cả");
        for (TypeOfWorkEntity typeOfWorkEntity : typeOfWorkEntities) {
            typeOfWorkNameList.add(typeOfWorkEntity.getTypeOfWorkName());
        }
        spinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, typeOfWorkNameList);
        loai_cv_spinner.setAdapter(spinnerAdapter);
        loai_cv_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    Commons.TYPEOFWORK_ID = typeOfWorkEntities.get(position - 1).getTypeOfWorkId();

                } else {
                    Commons.TYPEOFWORK_ID = "";
                }
                pbJobRecruiment.setVisibility(View.VISIBLE);
                listView.setVisibility(View.INVISIBLE);
                jobRecruimentPresenter.getListJobRecruimentAll();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void getListCareerThanhCong(final List<CareerEntity> careerEntities) {
        careerNameList = new ArrayList<>();
        careerNameList.add("Tất cả");
        for (CareerEntity careerEntity : careerEntities) {
            careerNameList.add(careerEntity.getCareerName());
        }
        spinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, careerNameList);
        nganh_nghe_spinner.setAdapter(spinnerAdapter);
        nganh_nghe_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    Commons.CAREER_ID = careerEntities.get(position - 1).getCareerId();

                } else {
                    Commons.CAREER_ID = "";
                }
                pbJobRecruiment.setVisibility(View.VISIBLE);
                listView.setVisibility(View.INVISIBLE);
                jobRecruimentPresenter.getListJobRecruimentAll();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void getListLocationThanhCong(final List<LocationEntity> locationEntities) {
        locationNameList = new ArrayList<>();
        locationNameList.add("Tất cả");
        for (LocationEntity locationEntity : locationEntities) {
            locationNameList.add(locationEntity.getLocationName());
        }
        spinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, locationNameList);
        noi_lam_viec_spinner.setAdapter(spinnerAdapter);
        noi_lam_viec_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    Commons.LOCATION_ID = locationEntities.get(position - 1).getLocationId();
                } else {
                    Commons.LOCATION_ID = "";
                }
                pbJobRecruiment.setVisibility(View.VISIBLE);
                listView.setVisibility(View.INVISIBLE);
                jobRecruimentPresenter.getListJobRecruimentAll();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void getListJobRecruimentAllThanhCong(List<JobRecruimentEntity> jobRecruimentEntities) {
        pbJobRecruiment.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
        jobRecruimentAdapter = new JobRecruimentAdapter(getActivity(), jobRecruimentEntities);
        listView.setAdapter(jobRecruimentAdapter);
        jobRecruimentAdapter.notifyDataSetChanged();

    }


}
