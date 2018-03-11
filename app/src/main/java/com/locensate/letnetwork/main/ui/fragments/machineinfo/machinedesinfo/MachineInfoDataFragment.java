package com.locensate.letnetwork.main.ui.fragments.machineinfo.machinedesinfo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.bean.MachineInfoEntity;
import com.locensate.letnetwork.main.ui.machineinfo.MachineInfoActivity;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 设备-信息
 *
 * @author xiaobinghe
 */

public class MachineInfoDataFragment extends BaseFragment<MachineInfoDataPresenter, MachineInfoDataModel> implements MachineInfoDataContract.View {
    @BindView(R.id.tv_machine_type_des)
    TextView mTvMachineTypeDes;
    @BindView(R.id.tv_machine_default_power)
    TextView mTvMachineDefaultPower;
    @BindView(R.id.tv_machine_control_machine)
    TextView mTvMachineControlMachine;
    @BindView(R.id.tv_machine_control_model)
    TextView mTvMachineControlModel;
    @BindView(R.id.tv_machine_path)
    TextView mTvMachinePath;
    @BindView(R.id.tv_machine_install_place)
    TextView mTvMachineInstallPlace;
    @BindView(R.id.tv_machine_install_time)
    TextView mTvMachineInstallTime;
    @BindView(R.id.iv_1)
    ImageView mIv1;
    @BindView(R.id.iv_motor_status)
    ImageView mIvMotorStatus;
    @BindView(R.id.tv_motor_status)
    TextView mTvMotorStatus;
    @BindView(R.id.tv_motor_default_power)
    TextView mTvMotorDefaultPower;
    @BindView(R.id.tv_motor_default_voltage)
    TextView mTvMotorDefaultVoltage;
    @BindView(R.id.tv_motor_default_current)
    TextView mTvMotorDefaultCurrent;
    @BindView(R.id.tv_motor_default_efficiency)
    TextView mTvMotorDefaultEfficiency;
    @BindView(R.id.tv_motor_model)
    TextView mTvMotorModel;
    @BindView(R.id.tv_motor_type)
    TextView mTvMotorType;
    @BindView(R.id.tv_motor_energy_efficiency_level)
    TextView mTvMotorEnergyEfficiencyLevel;
    @BindView(R.id.tv_motor_cool_type)
    TextView mTvMotorCoolType;
    @BindView(R.id.tv_motor_install_type)
    TextView mTvMotorInstallType;
    @BindView(R.id.tv_motor_ji_num)
    TextView mTvMotorJiNum;
    @BindView(R.id.tv_motor_empty_load_lose)
    TextView mTvMotorEmptyLoadLose;
    @BindView(R.id.tv_motor_factory_produce)
    TextView mTvMotorFactoryProduce;
    @BindView(R.id.tv_motor_install_time)
    TextView mTvMotorInstallTime;
    @BindView(R.id.tv_motor_remake)
    TextView mTvMotorRemake;
    @BindView(R.id.ll_machine_monitor_info)
    LinearLayout mLlMachineMonitorInfo;
    @BindView(R.id.iv_2)
    ImageView mIv2;
    @BindView(R.id.iv_control_machine_icon)
    ImageView mIvControlMachineIcon;
    @BindView(R.id.tv_control_machine_type)
    TextView mTvControlMachineType;
    @BindView(R.id.tv_control_machine_brand)
    TextView mTvControlMachineBrand;
    @BindView(R.id.tv_control_machine_model)
    TextView mTvControlMachineModel;
    @BindView(R.id.tv_control_machine_default_power)
    TextView mTvControlMachineDefaultPower;
    @BindView(R.id.tv_control_machine_input_voltage)
    TextView mTvControlMachineInputVoltage;
    @BindView(R.id.tv_control_machine_output_voltage)
    TextView mTvControlMachineOutputVoltage;
    @BindView(R.id.tv_control_machine_other_path)
    TextView mTvControlMachineOtherPath;
    @BindView(R.id.tv_control_machine_control_type)
    TextView mTvControlMachineControlType;
    @BindView(R.id.tv_control_machine_center_point_link)
    TextView mTvControlMachineCenterPointLink;
    @BindView(R.id.tv_control_machine_control_info_type)
    TextView mTvControlMachineControlInfoType;
    @BindView(R.id.tv_control_machine_install_time)
    TextView mTvControlMachineInstallTime;
    @BindView(R.id.tv_control_machine_link_compute_pointer)
    TextView mTvControlMachineLinkComputePointer;
    @BindView(R.id.tv_control_machine_remake)
    TextView mTvControlMachineRemake;
    @BindView(R.id.ll_machine_control_info)
    LinearLayout mLlMachineControlInfo;
    @BindView(R.id.iv_3)
    ImageView mIv3;
    @BindView(R.id.iv_smart_switch_icon)
    ImageView mIvSmartSwitchIcon;
    @BindView(R.id.tv_smart_switch_type)
    TextView mTvSmartSwitchType;
    @BindView(R.id.tv_smart_switch_brand)
    TextView mTvSmartSwitchBrand;
    @BindView(R.id.tv_smart_switch_model)
    TextView mTvSmartSwitchModel;
    @BindView(R.id.tv_smart_switch_install_time)
    TextView mTvSmartSwitchInstallTime;
    @BindView(R.id.tv_smart_switch_link_compute_pointer)
    TextView mTvSmartSwitchLinkComputePointer;
    @BindView(R.id.tv_smart_switch_remark)
    TextView mTvSmartSwitchRemark;
    @BindView(R.id.ll_smart_switch_info)
    LinearLayout mLlSmartSwitchInfo;
    @BindView(R.id.iv_4)
    ImageView mIv4;
    @BindView(R.id.iv_electric_instrument_icon)
    ImageView mIvElectricInstrumentIcon;
    @BindView(R.id.tv_electric_instrument_type)
    TextView mTvElectricInstrumentType;
    @BindView(R.id.tv_electric_instrument_brand)
    TextView mTvElectricInstrumentBrand;
    @BindView(R.id.tv_electric_instrument_model)
    TextView mTvElectricInstrumentModel;
    @BindView(R.id.tv_electric_instrument_install_time)
    TextView mTvElectricInstrumentInstallTime;
    @BindView(R.id.tv_electric_instrument_link_compute_pointer)
    TextView mTvElectricInstrumentLinkComputePointer;
    @BindView(R.id.tv_machine_monitoring_machine_meter_back_path_mark1)
    TextView mTvMachineMonitoringMachineMeterBackPathMark1;
    @BindView(R.id.ll_electric_instrument_meter_back_path)
    LinearLayout mLlElectricInstrumentMeterBackPath;
    @BindView(R.id.tv_electric_instrument_remark)
    TextView mTvElectricInstrumentRemark;
    @BindView(R.id.ll_electric_instrument_info)
    LinearLayout mLlElectricInstrumentInfo;
    @BindView(R.id.iv_5)
    ImageView mIv5;
    @BindView(R.id.iv_monitor_equipment_icon)
    ImageView mIvMonitorEquipmentIcon;
    @BindView(R.id.tv_monitor_equipment_type)
    TextView mTvMonitorEquipmentType;
    @BindView(R.id.tv_monitor_equipment_brand)
    TextView mTvMonitorEquipmentBrand;
    @BindView(R.id.tv_monitor_equipment_model)
    TextView mTvMonitorEquipmentModel;
    @BindView(R.id.tv_monitor_equipment_install_time)
    TextView mTvMonitorEquipmentInstallTime;
    @BindView(R.id.tv_monitor_equipment_compute_pointer)
    TextView mTvMonitorEquipmentComputePointer;
    @BindView(R.id.tv_monitor_machine_remark)
    TextView mTvMonitorMachineRemark;
    @BindView(R.id.ll_monitor_equipment_info)
    LinearLayout mLlMonitorEquipmentInfo;
    @BindView(R.id.iv_6)
    ImageView mIv6;
    @BindView(R.id.iv_apf_pfc_icon)
    ImageView mIvApfPfcIcon;
    @BindView(R.id.tv_apf_pfc_type)
    TextView mTvApfPfcType;
    @BindView(R.id.tv_apf_pfc_brand)
    TextView mTvApfPfcBrand;
    @BindView(R.id.tv_apf_pfc_model)
    TextView mTvApfPfcModel;
    @BindView(R.id.tv_apf_pfc_install_time)
    TextView mTvApfPfcInstallTime;
    @BindView(R.id.tv_apf_pfc_link_compute_pointer)
    TextView mTvApfPfcLinkComputePointer;
    @BindView(R.id.tv_apf_pfc_remark)
    TextView mTvApfPfcRemark;
    @BindView(R.id.ll_apf_pfc_info)
    LinearLayout mLlApfPfcInfo;
    @BindView(R.id.ll_control_need_gone1)
    LinearLayout mLlControlNeedGone1;
    @BindView(R.id.ll_control_need_gone2)
    LinearLayout mLlControlNeedGone2;
    @BindView(R.id.ll_motor)
    LinearLayout mLlMotor;
    @BindView(R.id.ll_control_equipment)
    LinearLayout mLlControlEquipment;
    @BindView(R.id.ll_smart_switch)
    LinearLayout mLlSmartSwitch;
    @BindView(R.id.ll_electric_instrument)
    LinearLayout mLlElectricInstrument;
    @BindView(R.id.ll_monitor_equipment)
    LinearLayout mLlMonitorEquipment;
    @BindView(R.id.ll_apf_pfc)
    LinearLayout mLlApfPfc;

