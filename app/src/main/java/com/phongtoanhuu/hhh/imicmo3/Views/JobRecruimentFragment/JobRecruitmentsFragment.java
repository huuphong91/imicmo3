package com.phongtoanhuu.hhh.imicmo3.Views.JobRecruimentFragment;

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
import android.widget.Toast;


import com.phongtoanhuu.hhh.imicmo3.Adapters.JobRecruimentAdapter;
import com.phongtoanhuu.hhh.imicmo3.Entities.CareerEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.JobRecruimentEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.LocationEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.TypeOfWorkEntity;
import com.phongtoanhuu.hhh.imicmo3.Presenters.JobRecruimentPresenter;
import com.phongtoanhuu.hhh.imicmo3.R;
import com.phongtoanhuu.hhh.imicmo3.Utilities.Commons;
import com.phongtoanhuu.hhh.imicmo3.Views.MainActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class JobRecruitmentsFragment extends Fragment implements CallBackJobRecruimentFragment, JobRecruimentAdapter.OnClicked {
    private ProgressBar pbJobRecruiment;
    private ListView listView;
    private Spinner noi_lam_viec_spinner,
            nganh_nghe_spinner,
            loai_cv_spinner;
    private ArrayAdapter<String> spinnerAdapter;
    private List<String> typeOfWorkNameList,locationNameList, careerNameList;
    private JobRecruimentPresenter jobRecruimentPresenter;
    private List<JobRecruimentEntity> jobRecruimentEntityList;



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
        this.jobRecruimentEntityList = jobRecruimentEntities;
        pbJobRecruiment.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
        JobRecruimentAdapter jobRecruimentAdapter = new JobRecruimentAdapter(getActivity(), jobRecruimentEntities,this);
        listView.setAdapter(jobRecruimentAdapter);
        jobRecruimentAdapter.notifyDataSetChanged();

    }

    @Override
    public void insertRecruimentThanhCong(String sThongBao) {
        Toast.makeText(getActivity(), sThongBao, Toast.LENGTH_SHORT).show();
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.notifyDataSetChanged();
    }

    @Override
    public void insertRecruimentThatBai(String sThongBao) {
        Toast.makeText(getActivity(), sThongBao, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setOnClickedPostition(int position) {
        String deadline;
        Calendar calendar = Calendar.getInstance();
        deadline =String.valueOf(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.YEAR);
        Commons.JOBRECRUIMENTID = jobRecruimentEntityList.get(position).getJobRecruitmentId();
        jobRecruimentPresenter.insertRecruiment(deadline);
    }









}
