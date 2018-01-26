package com.locensate.letnetwork.main.ui.fragments.currentorder;

import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.utils.DisplayUtil;
import com.locensate.letnetwork.entity.OrderItemEntity;

import java.util.List;

import butterknife.BindView;

/**
 *
 * @author xiaobinghe
 */

public class CurrentOrderFragment extends BaseFragment<CurrentOrderPresenter, CurrentOrderModel> implements CurrentOrderContract.View {

    private static CurrentOrderFragment instance;
    @BindView(R.id.spinner_current_order_fragment)
    AppCompatSpinner spinnerCurrentOrderFragment;
    @BindView(R.id.rv_current_order_fragment)
    RecyclerView rvCurrentOrderFragment;
    private String[] items = {"时间", "企业"};

    public static CurrentOrderFragment getInstance() {
        if (null == instance) {
            instance = new CurrentOrderFragment();
        }
        return instance;
    }

    @Override
    public int getInflaterView() {
        return R.layout.fragment_current_order;
    }

    @Override
    protected void initView() {
        spinnerCurrentOrderFragment.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spinner_drop_item, items));
        spinnerCurrentOrderFragment.setDropDownVerticalOffset(DisplayUtil.dp2px(30));
        spinnerCurrentOrderFragment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void lazyLoad() {

    }
    @Override
    public void fillData(List<OrderItemEntity> data) {
        rvCurrentOrderFragment.setLayoutManager(new LinearLayoutManager(mContext));
        rvCurrentOrderFragment.setAdapter(new CurrentOrderAdapter(R.layout.item_current_order,data));
    }
}
