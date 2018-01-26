package com.locensate.letnetwork.main.ui.fragments.machineinfo.machinedesinfo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

import static com.locensate.letnetwork.R.id.tv_machine_control_model;


/**
 * 设备-信息
 *
 * @author xiaobinghe
 */

public class MachineInfoDataFragment extends BaseFragment<MachineInfoDataPresenter, MachineInfoDataModel> implements MachineInfoDataContract.View {
    @BindView(R.id.tv_machine_type_des)
    TextView tvMachineTypeDes;
    @BindView(R.id.tv_machine_default_power)
    TextView tvMachineDefaultPower;
    @BindView(R.id.tv_machine_control_machine)
    TextView tvMachineControlMachine;
    @BindView(tv_machine_control_model)
    TextView tvMachineControlModel;
    @BindView(R.id.tv_machine_path)
    TextView tvMachinePath;
    @BindView(R.id.tv_machine_install_place)
    TextView tvMachineInstallPlace;
    @BindView(R.id.tv_machine_install_time)
    TextView tvMachineInstallTime;
    @BindView(R.id.iv_machine_monitor_info)
    ImageView ivMachineMonitorInfo;
    @BindView(R.id.iv_machine_monitor_status)
    ImageView ivMachineMonitorStatus;
    @BindView(R.id.tv_machine_monitor_status)
    TextView tvMachineMonitorStatus;
    @BindView(R.id.tv_machine_monitor_default_power)
    TextView tvMachineMonitorDefaultPower;
    @BindView(R.id.tv_machine_monitor_voltage)
    TextView tvMachineMonitorVoltage;
    @BindView(R.id.tv_machine_monitor_default_current)
    TextView tvMachineMonitorDefaultCurrent;
    @BindView(R.id.tv_machine_monitor_default_efficiency)
    TextView tvMachineMonitorDefaultEfficiency;
    @BindView(R.id.tv_machine_monitor_model)
    TextView tvMachineMonitorModel;
    @BindView(R.id.tv_machine_monitor_type)
    TextView tvMachineMonitorType;
    @BindView(R.id.tv_machine_monitor_energy_efficiency_level)
    TextView tvMachineMonitorEnergyEfficiencyLevel;
    @BindView(R.id.tv_machine_monitor_cool_type)
    TextView tvMachineMonitorCoolType;
    @BindView(R.id.tv_machine_monitor_install_type)
    TextView tvMachineMonitorInstallType;
    @BindView(R.id.tv_machine_monitor_ji_num)
    TextView tvMachineMonitorJiNum;
    @BindView(R.id.tv_machine_monitor_empty_load_lose)
    TextView tvMachineMonitorEmptyLoadLose;
    @BindView(R.id.tv_machine_monitor_factory_produce)
    TextView tvMachineMonitorFactoryProduce;
    @BindView(R.id.tv_machine_monitor_install_time)
    TextView tvMachineMonitorInstallTime;
    @BindView(R.id.tv_machine_monitor_remake)
    TextView tvMachineMonitorRemake;
    @BindView(R.id.iv_machine_control_info)
    ImageView ivMachineControlInfo;
    @BindView(R.id.tv_machine_control_machine_type)
    TextView tvMachineControlMachineType;
    @BindView(R.id.tv_machine_control_machine_brand)
    TextView tvMachineControlMachineBrand;
    @BindView(R.id.tv_machine_control_machine_model)
    TextView tvMachineControlMachineModel;
    @BindView(R.id.tv_machine_control_machine_default_power)
    TextView tvMachineControlMachineDefaultPower;
    @BindView(R.id.tv_machine_control_machine_input_voltage)
    TextView tvMachineControlMachineInputVoltage;
    @BindView(R.id.tv_machine_control_machine_output_voltage)
    TextView tvMachineControlMachineOutputVoltage;
    @BindView(R.id.tv_machine_control_machine_other_path)
    TextView tvMachineControlMachineOtherPath;
    @BindView(R.id.tv_machine_control_machine_control_type)
    TextView tvMachineControlMachineControlType;
    @BindView(R.id.tv_machine_control_machine_center_point_link)
    TextView tvMachineControlMachineCenterPointLink;
    @BindView(R.id.tv_machine_control_machine_control_info_type)
    TextView tvMachineControlMachineControlInfoType;
    @BindView(R.id.tv_machine_control_machine_install_time)
    TextView tvMachineControlMachineInstallTime;
    @BindView(R.id.tv_machine_control_machine_link_compute_pointer)
    TextView tvMachineControlMachineLinkComputePointer;
    @BindView(R.id.tv_machine_control_machine_remake)
    TextView tvMachineControlMachineRemake;
    @BindView(R.id.iv_machine_monitoring_machine_info)
    ImageView ivMachineMonitoringMachineInfo;
    @BindView(R.id.iv_machine_monitoring_machine_image1)
    ImageView ivMachineMonitoringMachineImage1;
    @BindView(R.id.tv_machine_monitoring_machine_type1)
    TextView tvMachineMonitoringMachineType1;
    @BindView(R.id.tv_machine_monitoring_machine_brand1)
    TextView tvMachineMonitoringMachineBrand1;
    @BindView(R.id.tv_machine_monitoring_machine_model1)
    TextView tvMachineMonitoringMachineModel1;
    @BindView(R.id.tv_machine_monitoring_machine_install_time1)
    TextView tvMachineMonitoringMachineInstallTime1;
    @BindView(R.id.tv_machine_monitoring_machine_link_compute_pointer1)
    TextView tvMachineMonitoringMachineLinkComputePointer1;
    @BindView(R.id.tv_machine_monitoring_machine_meter_back_path_mark1)
    TextView tvMachineMonitoringMachineMeterBackPathMark1;
    @BindView(R.id.ll_machine_monitoring_machine_meter_back_path1)
    LinearLayout llMachineMonitoringMachineMeterBackPath1;
    @BindView(R.id.tv_machine_monitoring_machine_remark1)
    TextView tvMachineMonitoringMachineRemark1;
    @BindView(R.id.ll_machine_monitoring_machine1)
    LinearLayout llMachineMonitoringMachine1;
    @BindView(R.id.iv_machine_monitoring_machine_image2)
    ImageView ivMachineMonitoringMachineImage2;
    @BindView(R.id.tv_machine_monitoring_machine_type2)
    TextView tvMachineMonitoringMachineType2;
    @BindView(R.id.tv_machine_monitoring_machine_brand2)
    TextView tvMachineMonitoringMachineBrand2;
    @BindView(R.id.tv_machine_monitoring_machine_model2)
    TextView tvMachineMonitoringMachineModel2;
    @BindView(R.id.tv_machine_monitoring_machine_install_time2)
    TextView tvMachineMonitoringMachineInstallTime2;
    @BindView(R.id.tv_machine_monitoring_machine_link_compute_pointer2)
    TextView tvMachineMonitoringMachineLinkComputePointer2;
    @BindView(R.id.tv_machine_monitoring_machine_meter_back_path_mark2)
    TextView tvMachineMonitoringMachineMeterBackPathMark2;
    @BindView(R.id.ll_machine_monitoring_machine_meter_back_path2)
    LinearLayout llMachineMonitoringMachineMeterBackPath2;
    @BindView(R.id.tv_machine_monitoring_machine_remark2)
    TextView tvMachineMonitoringMachineRemark2;
    @BindView(R.id.ll_machine_monitoring_machine2)
    LinearLayout llMachineMonitoringMachine2;
    @BindView(R.id.iv_machine_monitoring_machine_image3)
    ImageView ivMachineMonitoringMachineImage3;
    @BindView(R.id.tv_machine_monitoring_machine_type3)
    TextView tvMachineMonitoringMachineType3;
    @BindView(R.id.tv_machine_monitoring_machine_brand3)
    TextView tvMachineMonitoringMachineBrand3;
    @BindView(R.id.tv_machine_monitoring_machine_model3)
    TextView tvMachineMonitoringMachineModel3;
    @BindView(R.id.tv_machine_monitoring_machine_install_time3)
    TextView tvMachineMonitoringMachineInstallTime3;
    @BindView(R.id.tv_machine_monitoring_machine_link_compute_pointer3)
    TextView tvMachineMonitoringMachineLinkComputePointer3;
    @BindView(R.id.tv_machine_monitoring_machine_meter_back_path_mark3)
    TextView tvMachineMonitoringMachineMeterBackPathMark3;
    @BindView(R.id.ll_machine_monitoring_machine_meter_back_path3)
    LinearLayout llMachineMonitoringMachineMeterBackPath3;
    @BindView(R.id.tv_machine_monitoring_machine_remark3)
    TextView tvMachineMonitoringMachineRemark3;
    @BindView(R.id.ll_machine_monitoring_machine3)
    LinearLayout llMachineMonitoringMachine3;
    @BindView(R.id.ll_machine_monitor_info)
    LinearLayout mLlMachineMonitorInfo;
    @BindView(R.id.ll_machine_control_info)
    LinearLayout mLlMachineControlInfo;
    @BindView(R.id.ll_machine_monitoring_machine)
    LinearLayout mLlMachineMonitoringMachine;

