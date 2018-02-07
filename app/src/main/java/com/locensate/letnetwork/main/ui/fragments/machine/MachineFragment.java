package com.locensate.letnetwork.main.ui.fragments.machine;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.bean.MachineDataBean;
import com.locensate.letnetwork.bean.MachineFilterTag;
import com.locensate.letnetwork.main.ui.machineinfo.MachineInfoActivity;
import com.locensate.letnetwork.main.ui.search.SearchActivity;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.PickViewUtils;
import com.locensate.letnetwork.utils.SpUtil;
import com.locensate.letnetwork.view.ExpandablePopWindow;
import com.locensate.letnetwork.view.ModernDialog;
import com.locensate.letnetwork.view.filterview.ui.RightSideslipLay;
import com.locensate.letnetwork.view.timepick.MyTimePickerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 主页-设备列表
 *
 * @author xiaobinghe
 */

public class MachineFragment extends BaseFragment<MachinePresenter, MachineModel> implements MachineContract.View {

    @BindView(R.id.iv_root_file)
    ImageView ivRootFile;
    @BindView(R.id.tv_root_file)
    TextView tvRootFile;
    @BindView(R.id.iv_title_search)
    ImageView ivTitleSearch;
    @BindView(R.id.tv_machine_head_motor_count)
    TextView tvMachineHeadMotorCount;
    @BindView(R.id.tv_machine_head_power_count)
    TextView tvMachineHeadPowerCount;
    @BindView(R.id.tv_machine_head_power_sort)
    TextView tvMachineHeadPowerSort;
    @BindView(R.id.tv_machine_head_filter)
    TextView tvMachineHeadFilter;
    @BindView(R.id.up_down)
    ImageView upDown;
    @BindView(R.id.time_type_content)
    TextView timeTypeContent;
    @BindView(R.id.time_type)
    FrameLayout timeType;
    @BindView(R.id.tv_time_value)
    TextView tvTimeValue;
    @BindView(R.id.time_value)
    LinearLayout timeValue;
    @BindView(R.id.rv_machine_list)
    RecyclerView rvMachineList;
    @BindView(R.id.srl_machine_list_machine)
    SwipeRefreshLayout srlMachineListMachine;
    @BindView(R.id.fl_filter)
    FrameLayout mFlFilter;
    @BindView(R.id.drawer)
    DrawerLayout mDrawer;
    private MachineListAdapter adapter;
    private boolean isAddListener = false;
    private List<String> timeTypes = new ArrayList<>();
    private String timeShow;
    private MyTimePickerView yearPicker;
    private MyTimePickerView mouthPicker;
    private MyTimePickerView weekPicker;
    private MyTimePickerView dayPicker;
    private ExpandablePopWindow popWindow;
    private ModernDialog dialog;
    private OptionsPickerView mTimeTypePicker;
    private RightSideslipLay mFilterView;
    private ArrayList<MachineDataBean> mMachines;


    @Override
    public int getInflaterView() {
        return R.layout.fragment_machine;
    }

    @Override
    protected void initView() {
        /*初始化搜索按钮*/
        ivTitleSearch.setClickable(true);
        ivTitleSearch.setVisibility(View.VISIBLE);
        /*设置DrawerLayout开关模式*/
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);

        /*设置title*/
        tvRootFile.setText(SpUtil.getString(App.getApplication(), Constant.ENTERPRISE_NAME, "某钢铁厂"));
        tvRootFile.setFocusable(true);
        /*设置装机功率缺省值*/
        tvMachineHeadPowerCount.setText("总装机功率:36000kW");

        /*初始化筛选界面*/
        mFilterView = new RightSideslipLay(getActivity());
        mFilterView.setDataList(mModel.getFilterDefault());
        mFlFilter.addView(mFilterView);
        mFilterView.setCloseMenuCallBack(new RightSideslipLay.CloseMenuCallBack() {
            @Override
            public void setupCloseMean() {
                closeMenu();
            }
        });

