package com.locensate.letnetwork.main.ui.message;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.main.ui.deletemsg.DeleteMessageActivity;
import com.locensate.letnetwork.view.LetIndicate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *  
 * @author xiaobinghe
 */

public class MessageActivity extends BaseActivity<MessagePresenter, MessageModel> implements MessageContract.View {

    @BindView(R.id.indicator_message_activity)
    LetIndicate indicatorMessageActivity;
    @BindView(R.id.activity_message)
    LinearLayout activityMessage;
    @BindView(R.id.vp_message_activity)
    ViewPager vpMessageActivity;
    @BindView(R.id.iv_message_back)
    ImageView ivMessageBack;
    @BindView(R.id.tv_message_title_content)
    TextView tvMessageTitleContent;
    @BindView(R.id.tv_delete)
    TextView tvDelete;
    private int selected;
    private int page = 0;
    //private String[] titles = {"报警", "能效", "工单", "提醒"};

    @Override
    public int getLayoutId() {
        LogUtil.e("HomeActivity", String.valueOf(this.getTaskId()));
        return R.layout.activity_message;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData(Fragment[] fragments) {
        tvMessageTitleContent.setText("消息");
        ivMessageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skip();
            }
        });

        selected = getIntent().getIntExtra("msgType", 0);
        List<String> titles = new ArrayList<>();
        titles.add("报警");
        titles.add("能效");
        titles.add("工单");
        titles.add("提醒");
        indicatorMessageActivity.setTitles(titles);
        indicatorMessageActivity.setSelectedPos(selected);
        indicatorMessageActivity.setOnItemClickListener(new LetIndicate.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position, boolean open) {
                indicatorMessageActivity.setSelectedPos(position);
                vpMessageActivity.setCurrentItem(position);
            }
        });
        vpMessageActivity.setAdapter(new MessageVpAdapter(getSupportFragmentManager(), fragments));
        vpMessageActivity.setCurrentItem(selected);
        vpMessageActivity.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicatorMessageActivity.resetPos(selected);
                indicatorMessageActivity.setSelectedPos(position);
                page = position;
                selected = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void skip() {
        Intent intent = new Intent(this, DeleteMessageActivity.class);
        intent.putExtra("message", page);
        startActivity(intent);
    }

    private int getUnreadRemind() {
        return 0;
    }

    private int getUnreadOrder() {
        return 0;
    }

    private int getUnreadEnergy() {
        return 0;
    }

    public int getUnreadAlert() {
        return 0;
    }

}
