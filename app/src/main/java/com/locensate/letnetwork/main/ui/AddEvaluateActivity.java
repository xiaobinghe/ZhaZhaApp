package com.locensate.letnetwork.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  
 * @author xiaobinghe
 */

public class AddEvaluateActivity extends BaseActivity {


    @BindView(R.id.iv_title_only_back)
    ImageView mIvTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView mTvTitleOnlyBack;
    @BindView(R.id.iv_star1)
    ImageView mIvStar1;
    @BindView(R.id.iv_star2)
    ImageView mIvStar2;
    @BindView(R.id.iv_star3)
    ImageView mIvStar3;
    @BindView(R.id.iv_star4)
    ImageView mIvStar4;
    @BindView(R.id.iv_star5)
    ImageView mIvStar5;
    @BindView(R.id.ll_stars)
    LinearLayout mLlStars;
    @BindView(R.id.et_content)
    EditText mEtContent;
    @BindView(R.id.tv_content_count)
    TextView mTvContentCount;
    @BindView(R.id.btn_commit_evaluate)
    Button mBtnCommitEvaluate;
    @BindView(R.id.activity_add_evaluate)
    LinearLayout mActivityAddEvaluate;

    private int starCount = 5;
    private String evaluateContent;
    public static int EVALUATED = 0x1100;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_evaluate;
    }

    @Override
    public void initView() {
        mTvTitleOnlyBack.setText("评价");
        mEtContent.addTextChangedListener(new TextWatcher() {

            private CharSequence mTemp;
            private int mEditEnd;
            private int mEditStart;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                LogUtil.e(TAG, "beforeTextChanged: s======" + s + "---count=" + count + "---start=" + start + "--after=" + after);
                mTemp = s;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                LogUtil.e(TAG, "onTextChanged: s======" + s + "---count=" + count + "---start=" + start + "--before=" + before);

            }

            @Override
            public void afterTextChanged(Editable s) {
                LogUtil.e(TAG, "afterTextChanged: s=====" + s.toString());
                mEditStart = mEtContent.getSelectionStart();
                mEditEnd = mEtContent.getSelectionEnd();
                mTvContentCount.setText(mTemp.length() + "/200");
                if (mTemp.length() > 200) {
                    ToastUtil.show("输入的字数已经超过了限制!");
                    Snackbar.make(new TextView(getApplication()), "输入的字数已经超过了限制", Snackbar.LENGTH_SHORT);
                    s.delete(mEditStart - 1, mEditEnd);
                    int tempSelection = mEditStart;
                    mEtContent.setText(s);
                    mEtContent.setSelection(tempSelection);
                }
            }
        });
    }

    @OnClick({R.id.iv_title_only_back, R.id.iv_star1, R.id.iv_star2, R.id.iv_star3, R.id.iv_star4, R.id.iv_star5, R.id.btn_commit_evaluate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                finish();
                break;
            case R.id.iv_star1:
                setStartNum(1);
                break;
            case R.id.iv_star2:
                setStartNum(2);
                break;
            case R.id.iv_star3:
                setStartNum(3);
                break;
            case R.id.iv_star4:
                setStartNum(4);
                break;
            case R.id.iv_star5:
                setStartNum(5);
                break;
            case R.id.btn_commit_evaluate:
                evaluateContent = mEtContent.getText().toString();
                Intent data = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt("starCount", starCount);
                bundle.putString("evaluateContent", evaluateContent);
                data.putExtras(bundle);
                setResult(EVALUATED, data);
                finish();
                break;
        }
    }

    public void setStartNum(int startNum) {
        starCount = startNum;
        mIvStar2.setImageResource(startNum == 1 ? R.drawable.star_gray : R.drawable.star_yellow);
        mIvStar3.setImageResource(startNum == 1 || startNum == 2 ? R.drawable.star_gray : R.drawable.star_yellow);
        mIvStar4.setImageResource(startNum == 4 || startNum == 5 ? R.drawable.star_yellow : R.drawable.star_gray);
        mIvStar5.setImageResource(startNum == 5 ? R.drawable.star_yellow : R.drawable.star_gray);
    }


}
