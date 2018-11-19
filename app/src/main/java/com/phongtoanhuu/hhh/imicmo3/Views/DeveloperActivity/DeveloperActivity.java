package com.phongtoanhuu.hhh.imicmo3.Views.DeveloperActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.phongtoanhuu.hhh.imicmo3.Adapters.DeveloperAdapter;
import com.phongtoanhuu.hhh.imicmo3.Entities.DeveloperEntity;
import com.phongtoanhuu.hhh.imicmo3.Presenters.DeveloperActivityPresenter;
import com.phongtoanhuu.hhh.imicmo3.R;

import java.util.List;

public class DeveloperActivity extends AppCompatActivity implements CallBackDeveloperActvity {
    private RecyclerView recyclerView;
    private DeveloperAdapter adapter;
    private DeveloperActivityPresenter developerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        initprsenter();
        initView();

    }

    private void initprsenter() {
        developerPresenter = new DeveloperActivityPresenter(this);
        developerPresenter.loadData();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview_developer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }


    @Override
    public void getApiListDeviloperSuccess(List<DeveloperEntity> listDeveloper) {
        adapter = new DeveloperAdapter(this, listDeveloper);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void getApiListDeviloperFailure(String message) {
        Toast.makeText(DeveloperActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
