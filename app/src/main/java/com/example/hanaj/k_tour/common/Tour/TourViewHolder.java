package com.example.hanaj.k_tour.common.Tour;

import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import lombok.Data;

/**
 * Created by hanaj on 2016-08-30.
 */
@Data
public class TourViewHolder {
    private NetworkImageView tourImageView;
    private TextView tourTitleTextView;
    private TextView tourContentTextView;
}