    private RotateAnimation mRotateUp;
    private RotateAnimation mRotateDown;
    private boolean initComplete = false;

    @Override
    protected void initView() {
        initComplete = true;
        mTvMachineTypeDes.setText("——");
        mTvMachineDefaultPower.setText("——");
        mTvMachineControlMachine.setText("——");
        mTvMachineControlModel.setText("——");
        mTvMachinePath.setText("——");
        mTvMachineInstallTime.setText("——");
        mTvMachineInstallPlace.setText("——");

        mTvMotorStatus.setText("状态：——");
        mIvMotorStatus.setImageResource(R.drawable.shape_monitor_status_red);
        mTvMotorDefaultPower.setText("——");
        mTvMotorDefaultVoltage.setText("——");
        mTvMotorDefaultCurrent.setText("——");
        mTvMotorDefaultEfficiency.setText("——");
        mTvMotorModel.setText("——");
        mTvMotorType.setText("——");
        mTvMotorEnergyEfficiencyLevel.setText("——");
        mTvMotorCoolType.setText("——");
        mTvMotorInstallType.setText("——");
        mTvMotorJiNum.setText("——");
        mTvMotorEmptyLoadLose.setText("——");
        mTvMotorFactoryProduce.setText("——");
        mTvMotorInstallTime.setText("——");
        mTvMotorRemake.setText("——");

        mTvControlMachineType.setText("——");
        mTvControlMachineBrand.setText("——");
        mTvControlMachineModel.setText("——");
        mTvControlMachineDefaultPower.setText("——");
        mTvControlMachineInputVoltage.setText("——");
        mTvControlMachineOutputVoltage.setText("——");
        mTvControlMachineOtherPath.setText("——");
        mTvControlMachineControlType.setText("——");
        mTvControlMachineControlInfoType.setText("——");
        mTvControlMachineInstallTime.setText("——");
        mTvControlMachineLinkComputePointer.setText("——");
        mTvControlMachineRemake.setText("——");

        mTvSmartSwitchType.setText("——");
        mTvSmartSwitchBrand.setText("——");
        mTvSmartSwitchModel.setText("——");
        mTvSmartSwitchInstallTime.setText("——");
        mTvSmartSwitchLinkComputePointer.setText("——");
        mTvSmartSwitchRemark.setText("——");

        mTvMonitorEquipmentType.setText("——");
        mTvMonitorEquipmentBrand.setText("——");
        mTvMonitorEquipmentModel.setText("——");
        mTvMonitorEquipmentInstallTime.setText("——");
        mTvMonitorEquipmentComputePointer.setText("——");
        mTvMonitorMachineRemark.setText("——");


        mTvApfPfcType.setText("——");
        mTvApfPfcBrand.setText("——");
        mTvApfPfcModel.setText("——");
        mTvApfPfcInstallTime.setText("——");
        mTvApfPfcLinkComputePointer.setText("——");
        mTvApfPfcRemark.setText("——");
        initAnimation();
    }

