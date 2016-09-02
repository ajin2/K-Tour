package com.example.hanaj.k_tour.common.Tour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.hanaj.k_tour.R;
import com.example.hanaj.k_tour.common.Network.NetworkManager;
import com.example.hanaj.k_tour.common.Network.Response.AreaBasedBody;
import com.example.hanaj.k_tour.common.Network.Response.AreaBasedItem;
import com.example.hanaj.k_tour.common.Network.Response.AreaBasedJsonResponse;
import com.example.hanaj.k_tour.common.Network.Response.AreaBasedResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanaj on 2016-08-27.
 */
public class TourListViewAdapter extends BaseAdapter {

    private List<TourData> tourDataList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;

    public TourListViewAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public  void addTourDataList(AreaBasedJsonResponse areaBasedJsonResponse){

        List<TourData> tourDataList = new ArrayList<TourData>();

        AreaBasedResponse response = areaBasedJsonResponse.getResponse();
        if(!response.getHeader().getResultCode().equals("0000")){
            return;
        }

        AreaBasedBody body = response.getBody();
        List<AreaBasedItem> items = body.getItems().getItem();

        for(AreaBasedItem item : items){
            TourData tourData = new TourData();
            tourData.setTitle(item.getTitle());
            tourData.setContent(item.getAddr1());
            tourData.setThumbnail(item.getFirstimage());

            tourDataList.add(tourData);
        }

        this.tourDataList.addAll(tourDataList);
    }

    @Override
    public int getCount() { return tourDataList.size(); }

    @Override
    public Object getItem(int position) {

        if(position <tourDataList.size()) {
            return tourDataList.get(position);
        }

        return null;
    }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TourViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new TourViewHolder();
            convertView = layoutInflater.inflate(R.layout.tour_listview_item, parent, false);

            viewHolder.setTourImageView((NetworkImageView) convertView.findViewById(R.id.tourImageView));
            viewHolder.setTourTitleTextView((TextView) convertView.findViewById(R.id.tourTitleTextView));
            viewHolder.setTourContentTextView((TextView) convertView.findViewById(R.id.tourContentTextView));

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (TourViewHolder) convertView.getTag();
        }

        TourData tourData = tourDataList.get(position);

        viewHolder.getTourImageView().setImageUrl(tourData.getThumbnail(), NetworkManager.getInstance(context).getImageLoader());
        viewHolder.getTourTitleTextView().setText(tourData.getTitle());
        viewHolder.getTourContentTextView().setText(tourData.getContent());

        return convertView;
    }
}
