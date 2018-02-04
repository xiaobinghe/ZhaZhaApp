package com.locensate.letnetwork.main.ui.addorder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.bean.EntpBean;
import com.locensate.letnetwork.main.ui.addorder.addmachine.AddMachineFragment;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;


/**
 * 添加工单
 *
 * @author xiaobinghe
 */

public class AddOrderFragment extends BaseFragment {
    @BindView(R.id.tv_create_order_enterprise)
    TextView mTvCreateOrderEnterprise;
    @BindView(R.id.iv_enterprise)
    ImageView mIvEnterprise;
    @BindView(R.id.ll_enterprise_list)
    LinearLayout mLlEnterpriseList;
    @BindView(R.id.tv_add_machine)
    TextView mTvAddMachine;
    @BindView(R.id.iv_add_machine)
    ImageView mIvAddMachine;
    @BindView(R.id.et_create_order_content)
    EditText mEtCreateOrderContent;
    @BindView(R.id.tv_create_order_count)
    TextView mTvCreateOrderCount;
    @BindView(R.id.btn_commit_create_order)
    Button mBtnCommitCreateOrder;
    private PopupWindow mEnterpriseList;
    private InputMethodManager mInputMethodManager;


    @Override
    public int getInflaterView() {
        return R.layout.fragment_add_order;
    }

    @Override
    protected void initView() {

        String machineName = getArguments().getString("machineName");
        mTvAddMachine.setText(machineName);
        mInputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mEtCreateOrderContent.addTextChangedListener(
                new TextWatcher() {
                    private CharSequence temp;
                    private int editStart;
                    private int editEnd;

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        temp = s;
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        editStart = mEtCreateOrderContent.getSelectionStart();
                        editEnd = mEtCreateOrderContent.getSelectionEnd();
                        mTvCreateOrderCount.setText(temp.length() + "/200");
                        if (temp.length() > 200) {
                            ToastUtil.show("输入的字数已经超过了限制!");
                            s.delete(editStart - 1, editEnd);
                            int tempSelection = editStart;
                            mEtCreateOrderContent.setText(s);
                            mEtCreateOrderContent.setSelection(tempSelection);
                        }
                    }
                }
        );
    }

    @Override
    protected void lazyLoad() {

    }

    /**
     * 添加设备
     */
    private void addMachine() {
        getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.page_anima_right_in,R.anim.page_anima_right_out).addToBackStack("addOrder").add(R.id.fl_contain, new AddMachineFragment()).commit();
    }

    private void createEnterprisePop(View view) {
        LogUtil.e(TAG, "show Enterprise");
        RecyclerView recyclerView = new RecyclerView(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        EnterpriseAdapter adapter = new EnterpriseAdapter(getActivity(), getEnterprises());
        adapter.setSelectListener(new EnterpriseAdapter.SelectedListener() {
            @Override
            public void onSelect(EntpBean entpBean) {
                mTvCreateOrderEnterprise.setText(entpBean.getName());
                mEnterpriseList.dismiss();
            }
        });
        recyclerView.setAdapter(adapter);
        mEnterpriseList = new PopupWindow(recyclerView, mLlEnterpriseList.getWidth(), LinearLayout.LayoutParams.WRAP_CONTENT, true);

        Drawable drawable = ContextCompat.getDrawable(App.getApplication(), R.drawable.input_background);
        mEnterpriseList.setBackgroundDrawable(drawable);
        mEnterpriseList.setOutsideTouchable(true);
        mEnterpriseList.showAsDropDown(view, -mTvCreateOrderEnterprise.getWidth(), 10);

    }

    private List<EntpBean> getEnterprises() {
        List<EntpBean> entpBeen = new ArrayList<>();
        entpBeen.add(new EntpBean("locensate", "北京罗圣森特节能科技有限公司"));
        entpBeen.add(new EntpBean("locensate", "上海电机科学研究院"));
        entpBeen.add(new EntpBean("locensate", "北京电机厂股份有限公司"));
        return entpBeen;
    }

    @OnClick({ R.id.iv_enterprise, R.id.iv_add_machine, R.id.btn_commit_create_order})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_enterprise:
                createEnterprisePop(view);
                break;
            case R.id.iv_add_machine:
                addMachine();
                break;
            case R.id.btn_commit_create_order:
                if (isEmpty()) {
                    ToastUtil.show("工单描述不能为空");
                } else {
                    // TODO: 2018/1/22 提交工单

                }
                break;
            default:
                break;
        }
    }

    private boolean isEmpty() {
        return TextUtils.isEmpty(mEtCreateOrderContent.getText().toString());
    }

}
