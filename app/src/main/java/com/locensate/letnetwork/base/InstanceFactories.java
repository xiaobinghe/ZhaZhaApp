package com.locensate.letnetwork.base;

import com.locensate.letnetwork.main.ui.dataanalysis.DataAnalysisModel;
import com.locensate.letnetwork.main.ui.dataanalysis.DataAnalysisPresenter;
import com.locensate.letnetwork.main.ui.deletemsg.DeleteMessageModel;
import com.locensate.letnetwork.main.ui.deletemsg.DeleteMessagePresenter;
import com.locensate.letnetwork.main.ui.fragments.currentorder.CurrentOrderModel;
import com.locensate.letnetwork.main.ui.fragments.currentorder.CurrentOrderPresenter;
import com.locensate.letnetwork.main.ui.fragments.historyorder.HistoryOrderModel;
import com.locensate.letnetwork.main.ui.fragments.historyorder.HistoryOrderPresenter;
import com.locensate.letnetwork.main.ui.fragments.machine.MachineModel;
import com.locensate.letnetwork.main.ui.fragments.machine.MachinePresenter;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.MachineInfoEnergyManagerModel;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.MachineInfoEnergyManagerPresenter;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyefficiency.EnergyEfficiencyModel;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyefficiency.EnergyEfficiencyPresenter;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyfgp.EnergyFengGuPingModel;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyfgp.EnergyFengGuPingPresenter;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyLoad.EnergyLoadModel;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyLoad.EnergyLoadPresenter;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.MachineInfoFixManagerModel;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.MachineInfoFixManagerPresenter;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.healthmanager.MachineInfoHealthyManagerModel;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.healthmanager.MachineInfoHealthyManagerPresenter;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.machinedesinfo.MachineInfoDataModel;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.machinedesinfo.MachineInfoDataPresenter;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo.MachineInfoMonitorDataModel;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo.MachineInfoMonitorDataPresenter;
import com.locensate.letnetwork.main.ui.fragments.mine.MineFragmentModel;
import com.locensate.letnetwork.main.ui.fragments.mine.MineFragmentPresenter;
import com.locensate.letnetwork.main.ui.fragments.overview.OverviewModel;
import com.locensate.letnetwork.main.ui.fragments.overview.OverviewPresenter;
import com.locensate.letnetwork.main.ui.fragments.overview.healthyanalysis.OverviewHealthyAnalysisModel;
import com.locensate.letnetwork.main.ui.fragments.overview.healthyanalysis.OverviewHealthyAnalysisPresenter;
import com.locensate.letnetwork.main.ui.fragments.overview.loadanalysis.OverviewLoadAnalysisModel;
import com.locensate.letnetwork.main.ui.fragments.overview.loadanalysis.OverviewLoadAnalysisPresenter;
import com.locensate.letnetwork.main.ui.fragments.overview.rateanalysis.OverviewRateAnalysisModel;
import com.locensate.letnetwork.main.ui.fragments.overview.rateanalysis.OverviewRateAnalysisPresenter;
import com.locensate.letnetwork.main.ui.home.HomeModel;
import com.locensate.letnetwork.main.ui.home.HomePresenter;
import com.locensate.letnetwork.main.ui.login.LoginModel;
import com.locensate.letnetwork.main.ui.login.LoginPresenter;
import com.locensate.letnetwork.main.ui.machineinfo.MachineInfoModel;
import com.locensate.letnetwork.main.ui.machineinfo.MachineInfoPresenter;
import com.locensate.letnetwork.main.ui.message.MessageModel;
import com.locensate.letnetwork.main.ui.message.MessagePresenter;
import com.locensate.letnetwork.main.ui.orderdetail.OrderDetailModel;
import com.locensate.letnetwork.main.ui.orderdetail.OrderDetailPresenter;
import com.locensate.letnetwork.main.ui.ordermsg.OrderMsgModel;
import com.locensate.letnetwork.main.ui.ordermsg.OrderMsgPresenter;
import com.locensate.letnetwork.main.ui.riplanmsg.RiPlanMsgModel;
import com.locensate.letnetwork.main.ui.riplanmsg.RiPlanPresenter;
import com.locensate.letnetwork.main.ui.search.SearchModel;
import com.locensate.letnetwork.main.ui.search.SearchPresenter;
import com.locensate.letnetwork.main.ui.smartmsg.SmartMsgModel;
import com.locensate.letnetwork.main.ui.smartmsg.SmartMsgPresenter;
import com.locensate.letnetwork.utils.ToastUtil;

/**
 * -------------------------------------
 * <p>
 * 项目名称： LetNetwork
 * </p>
 * 版权：locensate.com 版权所有 2017
 * <p>
 * 公司主页：http://www.locensate.com/
 * </p>
 * 描述：
 * <p>
 * 时间：
 * </p>
 * 修改历史：
 * <p>
 * 修改时间：
 * </p>
 * 修改描述：
 * <p>
 * -------------------------------------
 *
 * @author xiaobinghe
 */


