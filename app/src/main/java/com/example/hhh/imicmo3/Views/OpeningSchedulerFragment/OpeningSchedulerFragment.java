package com.example.hhh.imicmo3.Views.OpeningSchedulerFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hhh.imicmo3.Adapters.OpeningSchedulerAdapter;
import com.example.hhh.imicmo3.Entities.OpeningSchedulerEntity;
import com.example.hhh.imicmo3.Presenters.OpeningSchedulerFragmentPresenter;
import com.example.hhh.imicmo3.R;

import java.util.List;

public class OpeningSchedulerFragment extends Fragment implements CallBackOpeningSchedulerFragment {
    private RecyclerView myRcv;
    private OpeningSchedulerAdapter adapter;
    private OpeningSchedulerFragmentPresenter openingSchedulerPresenter;
    private ProgressBar pbOpeningScheduler;


    public OpeningSchedulerFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opening_scheduler,container,false);
        myRcv = view.findViewById(R.id.rvOpeningScheduler);
        pbOpeningScheduler = view.findViewById(R.id.pbOpeningScheduler);
        openingSchedulerPresenter = new OpeningSchedulerFragmentPresenter(this);
        openingSchedulerPresenter.getApiListOpeningScheduler();
        return view;
    }

    @Override
    public void getApiListOpeningSchedulerThanhCong(List<OpeningSchedulerEntity> listOpeningScheduler) {
        pbOpeningScheduler.setVisibility(View.INVISIBLE);
        myRcv.setVisibility(View.VISIBLE);
       myRcv.setLayoutManager(new LinearLayoutManager(getContext()));
        myRcv.setHasFixedSize(true);
        adapter = new OpeningSchedulerAdapter(getActivity(),  listOpeningScheduler);
        myRcv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getApiListOpeningSchedulerThatBai(String sThongBao) {
        Toast.makeText(getActivity(),sThongBao,Toast.LENGTH_SHORT).show();
    }
}
