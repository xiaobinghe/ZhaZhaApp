package com.locensate.letnetwork.main.ui.search;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.database.SearchHistoryDb;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.KeyBoardUtils;
import com.locensate.letnetwork.utils.ToastUtil;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 *
 * @author xiaobinghe
 */

public class SearchActivity extends BaseActivity<SearchPresenter, SearchModel> implements SearchContract.View {

    @BindView(R.id.et_search_view)
    AppCompatAutoCompleteTextView mSerchView;
    @BindView(R.id.btt_search)
    TextView bttSearch;
    @BindView(R.id.lv_search_history)
    ListView lvSearchHistory;
    @BindView(R.id.iv_search_back)
    ImageView ivSearchBack;
    private static String cacheLine;
    @BindView(R.id.fl_cancel_content)
    FrameLayout flCancelContent;
    @BindView(R.id.ll_search_history)
    LinearLayout llSearchHistory;
    private String[] historyArray;
    private String FILE_NAME;
    private List<SearchHistoryDb> historyDBList;
    private HistorySearchAdapter historySearchAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        flCancelContent.setVisibility(View.INVISIBLE);
        flCancelContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSerchView.setText("");
            }
        });
        mSerchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mSerchView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    KeyBoardUtils.closeKeybord(mSerchView, getApplicationContext());
                    //// TODO: 2017/5/3 开始搜索的逻辑代码
                    searchData();
                    return true;
                }
                return false;
            }
        });
        mSerchView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    flCancelContent.setVisibility(View.VISIBLE);
                } else {
                    flCancelContent.setVisibility(View.INVISIBLE);
                }
//                if (hasFocus) llSearchHistory.setVisibility(View.GONE);
//                else llSearchHistory.setVisibility(View.VISIBLE);
            }
        });

    }


    @OnClick({R.id.iv_search_back, R.id.btt_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_search_back:
                onBackPressed();
                break;
            case R.id.btt_search:
                KeyBoardUtils.closeKeybord(mSerchView, getApplicationContext());
                searchData();
                break;
        }
    }

    private void searchData() {
        // TODO: 2017/2/20 搜索业务
        if (TextUtils.isEmpty(mSerchView.getText())) {
            ToastUtil.show("请输入设备名称");
            return;
        }
        //1、添加搜索记录
        SearchHistoryDb searchHistoryDb = new SearchHistoryDb();
        searchHistoryDb.setId(DateUtils.getCurrentTimeMillis());
        searchHistoryDb.setTime((String) DateUtils.getData("2017-02-23 09:37", DateUtils.getCurrentTimeMillis()));
        searchHistoryDb.setCont(mSerchView.getText().toString());
        searchHistoryDb.setType("");
        searchHistoryDb.save();
        //2、执行搜索业务
        //3、填充搜索结果
    }


    @Deprecated
    public void initHistoryData() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            try {
                FILE_NAME = this.getFilesDir() + "/searchHistory.txt";
                File file = new File(FILE_NAME);
                if (file.exists()) {
                    FileInputStream inputStream = this.openFileInput(FILE_NAME);
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                    char[] buff = new char[inputStream.available()];
                    inputStreamReader.read(buff);
                    inputStream.close();
                    inputStreamReader.close();
                    cacheLine = new String(buff);
                } else {
                    file.createNewFile();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ToastUtil.show("未检测到SD卡，缓存读取失败");
        }
    }

    @Deprecated
    public void initInterface() {
        if (!TextUtils.isEmpty(cacheLine)) {
            historyArray = cacheLine.split(",");
        }
    }

    @Override
    public void fillData() {
        Connector.getDatabase();
        historyDBList = DataSupport.findAll(SearchHistoryDb.class);
        if (historyDBList.size() == 0) {llSearchHistory.setVisibility(View.GONE);}
        View inflate = View.inflate(this, R.layout.layout_history_search_foot, null);
        TextView clearBtt = (TextView) inflate.findViewById(R.id.bt_history_clear);
        clearBtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        lvSearchHistory.addFooterView(inflate);
        if (historyDBList != null) {
            historySearchAdapter = new HistorySearchAdapter(this, historyDBList);
            lvSearchHistory.setAdapter(historySearchAdapter);
        }
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("确定清空搜索记录？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                historyDBList.clear();
                historySearchAdapter.notifyDataSetChanged();
                llSearchHistory.setVisibility(View.GONE);
                DataSupport.deleteAll(SearchHistoryDb.class);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
