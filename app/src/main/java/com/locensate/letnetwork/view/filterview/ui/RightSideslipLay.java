package com.locensate.letnetwork.view.filterview.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.bean.MachineFilterTag;
import com.locensate.letnetwork.view.filterview.adapter.RightSideslipLayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性选择的布局及逻辑
 *
 * @author xiaobinghe
 */
public class RightSideslipLay extends RelativeLayout {
    private Context mCtx;
    private ListView selectList;
    private Button resetBrand;
    private Button okBrand;
    //    private ImageView backBrand;
    private RelativeLayout mRelateLay;
    private RightSideslipLayAdapter slidLayFrameAdapter;
    private String JsonStr = "{\"operCode\": 1,\"data\": [{\"isOpen\": true,\"single_check\": 0,\"key\": \"运行效率\", \"vals\": [ { \"val\": \"经济运行\"}, {\"val\": \"非经济运行\" }, {\"val\": \"合理运行\" }]},{\"single_check\": 0,\"key\": \"平均负载\", \"vals\": [{ \"val\": \"空载\"},{ \"val\": \"轻载\"},{ \"val\": \"半载\"},{ \"val\": \"重载\"},{ \"val\": \"过载\"}],\"open\": true}," +
            "{\"isOpen\": false,\"single_check\": 0,\"key\": \"健康分析\", \"vals\": [{ \"val\": \"好\"},{ \"val\": \"较好\"},{ \"val\": \"较差\"},{ \"val\": \"差\"}],\"open\": false}," +
            "{\"isOpen\": false,\"single_check\": 0,\"key\": \"能效等级\", \"vals\": [{\"val\": \"一级能效\"},{\"val\": \"二级能效\"},{\"val\": \"三级能效\"},{\"val\": \"普通能效\"},{\"val\": \"低效\"},{\"val\": \"其他\"}],\"open\": false},{\"isOpen\": false, \"single_check\": 0, \"key\": \"控制类型\",\"vals\": [{\"val\": \"变频器\" },{\"val\": \"软启动器\" },{\"val\": \"直接启动\" },{\"val\": \"星角启动\" },{\"val\": \"其他\" }],\"open\": false}," +
            "{\"isOpen\": false,\"single_check\": 0,\"key\": \"功率范围\", \"vals\": [{ \"val\": \"0-90\"},{ \"val\": \"90-180\"},{ \"val\": \"180-250\"},{ \"val\": \"250-380\"},{ \"val\": \"380以上\"}],\"open\": false},{\"isOpen\": false,\"single_check\": 0,\"key\": \"电压等级\", \"vals\": [{ \"val\": \"9kv\"},{ \"val\": \"6kv\"},{ \"val\": \"3kv\"},{ \"val\": \"380v\"},{ \"val\": \"220v\"}],\"open\": false},{\"isOpen\": false,\"single_check\": 0,\"key\": \"设备类型\", \"vals\": [{ \"val\": \"风机\"},{ \"val\": \"水泵\"},{ \"val\": \"压缩机\"},{ \"val\": \"其他\"}],\"open\": false},{\"isOpen\": false,\"single_check\": 0,\"key\": \"安装时间\", \"vals\": [{ \"val\": \"1年内\"},{ \"val\": \"2-5年\"},{ \"val\": \"6-10年\"},{ \"val\": \"10年以上\"}],\"open\": false}]}";

    public RightSideslipLay(Context context) {
        super(context);
        mCtx = context;
        inflateView();
    }

    private void inflateView() {
        View.inflate(getContext(), R.layout.include_right_sideslip_layout, this);
        selectList = (ListView) findViewById(R.id.selsectFrameLV);
//        backBrand = (ImageView) findViewById(R.id.select_brand_back_im);
        resetBrand = (Button) findViewById(R.id.fram_reset_but);
        mRelateLay = (RelativeLayout) findViewById(R.id.select_frame_lay);
        okBrand = (Button) findViewById(R.id.fram_ok_but);
        resetBrand.setOnClickListener(mOnClickListener);
        okBrand.setOnClickListener(mOnClickListener);
//        backBrand.setOnClickListener(mOnClickListener);
        mRelateLay.setOnClickListener(mOnClickListener);
        setUpList();
    }

    private List<MachineFilterTag.DataBean.ValsBean> ValsData;

    private List<MachineFilterTag.DataBean> setUpBrandList(List<MachineFilterTag.DataBean> mAttrList) {
        if ("运行效率".equals(mAttrList.get(0).getKey())) {
            ValsData = mAttrList.get(0).getVals();
            mAttrList.get(0).setVals(getValsDatas(mAttrList.get(0).getVals()));
        }
        return mAttrList;
    }

