package com.locensate.letnetwork.main.ui.addorder.addmachine;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.base.RxBus;
import com.locensate.letnetwork.entity.MachineEntity;
import com.locensate.letnetwork.main.ui.addorder.AddOrderActivity;

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

    private List<MachineEntity> data = new ArrayList<>();
    private AddMachineRvAdapter mRvAdapter;
    private FragmentTransaction mTransaction;

    @Override
    public int getInflaterView() {
        return R.layout.fragment_add_machine;
    }

    @Override
    protected void initView() {
        mockData();
        mRvMachineList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvAdapter = new AddMachineRvAdapter(data, getActivity());
        mRvMachineList.setAdapter(mRvAdapter);

    }

    private void mockData() {
        data.add(new MachineEntity("01", "中央空分电机"));
        data.add(new MachineEntity("01", "皮带机"));
        data.add(new MachineEntity("01", "循环风机"));
        data.add(new MachineEntity("01", "空冷壁风机"));
        data.add(new MachineEntity("01", "二次空冷风机"));
    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick(R.id.btt_commit_add)
    public void onViewClicked() {
        RxBus.get().post(mRvAdapter.getSelecedMachine());
        mTransaction = ((AddOrderActivity) getActivity()).getSupportFragmentManager().beginTransaction();
        mTransaction.hide(this).show(((AddOrderActivity) getActivity()).getFragmentByTag("addOrder")).commit();
    }
}
