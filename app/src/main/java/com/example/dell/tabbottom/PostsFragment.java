package com.example.dell.tabbottom;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class PostsFragment extends Fragment {

	@Bind(R.id.recyclerView) RecyclerView recyclerView;
	@Bind(R.id.tvTab)
	TextView tvTab;

	private String position;


	public static Fragment newInstance(Context context) {
		PostsFragment f = new PostsFragment();
		return f;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ViewGroup root = (ViewGroup) inflater.inflate(R.layout.content_main, null);
		setUpView(root);
		return root;
	}

	private void setUpView(ViewGroup root){
		ButterKnife.bind(this, root);

//		setUPList();
	}

	public void setTvTab(String tv){
		tvTab.setText(tv+"");
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

}
