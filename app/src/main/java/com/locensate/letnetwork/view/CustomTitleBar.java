package com.locensate.letnetwork.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.utils.ToastUtil;


/**
 *
 * @author xiaobinghe
 */


public class CustomTitleBar extends LinearLayout implements View.OnClickListener {

    private final TextView title;
    private final ImageView add;
    private final ImageView back;
    public boolean enable = true;
    public ClickedButtonListener mListener;
    private boolean backEnable = true;

    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.my_title_bar, this);
        back = (ImageView) findViewById(R.id.iv_title_back);
        add = (ImageView) findViewById(R.id.iv_title_menu);
        title = (TextView) findViewById(R.id.tv_title_content);
        back.setOnClickListener(this);
        add.setOnClickListener(this);
    }


    public void setTitle(String des) {
        title.setText(des);
    }

    public void setAddIsAble(boolean isAble) {
        if (isAble) {
            add.setVisibility(VISIBLE);
        } else {
            add.setVisibility(INVISIBLE);
        }
        add.setClickable(isAble);
        enable = isAble;
    }

    public void setbackIsAble(boolean isAble) {
        if (isAble) {
            back.setVisibility(VISIBLE);
            back.setClickable(true);
        } else {
            back.setVisibility(INVISIBLE);
            back.setClickable(false);
        }
        back.setClickable(isAble);
        backEnable = isAble;
    }

    public boolean getAddIsAble() {
        return enable;
    }

    public boolean getBackIsAble() {
        return backEnable;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_back:
                ((Activity) getContext()).finish();
                break;
            case R.id.iv_title_menu:
                ToastUtil.show("You clicked carefully!");
                mListener.clickedMenu();
                break;
        }
    }

    public void clicked(ClickedButtonListener listener) {
        mListener = listener;
    }

    public interface ClickedButtonListener {
        void clickedMenu();

        void clickedBack();
    }
}