public class InstanceFactories {
    public static Object create(Class mClass) throws IllegalAccessException, InstantiationException {
        switch (mClass.getSimpleName()) {
/*Presenter实例*/
            case "DataAnalysisPresenter":
                return new DataAnalysisPresenter();
            case "DeleteMessagePresenter":
                return new DeleteMessagePresenter();
            case "CurrentOrderPresenter":
                return new CurrentOrderPresenter();
            case "HistoryOrderPresenter":
                return new HistoryOrderPresenter();
            case "MachinePresenter":
                return new MachinePresenter();
            case "MachineInfoDataPresenter":
                return new MachineInfoDataPresenter();
            case "MachineInfoEnergyManagerPresenter":
                return new MachineInfoEnergyManagerPresenter();
            case "EnergyEfficiencyPresenter":
                return new EnergyEfficiencyPresenter();
            case "EnergyLoadPresenter":
                return new EnergyLoadPresenter();
            case "MachineInfoFixManagerPresenter":
                return new MachineInfoFixManagerPresenter();
            case "MachineInfoHealthyManagerPresenter":
                return new MachineInfoHealthyManagerPresenter();
            case "MachineInfoMonitorDataPresenter":
                return new MachineInfoMonitorDataPresenter();
            case "MineFragmentPresenter":
                return new MineFragmentPresenter();
            case "OverviewPresenter":
                return new OverviewPresenter();
            case "OverviewHealthyAnalysisPresenter":
                return new OverviewHealthyAnalysisPresenter();
            case "OverviewLoadAnalysisPresenter":
                return new OverviewLoadAnalysisPresenter();
            case "OverviewRateAnalysisPresenter":
                return new OverviewRateAnalysisPresenter();
            case "HomePresenter":
                return new HomePresenter();
            case "LoginPresenter":
                return new LoginPresenter();
            case "MachineInfoPresenter":
                return new MachineInfoPresenter();
            case "MessagePresenter":
                return new MessagePresenter();
            case "OrderDetailPresenter":
                return new OrderDetailPresenter();
            case "OrderMsgPresenter":
                return new OrderMsgPresenter();
            case "RiPlanPresenter":
                return new RiPlanPresenter();
            case "SearchPresenter":
                return new SearchPresenter();
            case "SmartMsgPresenter":
                return new SmartMsgPresenter();
            case "EnergyFengGuPingPresenter":
                return new EnergyFengGuPingPresenter();

/*Model实例*/
            case "DataAnalysisModel":
                return new DataAnalysisModel();
            case "DeleteMessageModel":
                return new DeleteMessageModel();
            case "CurrentOrderModel":
                return new CurrentOrderModel();
            case "HistoryOrderModel":
                return new HistoryOrderModel();
            case "MachineModel":
                return new MachineModel();
            case "MachineInfoDataModel":
                return new MachineInfoDataModel();
            case "MachineInfoEnergyManagerModel":
                return new MachineInfoEnergyManagerModel();
            case "EnergyEfficiencyModel":
                return new EnergyEfficiencyModel();
            case "EnergyLoadModel":
                return new EnergyLoadModel();
            case "MachineInfoFixManagerModel":
                return new MachineInfoFixManagerModel();
            case "MachineInfoHealthyManagerModel":
                return new MachineInfoHealthyManagerModel();
            case "MachineInfoMonitorDataModel":
                return new MachineInfoMonitorDataModel();
            case "MineFragmentModel":
                return new MineFragmentModel();
            case "OverviewModel":
                return new OverviewModel();
            case "OverviewHealthyAnalysisModel":
                return new OverviewHealthyAnalysisModel();
            case "OverviewLoadAnalysisModel":
                return new OverviewLoadAnalysisModel();
            case "OverviewRateAnalysisModel":
                return new OverviewRateAnalysisModel();
            case "HomeModel":
                return new HomeModel();
            case "LoginModel":
                return new LoginModel();
            case "MachineInfoModel":
                return new MachineInfoModel();
            case "MessageModel":
                return new MessageModel();
            case "OrderDetailModel":
                return new OrderDetailModel();
            case "OrderMsgModel":
                return new OrderMsgModel();
            case "RIPlanModel":
                return new RiPlanMsgModel();
            case "SearchModel":
                return new SearchModel();
            case "SmartMsgModel":
                return new SmartMsgModel();
            case "EnergyFengGuPingModel":
                return new EnergyFengGuPingModel();
            default:
                ToastUtil.show(mClass.getSimpleName());
                return mClass.newInstance();
        }
    }
}
