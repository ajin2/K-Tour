package com.example.hanaj.k_tour.common.MainSearch;

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
 * Created by hanaj on 2016-09-05.
 */
public class MainSearchListViewAdapter extends BaseAdapter {

    private List<MainSearchData> mainSearchDataList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;

    public MainSearchListViewAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void addMainSearchDataList(AreaBasedJsonResponse areaBasedJsonResponse) {

        List<MainSearchData> mainSearchDataList = new ArrayList<>();

        AreaBasedResponse response = areaBasedJsonResponse.getResponse();
        if(!response.getHeader().getResultCode().equals("0000")){
            return;
        }

        AreaBasedBody body = response.getBody();
        List<AreaBasedItem> items = body.getItems().getItem();

        for(AreaBasedItem item : items) {
            MainSearchData mainSearchData = new MainSearchData();
            mainSearchData.setTitle(item.getTitle());
            mainSearchData.setContent(item.getAddr1());
            mainSearchData.setThumbnail(item.getFirstimage());

            mainSearchDataList.add(mainSearchData);
        }

        this.mainSearchDataList.addAll(mainSearchDataList);
    }

    @Override
    public int getCount() { return mainSearchDataList.size(); }

    @Override
    public Object getItem(int position) {

        if(position < mainSearchDataList.size()) {
            return mainSearchDataList.get(position);
        }

        return null;
    }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MainSearchViewHolder mainSearchViewHolder;
        if(convertView == null) {
            mainSearchViewHolder = new MainSearchViewHolder();
            convertView = layoutInflater.inflate(R.layout.main_search_item, parent, false);

            mainSearchViewHolder.setMainSearchImageView((NetworkImageView) convertView.findViewById(R.id.mainSearchImageView));
            mainSearchViewHolder.setMainSearchTitleTextView((TextView) convertView.findViewById(R.id.mainSearchTitleTextView));
            mainSearchViewHolder.setMainSearchContentTextView((TextView)convertView.findViewById(R.id.mainSearchContentTextView));

                    convertView.setTag(mainSearchViewHolder);
        } else {
            mainSearchViewHolder = (MainSearchViewHolder) convertView.getTag();
        }

        MainSearchData mainSearchData = mainSearchDataList.get(position);

        mainSearchViewHolder.getMainSearchImageView().setImageUrl(mainSearchData.getThumbnail(), NetworkManager.getInstance(context).getImageLoader());
        mainSearchViewHolder.getMainSearchTitleTextView().setText(mainSearchData.getTitle());
        mainSearchViewHolder.getMainSearchContentTextView().setText(mainSearchData.getContent());

        return convertView;
    }
}
