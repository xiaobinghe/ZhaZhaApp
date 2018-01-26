package com.locensate.letnetwork.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.ToastUtil;
import com.locensate.letnetwork.entity.OrderCommunicate;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  
 * @author xiaobinghe
 */

public class AddCommunicationActivity extends BaseActivity {


    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tv_text_count)
    TextView tvTextCount;
    @BindView(R.id.btn_commit)
    Button btnCommit;
    @BindView(R.id.activity_add_evaluate)
    LinearLayout activityAddEvaluate;
    private String orderId;
    private int ON_COMMIT_COMMUNICATION = 0x1002;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_communication;
    }

    @Override
    public void initView() {
        tvTitleOnlyBack.setText("添加沟通记录");
        orderId = getIntent().getStringExtra("orderId");
        etContent.addTextChangedListener(
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
                        editStart = etContent.getSelectionStart();
                        editEnd = etContent.getSelectionEnd();
                        tvTextCount.setText(temp.length() + "/200");
                        if (temp.length() > 200) {
                            ToastUtil.show("输入的字数已经超过了限制!");
                            s.delete(editStart - 1, editEnd);
                            int tempSelection = editStart;
                            etContent.setText(s);
                            etContent.setSelection(tempSelection);
                        }
                    }
                }
        );
    }

    @OnClick({R.id.iv_title_only_back, R.id.btn_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                finish();
                break;
            case R.id.btn_commit:
                if (TextUtils.isEmpty(etContent.getText().toString()))
                    ToastUtil.show("请填写沟通内容");
                Intent data = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("communicate", new OrderCommunicate("", orderId, "张珊", System.currentTimeMillis(), "", etContent.getText().toString()));
                data.putExtras(bundle);
                setResult(ON_COMMIT_COMMUNICATION, data);
                finish();
                break;
        }
    }
}
