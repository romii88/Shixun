package com.ak.shixun.home.model;

import android.widget.Button;
import android.widget.TextView;

import com.ak.shixun.R;
import com.ak.shixun.base.AKBaseHolder;

import butterknife.BindView;

/**
 * Created by han on 2017/1/9.
 */

public class HomeHeaderHolder extends AKBaseHolder {
    @BindView(R.id.btn_login)
    Button btnLogin;

    @BindView(R.id.tv_header_prompt)
    TextView tvHeaderPrompt;
}