    @Override
    public int getInflaterView() {
        return R.layout.fragment_machine_info;
    }

    @Override
    protected void lazyLoad() {
        if (initComplete) {

        }
    }

    @Override
    public void dispatchData(MachineInfoEntity.DataBean data) {
        DecimalFormat df = new DecimalFormat("0.00");
        MachineInfoEntity.DataBean.WholeEquipmentInfoBean whole_equipment_info = data.getWhole_equipment_info();
        MachineInfoEntity.DataBean.MotorInfoBean motor_info = data.getMotor_info();
        MachineInfoEntity.DataBean.ControlMachineInfoBean control_machine_info = data.getControl_machine_info();
        MachineInfoEntity.DataBean.SmartSwitchInfoBean smart_switch_info = data.getSmart_switch_info();
        MachineInfoEntity.DataBean.ElectricInstrumentInfoBean electric_instrument_info = data.getElectric_instrument_info();
        MachineInfoEntity.DataBean.MeterInfoBean meter_info = data.getMeter_info();
        MachineInfoEntity.DataBean.ApfPfcInfoBean apf_pfc_info = data.getApf_pfc_info();
        //1、设备信息部分
        if (whole_equipment_info != null && motor_info != null) {
            mTvMachineTypeDes.setText(whole_equipment_info.getWhole_equipment_type_name());
            mTvMachineDefaultPower.setText(motor_info.getRated_power() + "kW");
            if (control_machine_info != null) {
                mTvMachineControlMachine.setText(control_machine_info.getControl_equipment_name());
                mTvMachineControlModel.setText(control_machine_info.getModel_number_name());
            }
            mTvMachinePath.setText(whole_equipment_info.getOrganization_name());
            mTvMachineInstallPlace.setText(whole_equipment_info.getWhole_equipment_location());
            mTvMachineInstallTime.setText(motor_info.getInstallation_year());
        }

        if (motor_info != null) {
            mTvMotorStatus.setText(motor_info.getStatus() == 1 ? "状态：在用" : "状态：报废");
            mIvMotorStatus.setImageResource(motor_info.getStatus() == 1 ? R.drawable.shape_monitor_status_green : R.drawable.shape_monitor_status_red);
            mTvMotorDefaultPower.setText(motor_info.getRated_power() + "kW");
            mTvMotorDefaultVoltage.setText(motor_info.getRated_voltage_name());
            mTvMotorDefaultCurrent.setText(df.format(motor_info.getRated_current()) + "A");
            mTvMotorDefaultEfficiency.setText(df.format(motor_info.getRated_efficiency()));
            mTvMotorModel.setText(motor_info.getModel_number_name());
            mTvMotorType.setText(motor_info.getEquipment_type_name());
            mTvMotorEnergyEfficiencyLevel.setText(motor_info.getEnergy_efficiency_grade_name());
            mTvMotorCoolType.setText(motor_info.getCooling_way_name());
            mTvMotorInstallType.setText(motor_info.getInstallation_name().equals("0") ? "——" : motor_info.getInstallation_name());
            mTvMotorJiNum.setText(motor_info.getPole_number_name());
            mTvMotorEmptyLoadLose.setText(df.format(motor_info.getRated_noload_loss()) + "kW");
            mTvMotorFactoryProduce.setText(motor_info.getBrand_name());
            mTvMotorInstallTime.setText(motor_info.getInstallation_year());
            mTvMotorRemake.setText(motor_info.getElectric_motor_description());
        } else {
            mLlMotor.setVisibility(View.GONE);
        }

        if (control_machine_info != null) {
            String typeName = control_machine_info.getEquipment_type_name();
            if (typeName.equals("直接启动") || typeName.equals("星角启动") || typeName.equals("自耦启动")) {
                mTvControlMachineType.setText(typeName);
                mTvControlMachineRemake.setText(TextUtils.isEmpty(control_machine_info.getControl_equipment_description()) ? "——" : control_machine_info.getControl_equipment_description());
                mLlControlNeedGone1.setVisibility(View.GONE);
                mLlControlNeedGone2.setVisibility(View.GONE);
            } else {
                mTvControlMachineType.setText(typeName);
                mTvControlMachineBrand.setText(TextUtils.isEmpty(control_machine_info.getBrand_name()) ? "——" : control_machine_info.getBrand_name());
                mTvControlMachineModel.setText(TextUtils.isEmpty(control_machine_info.getModel_number_name()) ? "——" : control_machine_info.getModel_number_name());
                mTvControlMachineDefaultPower.setText(control_machine_info.getRated_power() == 0 ? "——" : df.format(control_machine_info.getRated_power()) + "kW");
                mTvControlMachineInputVoltage.setText(TextUtils.isEmpty(control_machine_info.getRated_voltage_name()) ? "——" : control_machine_info.getRated_voltage_name());
                mTvControlMachineOutputVoltage.setText(TextUtils.isEmpty(control_machine_info.getOutput_voltage_class_name()) ? "——" : control_machine_info.getOutput_voltage_class_name());
                mTvControlMachineOtherPath.setText(TextUtils.isEmpty(control_machine_info.getBypass_scheme_name()) ? "——" : control_machine_info.getBypass_scheme_name());
                mTvControlMachineControlType.setText(TextUtils.isEmpty(control_machine_info.getControl_mode_name()) ? "——" : control_machine_info.getControl_mode_name());
                mTvControlMachineControlInfoType.setText(TextUtils.isEmpty(control_machine_info.getControl_signal_name()) ? "——" : control_machine_info.getControl_signal_name());
                mTvControlMachineInstallTime.setText(TextUtils.isEmpty(control_machine_info.getControl_equipment_installation_time()) ? "——" : control_machine_info.getControl_equipment_installation_time());
                mTvControlMachineLinkComputePointer.setText(TextUtils.isEmpty(control_machine_info.getSn()) ? "——" : control_machine_info.getSn() + control_machine_info.getChannel() + control_machine_info.getSlave());
                mTvControlMachineRemake.setText(TextUtils.isEmpty(control_machine_info.getControl_equipment_description()) ? "——" : control_machine_info.getControl_equipment_description());
                mTvControlMachineCenterPointLink.setText(TextUtils.isEmpty(control_machine_info.getControl_equipment_location()) ? "——" : control_machine_info.getControl_equipment_location());
            }
        } else {
            mLlControlEquipment.setVisibility(View.GONE);
        }

        if (smart_switch_info != null) {
            mTvSmartSwitchType.setText(TextUtils.isEmpty(smart_switch_info.getEquipment_type_name()) ? "——" : smart_switch_info.getEquipment_type_name());
            mTvSmartSwitchBrand.setText(TextUtils.isEmpty(smart_switch_info.getBrand_name()) ? "——" : smart_switch_info.getBrand_name());
            mTvSmartSwitchModel.setText(TextUtils.isEmpty(smart_switch_info.getModel_number_name()) ? "——" : smart_switch_info.getModel_number_name());
            mTvSmartSwitchInstallTime.setText(TextUtils.isEmpty(smart_switch_info.getMonitor_equipment_installation_time()) ? "——" : smart_switch_info.getMonitor_equipment_installation_time());
            mTvSmartSwitchLinkComputePointer.setText(TextUtils.isEmpty(smart_switch_info.getSn()) ? "——" : smart_switch_info.getSn() + smart_switch_info.getChannel() + smart_switch_info.getSlave());
            mTvSmartSwitchRemark.setText(TextUtils.isEmpty(smart_switch_info.getMonitor_equipment_description()) ? "——" : smart_switch_info.getMonitor_equipment_description());
        } else {
            mLlSmartSwitch.setVisibility(View.GONE);
        }

        if (electric_instrument_info != null) {
            mTvElectricInstrumentType.setText(TextUtils.isEmpty(electric_instrument_info.getEquipment_type_name()) ? "——" : electric_instrument_info.getEquipment_type_name());
            mTvElectricInstrumentBrand.setText(TextUtils.isEmpty(electric_instrument_info.getBrand_name()) ? "——" : electric_instrument_info.getBrand_name());
            mTvElectricInstrumentModel.setText(TextUtils.isEmpty(electric_instrument_info.getModel_number_name()) ? "——" : electric_instrument_info.getModel_number_name());
            mTvElectricInstrumentInstallTime.setText(TextUtils.isEmpty(electric_instrument_info.getMonitor_equipment_installation_time()) ? "——" : electric_instrument_info.getMonitor_equipment_installation_time());
            mTvElectricInstrumentLinkComputePointer.setText(TextUtils.isEmpty(electric_instrument_info.getSn()) ? "无" : electric_instrument_info.getSn() + electric_instrument_info.getChannel() + electric_instrument_info.getSlave());
            mTvMachineMonitoringMachineMeterBackPathMark1.setText(TextUtils.isEmpty(electric_instrument_info.getLoop_mark()) ? "——" : electric_instrument_info.getLoop_mark());
            mTvElectricInstrumentRemark.setText(TextUtils.isEmpty(electric_instrument_info.getMonitor_equipment_description()) ? "——" : electric_instrument_info.getMonitor_equipment_description());
        } else {
            mLlElectricInstrument.setVisibility(View.GONE);
        }

        if (meter_info != null) {
            mTvMonitorEquipmentType.setText(TextUtils.isEmpty(meter_info.getEquipment_type_name()) ? "——" : meter_info.getEquipment_type_name());
            mTvMonitorEquipmentBrand.setText(TextUtils.isEmpty(meter_info.getBrand_name()) ? "——" : meter_info.getBrand_name());
            mTvMonitorEquipmentModel.setText(TextUtils.isEmpty(meter_info.getModel_number_name()) ? "——" : meter_info.getModel_number_name());
            mTvMonitorEquipmentInstallTime.setText(TextUtils.isEmpty(meter_info.getMonitor_equipment_installation_time()) ? "——" : meter_info.getMonitor_equipment_installation_time());
            mTvMonitorEquipmentComputePointer.setText(TextUtils.isEmpty(meter_info.getSn()) ? "——" : meter_info.getSn() + meter_info.getChannel() + meter_info.getSlave());
            mTvMonitorMachineRemark.setText(TextUtils.isEmpty(meter_info.getMonitor_equipment_description()) ? "——" : meter_info.getMonitor_equipment_description());
        } else {
            mLlMonitorEquipment.setVisibility(View.GONE);
        }

        if (apf_pfc_info != null) {
            mTvApfPfcType.setText(TextUtils.isEmpty(apf_pfc_info.getEquipment_type_name()) ? "——" : apf_pfc_info.getEquipment_type_name());
            mTvApfPfcBrand.setText(TextUtils.isEmpty(apf_pfc_info.getBrand_name()) ? "——" : apf_pfc_info.getBrand_name());
            mTvApfPfcModel.setText(TextUtils.isEmpty(apf_pfc_info.getModel_number_name()) ? "——" : apf_pfc_info.getModel_number_name());
            mTvApfPfcInstallTime.setText("——");
            mTvApfPfcLinkComputePointer.setText(TextUtils.isEmpty(apf_pfc_info.getSn()) ? "——" : apf_pfc_info.getSn() + apf_pfc_info.getChannel() + apf_pfc_info.getSlave());
            mTvApfPfcRemark.setText(TextUtils.isEmpty(apf_pfc_info.getFilter_compensation_description()) ? "——" : apf_pfc_info.getFilter_compensation_description());
        } else {
            mLlApfPfc.setVisibility(View.GONE);
        }


    }

