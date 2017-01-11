package com.ak.shixun.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ak.shixun.R;
import com.ak.shixun.server.SealAction;
import com.ak.shixun.server.network.async.AsyncTaskManager;
import com.ak.shixun.server.network.async.OnDataListener;
import com.ak.shixun.server.network.http.HttpException;
import com.ak.shixun.server.response.DefaultConversationResponse;
import com.ak.shixun.server.utils.NToast;

import java.util.ArrayList;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;


public class DiscoverFragment extends Fragment implements View.OnClickListener, OnDataListener {

    private static final int GETDEFCONVERSATION = 333;
    private AsyncTaskManager atm = AsyncTaskManager.getInstance(getActivity());
    private ArrayList<DefaultConversationResponse.ResultEntity> chatroomList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chatroom_list, container, false);
        initViews(view);
        atm.request(GETDEFCONVERSATION, this);
        return view;
    }

    private void initViews(View view) {
        LinearLayout chatroomItem1 = (LinearLayout) view.findViewById(R.id.def_chatroom1);
        LinearLayout chatroomItem2 = (LinearLayout) view.findViewById(R.id.def_chatroom2);
        LinearLayout chatroomItem3 = (LinearLayout) view.findViewById(R.id.def_chatroom3);
        LinearLayout chatroomItem4 = (LinearLayout) view.findViewById(R.id.def_chatroom4);
        chatroomItem1.setOnClickListener(this);
        chatroomItem2.setOnClickListener(this);
        chatroomItem3.setOnClickListener(this);
        chatroomItem4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (chatroomList == null || chatroomList.get(0) == null) {
            NToast.shortToast(getActivity(), getString(R.string.join_chat_room_error_toast));
            return;
        }
        switch (v.getId()) {
            case R.id.def_chatroom1:
                RongIM.getInstance().startConversation(getActivity(), Conversation.ConversationType.CHATROOM, chatroomList.get(0).getId(), "聊天室 I");
                break;
            case R.id.def_chatroom2:
                RongIM.getInstance().startConversation(getActivity(), Conversation.ConversationType.CHATROOM, chatroomList.get(1).getId(), "聊天室 II");
                break;
            case R.id.def_chatroom3:
                RongIM.getInstance().startConversation(getActivity(), Conversation.ConversationType.CHATROOM, chatroomList.get(2).getId(), "聊天室 III");
                break;
            case R.id.def_chatroom4:
                RongIM.getInstance().startConversation(getActivity(), Conversation.ConversationType.CHATROOM, chatroomList.get(3).getId(), "聊天室 IV");
                break;
        }
    }

    @Override
    public Object doInBackground(int requestCode, String parameter) throws HttpException {
        return new SealAction(getActivity()).getDefaultConversation();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSuccess(int requestCode, Object result) {
        DefaultConversationResponse response = (DefaultConversationResponse) result;
        if (response.getCode() == 200) {
            ArrayList<DefaultConversationResponse.ResultEntity> resultEntityArrayList = new ArrayList();
            chatroomList = new ArrayList();
            if (response.getResult().size() > 0) {
                resultEntityArrayList.clear();
                chatroomList.clear();
                for (DefaultConversationResponse.ResultEntity d : response.getResult()) {
                    if (d.getType().equals("group")) {
                        resultEntityArrayList.add(d);
                    } else {
                        chatroomList.add(d);
                    }
                }
            }
        }
    }

    @Override
    public void onFailure(int requestCode, int state, Object result) {

    }


}