    private MachineFilterTag attr = new Gson().fromJson(JsonStr, MachineFilterTag.class);

    private void setUpList() {
//        attr = new Gson().fromJson(JsonStr.toString(), MachineFilterTag.class);
        if (slidLayFrameAdapter == null) {
            slidLayFrameAdapter = new RightSideslipLayAdapter(mCtx, setUpBrandList(attr.getData()));
            selectList.setAdapter(slidLayFrameAdapter);
        } else {
            slidLayFrameAdapter.replaceAll(attr.getData());
        }
        slidLayFrameAdapter.setAttrCallBack(new RightSideslipLayAdapter.SelechDataCallBack() {
            @Override
            public void setupAttr(List<String> mSelectData, String key) {

            }
        });

        slidLayFrameAdapter.setMoreCallBack(new RightSideslipLayAdapter.SelechMoreCallBack() {

            @Override
            public void setupMore(List<MachineFilterTag.DataBean.ValsBean> mSelectData) {
                getPopupWindow(mSelectData);
                mDownMenu.setOnMeanCallBack(meanCallBack);
            }
        });

    }

    //在第二个页面改变后，返回时第一个界面随之改变，使用的接口回调
    private RightSideslipChildLay.onMeanCallBack meanCallBack = new RightSideslipChildLay.onMeanCallBack() {
        @Override
        public void isDisMess(boolean isDis, List<MachineFilterTag.DataBean.ValsBean> mBrandData, String str) {
            if (mBrandData != null) {
                if (attr.getData().size() > 0) {
                    ((MachineFilterTag.DataBean) attr.getData().get(0)).setVals(getValsDatas(mBrandData));
                    ((MachineFilterTag.DataBean) attr.getData().get(0)).setShowStr(str);
                }
                slidLayFrameAdapter.replaceAll(attr.getData());
            }

            dismissMenuPop();
        }
    };

    private List<MachineFilterTag.DataBean.ValsBean> getValsDatas(List<MachineFilterTag.DataBean.ValsBean> mBrandData) {
        List<MachineFilterTag.DataBean.ValsBean> mVals = new ArrayList<>();
        if (mBrandData != null && mBrandData.size() > 0) {
            for (int i = 0; i < mBrandData.size(); i++) {
                if (mVals.size() >= 8) {
                    MachineFilterTag.DataBean.ValsBean valsAdd = new MachineFilterTag.DataBean.ValsBean();
                    valsAdd.setVal("查看更多 >");
                    mVals.add(valsAdd);
                    continue;
                } else {
                    mVals.add(mBrandData.get(i));
                }
            }
            mVals = mVals.size() >= 9 ? mVals.subList(0, 9) : mVals;
            return mVals;

        }
        return null;
    }

    private OnClickListenerWrapper mOnClickListener = new OnClickListenerWrapper() {
        @Override
        protected void onSingleClick(View v) {
            switch (v.getId()) {
                case R.id.fram_reset_but:

                case R.id.fram_ok_but:
                    menuCallBack.setupCloseMean();
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * 关闭窗口
     */
    private void dismissMenuPop() {
        if (mMenuPop != null) {
            mMenuPop.dismiss();
            mMenuPop = null;
        }

    }

    /***
     * 获取PopupWindow实例
     */
    private void getPopupWindow(List<MachineFilterTag.DataBean.ValsBean> mSelectData) {
        if (mMenuPop != null) {
            dismissMenuPop();
            return;
        } else {
            initPopuptWindow(mSelectData);
        }
    }

    /**
     * 创建PopupWindow
     */
    private PopupWindow mMenuPop;
    public RightSideslipChildLay mDownMenu;

    protected void initPopuptWindow(List<MachineFilterTag.DataBean.ValsBean> mSelectData) {
        mDownMenu = new RightSideslipChildLay(getContext(), ValsData, mSelectData);
        if (mMenuPop == null) {
            mMenuPop = new PopupWindow(mDownMenu, LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        }
        mMenuPop.setBackgroundDrawable(new BitmapDrawable());
        mMenuPop.setAnimationStyle(R.style.popupWindowAnimRight);
        mMenuPop.setFocusable(true);
        mMenuPop.showAtLocation(RightSideslipLay.this, Gravity.TOP, 100, UiUtils.getStatusBarHeight(mCtx));
        mMenuPop.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                dismissMenuPop();
            }
        });
    }


    private CloseMenuCallBack menuCallBack;

    public interface CloseMenuCallBack {
        void setupCloseMean();
    }

    public void setCloseMenuCallBack(CloseMenuCallBack menuCallBack) {
        this.menuCallBack = menuCallBack;
    }

    public void setDataList(MachineFilterTag filterTag) {
        attr = filterTag;
        setUpList();
    }
}
