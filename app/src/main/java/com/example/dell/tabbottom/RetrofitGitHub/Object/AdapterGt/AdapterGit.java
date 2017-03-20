package com.example.dell.tabbottom.RetrofitGitHub.Object.AdapterGt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.tabbottom.Object.ResultSearch;
import com.example.dell.tabbottom.R;
import com.example.dell.tabbottom.RetrofitGitHub.Object.ObjectUser.UserResult;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dell on 11/11/2016.
 */
public class AdapterGit extends ArrayAdapter<UserResult> {
    private ArrayList<UserResult> arrWeath;
    private LayoutInflater inflater;

    public AdapterGit(Context context, int resource, ArrayList<UserResult> objects) {
        super(context, resource, objects);
        arrWeath= objects;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView==null){
            viewHolder= new ViewHolder();
            convertView= inflater.inflate(R.layout.item_listview,parent,false);

            ImageView imageView= (ImageView) convertView.findViewById(R.id.imageUrl);
            TextView tvTitle= (TextView) convertView.findViewById(R.id.tvTitle);
            TextView tvDescip= (TextView) convertView.findViewById(R.id.tvDesciption);

            viewHolder.img=imageView;
            viewHolder.tvTitle=tvTitle;
            viewHolder.tvDescip=tvDescip;

            convertView.setTag(viewHolder);
        }

        viewHolder= (ViewHolder) convertView.getTag();
//        viewHolder.img.setImageDrawable(getContext().getResources().getDrawable(arrWeath.get(position).getUrlImg()));
        Picasso.with(getContext()).load(arrWeath.get(position).getAvataUrl()+"")
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).into(viewHolder.img);
        viewHolder.tvTitle.setText("Login: "+arrWeath.get(position).getLoginName()+"");
        viewHolder.tvDescip.setText("Score: "+arrWeath.get(position).getScore()+"");

        return convertView;
    }

    class ViewHolder{
        private ImageView img;
        private TextView tvTitle,tvDescip;
    }
}