        /*添加SwipeRefreshLayout的刷新监听*/
        srlMachineListMachine.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlMachineListMachine.setRefreshing(false);
            }
        });

        /*初始化时间筛选器数据*/
        timeTypes.add("小时");
        timeTypes.add("天");
        timeTypes.add("周");
        timeTypes.add("月");


        /*初始化fragments*/
        rvMachineList.setLayoutManager(new LinearLayoutManager(getContext()));
        mMachines = new ArrayList<>();
        adapter = new MachineListAdapter(getContext(), R.layout.item_machine_list, mMachines);
        rvMachineList.setAdapter(adapter);

        /*添加点击和长按监听*/

        adapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                final MachineDataBean item = (MachineDataBean) baseQuickAdapter.getItem(i);
                isMarkImportantMachine(item);
                return false;
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MachineDataBean item = (MachineDataBean) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(App.getApplication(), MachineInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("machineId", item.getId());
                bundle.putString("machineName", item.getName());
                intent.putExtras(bundle);
                startActivity(intent);
            }

        });

    }


    @Override
    protected void onVisible() {
        super.onVisible();
    }

    @Override
    protected void lazyLoad() {
        LogUtil.e("MachineFragment", "--------------lazyLoad()");
        mPresenter.initData();
        mPresenter.refreshFilter();
    }

    @Override
    public void fillData(List<MachineDataBean> machines) {
        if (mMachines.size() > 0) {
            mMachines.clear();
        }
        mMachines.addAll(machines);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void fillFilter(MachineFilterTag machineFilterTags) {
        mFilterView.setDataList(machineFilterTags);
    }

    @OnClick({R.id.iv_root_file, R.id.iv_title_search, R.id.tv_machine_head_power_sort, R.id.tv_machine_head_filter, R.id.time_type, R.id.time_value})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_root_file:
                mPresenter.showPop();
                break;
            case R.id.iv_title_search:
                startSearch();
                break;
            case R.id.tv_machine_head_power_sort:
                powerSort();
                break;
            case R.id.tv_machine_head_filter:
                openMenu();
//                if (null == filterPopWindow) {
//                    filterPopWindow = new FilterPopWindow(getActivity(), mModel.getFilterData());
//                    filterPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//                        @Override
//                        public void onDismiss() {
//                            String filters = filterPopWindow.getFilters();
//                            ToastUtil.show("Okay:" + filters);
//                        }
//                    });
//                }
//                filterPopWindow.show(tvMachineHeadFilter);
                break;
            case R.id.time_type:
                if (null == mTimeTypePicker) {
                    mTimeTypePicker = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            timeTypeContent.setText(timeTypes.get(options1));
                        }
                    }).setLayoutRes(R.layout.layout_time_type_select, new CustomListener() {
                        @Override
                        public void customLayout(View v) {
                            Button cancel = (Button) v.findViewById(R.id.btt_cancel);
                            Button okay = (Button) v.findViewById(R.id.btt_okay);
                            (v.findViewById(R.id.pick_head)).setVisibility(View.GONE);
                            okay.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mTimeTypePicker.returnData();
                                }
                            });
                            cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mTimeTypePicker.dismiss();
                                }
                            });
                        }
                    })
                            .setSubmitColor(getActivity().getResources().getColor(R.color.font_deep_blue))
                            .setCancelColor(getActivity().getResources().getColor(R.color.font_deep_blue))
                            .setDividerType(WheelView.DividerType.FILL)
                            .setTitleBgColor(getActivity().getResources().getColor(R.color.bg))
                            .setLineSpacingMultiplier(2.0f)
                            .setSubCalSize(16)
                            .setContentTextSize(16)
                            .setDividerColor(getActivity().getResources().getColor(R.color.font_deep_blue))
                            .setTextColorCenter(getActivity().getResources().getColor(R.color.font_deep_blue))
                            .isDialog(true).build();
                    mTimeTypePicker.setPicker(timeTypes);
                }
                mTimeTypePicker.show();
                break;
            case R.id.time_value:
                timeShow = timeTypeContent.getText().toString();
                showPicker();
                break;
            default:
                break;
        }
    }

    private void powerSort() {
        srlMachineListMachine.setRefreshing(true);
        mPresenter.sort();
    }

    private void startSearch() {
        Intent intent = new Intent(getContext(), SearchActivity.class);
        intent.putExtra("search_type", "machine_list");
        startActivity(intent);
    }


    @Override
    public void showPop(List<MultiItemEntity> groupTree) {
        adapter.loadMoreComplete();
        if (null == popWindow) {
            popWindow = new ExpandablePopWindow(getActivity(), groupTree);
            popWindow.setAnimationStyle(R.style.MyPopAnim);
        }
        popWindow.showPopupWindow(ivRootFile);
        popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                tvRootFile.setText(popWindow.getPath());
            }
        });
    }

    @Override
    public void sortComplete(List<MachineDataBean> machineList) {
        fillData(machineList);
        srlMachineListMachine.setRefreshing(false);
    }

    private void showPicker() {
        Calendar instance = Calendar.getInstance();
        instance.set(2010, 0, 1);
        switch (timeShow) {
            case "小时":
                if (null == yearPicker) {
                    yearPicker = PickViewUtils.getInstance().getYMDHPicker(getActivity(), instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            tvTimeValue.setText(DateUtils.getTime(date, timeShow));
                        }
                    });
                }
                yearPicker.show();
                break;
            case "月":
                if (null == mouthPicker) {
                    mouthPicker = PickViewUtils.getInstance().getYMPicker(getActivity(), instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            tvTimeValue.setText(DateUtils.getTime(date, timeShow));

                        }
                    });
                }
                mouthPicker.show();
                break;
            case "周":
                if (null == weekPicker) {
                    weekPicker = PickViewUtils.getInstance().getWeekPicker(getActivity(), instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            Date[] firstAndEnd = DateUtils.getFirstAndEndDayDateOfWeek(date);
                            tvTimeValue.setText(DateUtils.getTime(firstAndEnd[0], timeShow) + "/" + DateUtils.getTime(firstAndEnd[1], timeShow));
                        }
                    });
                }
                weekPicker.show();
                break;
            case "天":
                if (null == dayPicker) {
                    dayPicker = PickViewUtils.getInstance().getWeekPicker(getActivity(), instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            tvTimeValue.setText(DateUtils.getTime(date, timeShow));

                        }
                    });
                }
                dayPicker.show();
                break;
            default:
                break;
        }
    }


    private void isMarkImportantMachine(final MachineDataBean item) {
        dialog = new ModernDialog(getActivity(), R.layout.dialog_delete, new int[]{R.id.dialog_sure, R.id.dialog_cancel});
        dialog.show();


        if (!item.isImportant()) {
            dialog.setMessage("将 " + item.getName() + " 标记为我关注的设备");
        } else {
            dialog.setMessage("取消关注" + item.getName());
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
            }
        });
        dialog.setOnModernItemClickListener(new ModernDialog.OnModernDialogItemClickListener() {
            @Override
            public void modernItemClickListener(ModernDialog dialog, View v) {
                switch (v.getId()) {
                    case R.id.dialog_sure:
                        // TODO: 2018/1/23 标记为重点设备
                        mPresenter.markImportant(item);

                        item.setImportant(!item.isImportant());
                        dialog.dismiss();
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.dialog_cancel:
                        break;
                    default:
                        break;
                }
            }
        });
    }


    private void openMenu() {
        mDrawer.openDrawer(GravityCompat.END);
        mPresenter.refreshFilter();
    }

    private void closeMenu() {
        mDrawer.closeDrawer(GravityCompat.END);
    }


}
