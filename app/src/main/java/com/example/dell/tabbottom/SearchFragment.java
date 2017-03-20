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
public class SearchFragment extends Fragment implements AdapterView.OnItemClickListener {

    @Bind(R.id.lvList)
    ListView listSearch;


    private String position;
    private ArrayList<ResultSearch> arrResult;

    private List<Item> arrData= new ArrayList<>();
    private List<Item> categories= new ArrayList<>();

    public static Fragment newInstance(Context context) {
        PostsFragment f = new PostsFragment();
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_search, null);
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
            ApiService apiService = RetroClient.getApiService();

            Call<Example> dataListCall = apiService.getMyJSON();

            Log.e("ok", "ok");

            dataListCall.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    if (response.isSuccessful()) {
                        dialog.dismiss();
                        arrData = response.body().getItems();
                        Log.e("size arrData: ", arrData.size() + "");
                        for (int i = 0; i < arrData.size(); i++) {
                            Log.e("onResponse", arrData.get(i).getKind() + arrData.get(i).getEtag() + "");
                            Log.e("onResponse", arrData.get(i).getSnippet().getThumbnails().getMedium().getUrl());
                        }

                        setDataSearch();
                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {
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
        ResultSearch resultSearch1=new ResultSearch(arrData.get(0).getSnippet().getTitle(),arrData.get(0).getSnippet().getDescription(),arrData.get(0).getSnippet().getThumbnails().getMedium().getUrl());
        ResultSearch resultSearch2=new ResultSearch(arrData.get(1).getSnippet().getTitle(),arrData.get(1).getSnippet().getDescription(),arrData.get(1).getSnippet().getThumbnails().getMedium().getUrl());
        ResultSearch resultSearch3=new ResultSearch(arrData.get(2).getSnippet().getTitle(),arrData.get(2).getSnippet().getDescription(),arrData.get(2).getSnippet().getThumbnails().getMedium().getUrl());
        ResultSearch resultSearch4=new ResultSearch(arrData.get(3).getSnippet().getTitle(),arrData.get(3).getSnippet().getDescription(),arrData.get(3).getSnippet().getThumbnails().getMedium().getUrl());
        ResultSearch resultSearch5=new ResultSearch(arrData.get(4).getSnippet().getTitle(),arrData.get(4).getSnippet().getDescription(),arrData.get(4).getSnippet().getThumbnails().getMedium().getUrl());

        arrResult.add(resultSearch1);
        arrResult.add(resultSearch2);
        arrResult.add(resultSearch3);
        arrResult.add(resultSearch4);
        arrResult.add(resultSearch5);

        AdapterListView adapterListView= new AdapterListView(getContext(),android.R.layout.simple_list_item_1,arrResult);
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
