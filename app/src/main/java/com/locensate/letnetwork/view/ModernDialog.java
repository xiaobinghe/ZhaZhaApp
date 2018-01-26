package com.locensate.letnetwork.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.locensate.letnetwork.R;

/**
 *
 * @author xiaobinghe
 */


public class ModernDialog extends AlertDialog implements View.OnClickListener {

    private Context context;
    private int layoutResId;
    private int[] listenedItems;
    private OnModernDialogItemClickListener listener;
    private TextView tvMessage;

    public ModernDialog(Context context, int layoutResId, int[] listenedItems) {
        super(context, R.style.PickerViewStyle);
        this.context = context;
        this.layoutResId = layoutResId;
        this.listenedItems = listenedItems;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);//设置显示居中
        window.setWindowAnimations(R.style.pickerview_dialogAnim);//设置动画

        setContentView(layoutResId);//设置布局
        WindowManager manager = ((Activity) context).getWindowManager();
        Display display = manager.getDefaultDisplay();
        int width = display.getWidth();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = width * 4 / 5;//设置显示的宽度
        getWindow().setAttributes(params);
        setCanceledOnTouchOutside(true);//点击Dialog外部，Dialog消失

        tvMessage = (TextView) findViewById(R.id.dialog_text);

        for (int i = 0; i < listenedItems.length; i++) {
            findViewById(listenedItems[i]).setOnClickListener(this);
        }
    }


    public interface OnModernDialogItemClickListener {
        void modernItemClickListener(ModernDialog dialog, View v);
    }

    public void setOnModernItemClickListener(OnModernDialogItemClickListener listener) {
        this.listener = listener;
    }

    public void setMessage(String msg) {
        tvMessage.setText(msg);
    }

    @Override
    public void onClick(View v) {
        dismiss();
        listener.modernItemClickListener(this, v);
    }
}
