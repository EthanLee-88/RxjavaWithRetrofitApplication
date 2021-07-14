package com.example.rxjavawithretrofitapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.rxjavawithretrofitapplication.R;
import com.example.rxjavawithretrofitapplication.databinding.FragmentHomeBinding;
import com.example.rxjavawithretrofitapplication.mvp.MvpPresenter;
import com.example.rxjavawithretrofitapplication.mvp.PresenterResultCallbackInterface;
import com.example.rxjavawithretrofitapplication.retrofit.NetRequestTool;

import org.json.JSONObject;

public class HomeFragment extends Fragment implements PresenterResultCallbackInterface {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void initRes(){  //将MVP三者连接
        NetRequestTool netRequestTool = NetRequestTool.getNetRequestToolInstance();
        MvpPresenter mvpPresenter = new MvpPresenter(netRequestTool , this);
        setPresenter(mvpPresenter);
    }

    private MvpPresenter mMvpPresenter;
    public void setPresenter(MvpPresenter presenter) {
        mMvpPresenter = presenter;
    }

    private void getData(String token , String path){
        if (mMvpPresenter != null) mMvpPresenter.getRequestWithToken(token , path);
    }

    @Override
    public void onPresenterDataResult(JSONObject o) {  //presenter的数据回调

    }

    @Override
    public boolean isAlive() {
        return isAdded();
    }
}