package com.ak.shixun.report;

import android.view.View;

import com.ak.shixun.base.AKBaseRecyclerViewAdapter;
import com.ak.shixun.report.model.AddImgModel_;
import com.ak.shixun.report.model.ReportContentModel;
import com.ak.shixun.report.model.ReportImgModel;
import com.ak.shixun.report.model.ReportTitleModel;

/**
 * Created by han on 2017/1/11.
 */

public class ReportAdapter extends AKBaseRecyclerViewAdapter{
    private ReportTitleModel titleModel=new ReportTitleModel();
    private ReportContentModel contentModel=new ReportContentModel();
//    private ReportImgModel imgModel=new ReportImgModel();
    private AddImgModel_ addImgModel=new AddImgModel_().clickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            insertModelBefore(new ReportImgModel(),addImgModel);
            notifyModelsChanged();
        }
    });
    public ReportAdapter(){
        enableDiffing();
        addModels(titleModel,contentModel);
        addModel(addImgModel);
    }
}
