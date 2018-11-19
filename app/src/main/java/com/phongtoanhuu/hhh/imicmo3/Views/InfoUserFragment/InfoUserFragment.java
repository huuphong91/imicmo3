package com.phongtoanhuu.hhh.imicmo3.Views.InfoUserFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.phongtoanhuu.hhh.imicmo3.Adapters.InfoUserAdapter;
import com.phongtoanhuu.hhh.imicmo3.Entities.AccountEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.JobRecruimentEntity;
import com.phongtoanhuu.hhh.imicmo3.Presenters.InfoUserFragmentPresenter;
import com.phongtoanhuu.hhh.imicmo3.R;
import com.phongtoanhuu.hhh.imicmo3.Utilities.Commons;
import com.phongtoanhuu.hhh.imicmo3.Views.SignInActivity.SignInActivity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.phongtoanhuu.hhh.imicmo3.Views.MainActivity.REQUEST_CODE_LOGIN_REGISTER;

public class InfoUserFragment extends Fragment implements View.OnClickListener,CallBackInfoUserFragment {
    private Button showLogin, sign_out;
    private CircleImageView circleImageView;
    private TextView user_logged_in, tv_noRecruitment;
    private RecyclerView recyclerview_danh_sach_da_tuyen_dung;
    private InfoUserFragmentPresenter infoUserFragmentPresenter;
    private InfoUserAdapter infoUserAdapter;
    private AccountEntity accountEntity;


    public InfoUserFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_user,container,false);
        infoUserFragmentPresenter = new InfoUserFragmentPresenter(this);
        circleImageView = view.findViewById(R.id.circleImageView);
        tv_noRecruitment = view.findViewById(R.id.tv_noRecruitment);
        showLogin = view.findViewById(R.id.btnDKDN);
        sign_out = view.findViewById(R.id.btn_sign_out);
        user_logged_in = view.findViewById(R.id.tvUser_Logged_In);
        recyclerview_danh_sach_da_tuyen_dung = view.findViewById(R.id.recyclerview_danh_sach_da_tuyen_dung);

        showLogin.setOnClickListener(this);
        sign_out.setOnClickListener(this);

        return view;
    }






    @Override
    public void onStart() {
        super.onStart();
        loggedInAccount();

    }



    @Override
    public void onClick(View v) {
        if (v.getId() == showLogin.getId()) {
            Intent intent = new Intent(getActivity(), SignInActivity.class);
            startActivityForResult(intent,REQUEST_CODE_LOGIN_REGISTER);
        }
        if (v.getId() == sign_out.getId()) {
            Commons.checkLogin = false;
            Commons.PROFILEID = "";
            Commons.JOBRECRUIMENTID = "";
            tv_noRecruitment.setVisibility(View.INVISIBLE);
            showLogin.setVisibility(View.VISIBLE);
            circleImageView.setVisibility(View.INVISIBLE);
            sign_out.setVisibility(View.INVISIBLE);
            user_logged_in.setVisibility(View.INVISIBLE);
            accountEntity = null;
            recyclerview_danh_sach_da_tuyen_dung.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_LOGIN_REGISTER) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    AccountEntity accountEntity1 = data.getParcelableExtra("Account");
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("Account", accountEntity1);
                    setArguments(bundle);

                }


            }
        }
    }

    @Override
    public void getListRecruimentThanhCong(List<JobRecruimentEntity> recruimentEntities) {
        recyclerview_danh_sach_da_tuyen_dung.setVisibility(View.VISIBLE);
        recyclerview_danh_sach_da_tuyen_dung.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview_danh_sach_da_tuyen_dung.setHasFixedSize(true);
        infoUserAdapter = new InfoUserAdapter(getActivity(), recruimentEntities);
        recyclerview_danh_sach_da_tuyen_dung.setAdapter(infoUserAdapter);
        infoUserAdapter.notifyDataSetChanged();
    }

    @Override
    public void getListRecruimentThatBai(String sThongbao) {
        tv_noRecruitment.setVisibility(View.VISIBLE);
        tv_noRecruitment.setText(sThongbao);

    }

    private void loggedInAccount() {
        if (Commons.checkLogin) {
            if (getArguments() != null) {
                showLogin.setVisibility(View.INVISIBLE);
                circleImageView.setVisibility(View.VISIBLE);
                sign_out.setVisibility(View.VISIBLE);
                user_logged_in.setVisibility(View.VISIBLE);
                Bundle bundle = getArguments();
                accountEntity = bundle.getParcelable("Account");
                assert accountEntity != null;
                user_logged_in.setText(accountEntity.getFullName());
                infoUserFragmentPresenter.getListRecruiment(accountEntity.getProfileId());


            };
        }
    }

    public void notifyDataSetChanged() {
        infoUserFragmentPresenter.getListRecruiment(accountEntity.getProfileId());
        tv_noRecruitment.setVisibility(View.INVISIBLE);
    }
}
