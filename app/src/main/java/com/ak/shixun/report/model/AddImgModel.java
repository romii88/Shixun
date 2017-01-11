package com.ak.shixun.report.model;

import android.view.View;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.ak.shixun.R;

/**
 * Created by han on 2017/1/11.
 */

public class AddImgModel extends EpoxyModelWithHolder<ReportImgHolder> {
    @EpoxyAttribute
    View.OnClickListener clickListener;
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
        holder.imgReport.setBackgroundResource(R.drawable.de_ic_add);
        holder.imgReport.setOnClickListener(clickListener);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return 1;
    }
}
