package com.ak.shixun.home.model;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ak.shixun.R;
import com.ak.shixun.base.AKBaseHolder;

import butterknife.BindView;

/**
 * Created by han on 2017/1/9.
 */

public class HomeContentHolder extends AKBaseHolder {
    @BindView(R.id.iv_home_item)
    ImageView ivHomeItem;

    @BindView(R.id.tv_home_item)
    TextView tvHomeItem;

    @BindView(R.id.home_item_container)
    ViewGroup container;
}
