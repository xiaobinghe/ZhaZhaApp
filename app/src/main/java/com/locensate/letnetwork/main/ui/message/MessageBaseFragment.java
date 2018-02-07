package com.locensate.letnetwork.main.ui.message;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;

import butterknife.BindView;


/**
 *  
 * @author xiaobinghe
 */

public abstract class MessageBaseFragment extends BaseFragment {

    @BindView(R.id.rv_alert_message)
    RecyclerView mRvAlertMessage;

    public MessageBaseFragment() {

    }

    @Override
    public int getInflaterView() {
        return R.layout.fragment_alert_message;
    }

    @Override
    protected void initView() {
        mRvAlertMessage.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvAlertMessage.setAdapter(getAdapter());
    }

    public abstract RecyclerView.Adapter getAdapter();

    @Override
    protected void lazyLoad() {

    }


}
