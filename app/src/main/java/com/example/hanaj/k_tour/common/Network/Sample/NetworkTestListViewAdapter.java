package com.example.hanaj.k_tour.common.Network.Sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.hanaj.k_tour.R;
import com.example.hanaj.k_tour.common.Network.NetworkManager;
import com.example.hanaj.k_tour.common.Response.AreaBasedBody;
import com.example.hanaj.k_tour.common.Response.AreaBasedItem;
import com.example.hanaj.k_tour.common.Response.AreaBasedJsonResponse;
import com.example.hanaj.k_tour.common.Response.AreaBasedResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alphaposter on 2016. 8. 21..
 */
public class NetworkTestListViewAdapter extends BaseAdapter {

    private List<NetworkTestData> networkTestDataList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;

    public NetworkTestListViewAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void addNetworkTestDataList(AreaBasedJsonResponse areaBasedJsonResponse) {


        List<NetworkTestData> networkTestDataList = new ArrayList<NetworkTestData>();

        AreaBasedResponse response = areaBasedJsonResponse.getResponse();
        if(!response.getHeader().getResultCode().equals("0000")) {
            return;
        }

        AreaBasedBody body = response.getBody();
        List<AreaBasedItem> items = body.getItems().getItem();

        for(AreaBasedItem item : items) {
            NetworkTestData networkTestData = new NetworkTestData();
            networkTestData.setTitle(item.getTitle());
            networkTestData.setContent(item.getAddr1());
            networkTestData.setThumbnail(item.getFirstimage());

            networkTestDataList.add(networkTestData);
        }

        this.networkTestDataList.addAll(networkTestDataList);
    }

    @Override
    public int getCount() {
        return networkTestDataList.size();
    }

    @Override
    public Object getItem(int position) {

        if(position < networkTestDataList.size()) {
            return networkTestDataList.get(position);
        }

        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        NetworkTestViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new NetworkTestViewHolder();
            convertView = layoutInflater.inflate(R.layout.network_listview_item, parent, false);

            viewHolder.setTestImageView((NetworkImageView)convertView.findViewById(R.id.testImageView));
            viewHolder.setTitleTextView((TextView)convertView.findViewById(R.id.testTitleTextView));
            viewHolder.setContentTextView((TextView)convertView.findViewById(R.id.testContentTextView));

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (NetworkTestViewHolder) convertView.getTag();
        }

        NetworkTestData networkTestData = networkTestDataList.get(position);

        viewHolder.getTestImageView().setImageUrl(networkTestData.getThumbnail(), NetworkManager.getInstance(context).getImageLoader());
        viewHolder.getTitleTextView().setText(networkTestData.getTitle());
        viewHolder.getContentTextView().setText(networkTestData.getContent());

        return convertView;
    }
}