    /*public static MachineInfoDataFragment getInstance() {
        if (null == instance) {
            instance = new MachineInfoDataFragment();
        }
        return instance;
    }*/

    @Override
    protected void initView() {

    }

    @Override
    public int getInflaterView() {
        return R.layout.fragment_machine_info;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void initView(String data) {
        tvMachineTypeDes.setText("皮带机");
        tvMachineDefaultPower.setText("55kW");
        tvMachineControlMachine.setText("电机智能优化控制器");
        tvMachineControlModel.setText("SGY");
        tvMachinePath.setText("烧结厂/一车间");
        tvMachineInstallTime.setText("2010年6月");
        tvMachineInstallPlace.setText("配电室1");

//        tvMachineAgeDes.setText("5年");
//        tvMachineDianliuDes.setText("15A");
//        tvMachineDianyaDes.setText("5KV");
//        tvMachineGonglvDes.setText("75KW");
//        tvMachineHomeDes.setText("罗圣森特/研发部");
//        tvMachineLocalDes.setText("电机测试实验室");
//        tvMachineMotorTypeDes.setText("鼠笼式三相异步电机");
//        tvMachineSpeedDes.setText("7500r/min");
//        tvMachineTypeDes.setText("测试设备");
    }

    @OnClick({R.id.iv_machine_monitor_info, R.id.iv_machine_control_info, R.id.iv_machine_monitoring_machine_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_machine_monitor_info:
                mLlMachineMonitorInfo.setVisibility(mLlMachineMonitorInfo.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                break;
            case R.id.iv_machine_control_info:
                mLlMachineControlInfo.setVisibility(mLlMachineControlInfo.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                break;
            case R.id.iv_machine_monitoring_machine_info:
                mLlMachineMonitoringMachine.setVisibility(mLlMachineMonitoringMachine.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                break;
        }
    }
}
