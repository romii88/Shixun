package com.ak.shixun.report.model;

import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.ak.shixun.R;

/**
 * Created by han on 2017/1/11.
 */

public class ReportImgModel extends EpoxyModelWithHolder<ReportImgHolder> {
    @Override
    protected ReportImgHolder createNewHolder() {
        return new ReportImgHolder();
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.item_report_img;
    }

    @Override
    public void bind(ReportImgHolder holder) {
        super.bind(holder);
        holder.imgReport.setBackgroundResource(R.drawable.about_seal);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return 1;
    }
}
