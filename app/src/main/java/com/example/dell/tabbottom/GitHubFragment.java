package com.example.dell.tabbottom;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dell.tabbottom.Object.AdapterListView;
import com.example.dell.tabbottom.Object.ResultSearch;
import com.example.dell.tabbottom.Retrofit.ApiService;
import com.example.dell.tabbottom.Retrofit.ObjectRe.Example;
import com.example.dell.tabbottom.Retrofit.ObjectRe.Item;
import com.example.dell.tabbottom.Retrofit.RetroClient;
import com.example.dell.tabbottom.Retrofit.Util.InternetConnection;
import com.example.dell.tabbottom.RetrofitGitHub.Object.AdapterGt.AdapterGit;
import com.example.dell.tabbottom.RetrofitGitHub.Object.ObjectUser.UserResult;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dell on 08/12/2016.
 */
public class GitHubFragment extends Fragment implements AdapterView.OnItemClickListener {

    @Bind(R.id.lvListUser)
    ListView listSearch;


    private String position;
    private ArrayList<UserResult> arrResult;

    private List<com.example.dell.tabbottom.RetrofitGitHub.Object.Item> arrData= new ArrayList<>();
    private List<com.example.dell.tabbottom.RetrofitGitHub.Object.Item> categories= new ArrayList<>();

    public static Fragment newInstance(Context context) {
        PostsFragment f = new PostsFragment();
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_github_user, null);
        setUpView(root);
        return root;
    }

    private void setUpView(ViewGroup root){
        ButterKnife.bind(this, root);
        getDataApi();

//        setDataSearch();
//		setUPList();
    }


    private void getDataApi(){

        if (InternetConnection.checkConnection(getContext())) {
            final ProgressDialog dialog;

            dialog = new ProgressDialog(getContext());
            dialog.setTitle("Wait a minute");
            dialog.setMessage("Loading....");
            dialog.show();
            com.example.dell.tabbottom.RetrofitGitHub.Object.Util.ApiService apiService = com.example.dell.tabbottom.RetrofitGitHub.Object.Util.RetroClient.getApiService();

            Call<com.example.dell.tabbottom.RetrofitGitHub.Object.Example> dataListCall = apiService.getMyJSON();

            Log.e("ok", "ok");

            dataListCall.enqueue(new Callback<com.example.dell.tabbottom.RetrofitGitHub.Object.Example>() {
                @Override
                public void onResponse(Call<com.example.dell.tabbottom.RetrofitGitHub.Object.Example> call, Response<com.example.dell.tabbottom.RetrofitGitHub.Object.Example> response) {
                    if (response.isSuccessful()) {
                        dialog.dismiss();
                        arrData = response.body().getItems();
                        Log.e("size arrData: ", arrData.size() + "");
                        for (int i = 0; i < arrData.size(); i++) {
                            Log.e("onResponse", arrData.get(i).getId() + arrData.get(i).getScore() + "");
//                          Log.e("onResponse", arrData.get(i).getSnippet().getThumbnails().getMedium().getUrl());
                            Log.e("onResponse",arrData.get(i).getAvatarUrl()+"");
                        }

                        setDataSearch();
                    }
                }

                @Override
                public void onFailure(Call<com.example.dell.tabbottom.RetrofitGitHub.Object.Example> call, Throwable t) {
                    Log.e("onFailure", "Failure");
                    dialog.dismiss();
                    Toast.makeText(getContext(), "Can not loading data", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            Toast.makeText(getContext(), "No internet connection!", Toast.LENGTH_SHORT).show();
        }
    }

    private void setDataSearch(){
        arrResult= new ArrayList<>();

        for (int i=0;i<arrData.size();i++){
            UserResult userResult= new UserResult(arrData.get(i).getAvatarUrl(),arrData.get(i).getLogin(),arrData.get(i).getScore()+"");
            arrResult.add(userResult);
        }

        AdapterGit adapterListView= new AdapterGit(getContext(),android.R.layout.simple_list_item_1,arrResult);
        listSearch.setAdapter(adapterListView);
        listSearch.setOnItemClickListener(this);

    }

    void setUPList(){
//		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//		CommonRecycleAdapter adapter = new CommonRecycleAdapter(createItemList());
//		recyclerView.setAdapter(adapter);
    }

    private List<String> createItemList() {
        List<String> itemList = new ArrayList<>();
        for(int i=0;i<30;i++) {
            itemList.add("Item "+i);
        }
        return itemList;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}

