package com.locensate.letnetwork.main.ui.fragments.historyorder;

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

public class HistoryOrderFragment extends BaseFragment<HistoryOrderPresenter, HistoryOrderModel> implements HistoryOrderContract.View {

    private static HistoryOrderFragment instance;
    @BindView(R.id.spinner_history_order_fragment)
    AppCompatSpinner spinnerHistoryOrderFragment;
    @BindView(R.id.rv_history_order_fragment)
    RecyclerView rvHistoryOrderFragment;
    @BindView(R.id.spinner_history_order_fragment_search)
    AppCompatSpinner spinnerHistoryOrderFragmentSearch;
    private String[] sorts = {"时间", "企业"};
    private String[] searchs={"条目一","条目二","条目三"};

    public static HistoryOrderFragment getInstance() {
        if (null == instance) {
            instance = new HistoryOrderFragment();
        }
        return instance;
    }

    @Override
    public int getInflaterView() {
        return R.layout.fragment_history_order;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void initView() {
        spinnerHistoryOrderFragment.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spinner_drop_item, sorts));
        spinnerHistoryOrderFragment.setDropDownVerticalOffset(DisplayUtil.dp2px(30));
        spinnerHistoryOrderFragment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerHistoryOrderFragmentSearch.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spinner_drop_item, searchs));
        spinnerHistoryOrderFragmentSearch.setDropDownVerticalOffset(DisplayUtil.dp2px(30));
        spinnerHistoryOrderFragmentSearch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void fillData(List<OrderItemEntity> data) {
        rvHistoryOrderFragment.setLayoutManager(new LinearLayoutManager(mContext));
        rvHistoryOrderFragment.setAdapter(new HistoryOrderAdapter(R.layout.item_history_order, data));
    }
}