    @Override
    public Bundle getMotorInfo() {
        return ((MachineInfoActivity) getActivity()).getMachineInfo();
    }


    private void initAnimation() {
        mRotateUp = new RotateAnimation(0f, 180f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateDown = new RotateAnimation(180f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateUp.setDuration(300L);
        mRotateUp.setFillAfter(true);
        mRotateDown.setDuration(300L);
        mRotateDown.setFillAfter(true);
    }

    @OnClick({R.id.iv_1, R.id.iv_2, R.id.iv_3, R.id.iv_4, R.id.iv_5, R.id.iv_6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_1:
                mIv1.startAnimation(mLlMachineMonitorInfo.getVisibility() == View.VISIBLE ? mRotateUp : mRotateDown);
                mLlMachineMonitorInfo.setVisibility(mLlMachineMonitorInfo.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                break;
            case R.id.iv_2:
                mIv2.startAnimation(mLlMachineControlInfo.getVisibility() == View.VISIBLE ? mRotateUp : mRotateDown);
                mLlMachineControlInfo.setVisibility(mLlMachineControlInfo.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                break;
            case R.id.iv_3:
                mIv3.startAnimation(mLlSmartSwitchInfo.getVisibility() == View.VISIBLE ? mRotateUp : mRotateDown);
                mLlSmartSwitchInfo.setVisibility(mLlSmartSwitchInfo.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                break;
            case R.id.iv_4:
                mIv4.startAnimation(mLlElectricInstrumentInfo.getVisibility() == View.VISIBLE ? mRotateUp : mRotateDown);
                mLlElectricInstrumentInfo.setVisibility(mLlElectricInstrumentInfo.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                break;
            case R.id.iv_5:
                mIv5.startAnimation(mLlMonitorEquipmentInfo.getVisibility() == View.VISIBLE ? mRotateUp : mRotateDown);
                mLlMonitorEquipmentInfo.setVisibility(mLlMonitorEquipmentInfo.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                break;
            case R.id.iv_6:
                mIv6.startAnimation(mLlApfPfcInfo.getVisibility() == View.VISIBLE ? mRotateUp : mRotateDown);
                mLlApfPfcInfo.setVisibility(mLlApfPfcInfo.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                break;
            default:
                break;
        }
    }
}
