package com.ak.shixun.report.model;

import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.ak.shixun.R;

/**
 * Created by han on 2017/1/11.
 */

public class ReportTitleModel extends EpoxyModelWithHolder<ReportTitleHolder>{
    @Override
    protected ReportTitleHolder createNewHolder() {
        return new ReportTitleHolder();
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.layout_report_title;
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }
}
