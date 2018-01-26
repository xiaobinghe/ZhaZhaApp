package com.locensate.letnetwork.main.ui.addorder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.entity.MachineEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 添加设备
 *
 * @author xiaobinghe
 */

public class AddMachineFragment extends BaseFragment {
    @BindView(R.id.rv_machine_list)
    RecyclerView mRvMachineList;
    @BindView(R.id.btt_commit_add)
    Button mBttCommitAdd;

    private List<MachineEntity> date=new ArrayList<>();

    @Override
    public int getInflaterView() {
        return R.layout.fragment_add_machine;
    }

    @Override
    protected void initView() {
        mRvMachineList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvMachineList.setAdapter(new AddMachineRvAdapter(date,getActivity()));

    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick(R.id.btt_commit_add)
    public void onViewClicked() {
    }
}
