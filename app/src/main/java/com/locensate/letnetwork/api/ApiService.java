package com.locensate.letnetwork.api;

import com.locensate.letnetwork.bean.ControlDeviceHistoryData;
import com.locensate.letnetwork.bean.ControlDeviceLatest;
import com.locensate.letnetwork.bean.ControlDeviceReadParams;
import com.locensate.letnetwork.bean.ControlEquipmentEntity;
import com.locensate.letnetwork.bean.DeviceInfoEntity;
import com.locensate.letnetwork.bean.FilterCompensationEntity;
import com.locensate.letnetwork.bean.FilterCompensationHistory;
import com.locensate.letnetwork.bean.FilterCompensationLatestData;
import com.locensate.letnetwork.bean.HealthOverDataEntity;
import com.locensate.letnetwork.bean.ImportantMachine;
import com.locensate.letnetwork.bean.KanBanDataEntity;
import com.locensate.letnetwork.bean.Login;
import com.locensate.letnetwork.bean.Logout;
import com.locensate.letnetwork.bean.MachineFilterTag;
import com.locensate.letnetwork.bean.MachineInfoEntity;
import com.locensate.letnetwork.bean.MachineInfoHealthyManagerEntity;
import com.locensate.letnetwork.bean.MonitorEquipmentEntity;
import com.locensate.letnetwork.bean.MonitorEquipmentHistoryData;
import com.locensate.letnetwork.bean.MonitorEquipmentLatestData;
import com.locensate.letnetwork.bean.MotorEfficiencyBaseEntity;
import com.locensate.letnetwork.bean.MotorEfficiencyData;
import com.locensate.letnetwork.bean.MotorEfficiencyLoadEntity;
import com.locensate.letnetwork.bean.MotorEfficiencyLoadPercentEntity;
import com.locensate.letnetwork.bean.MotorFgpData;
import com.locensate.letnetwork.bean.MotorListEntity;
import com.locensate.letnetwork.bean.OnlyMsg;
import com.locensate.letnetwork.bean.Organizations;
import com.locensate.letnetwork.bean.OverviewAllAnalysisEntity;
import com.locensate.letnetwork.bean.OverviewEfficiencyAnalysisEntity;
import com.locensate.letnetwork.bean.OverviewHealthAnalysisEntity;
import com.locensate.letnetwork.bean.OverviewLoadAnalysisEntity;
import com.locensate.letnetwork.bean.OverviewMotor;
import com.locensate.letnetwork.bean.RemoteParamEntity;
import com.locensate.letnetwork.bean.RemoteParams;
import com.locensate.letnetwork.bean.TestBean;
import com.locensate.letnetwork.bean.UserInfo;
import com.locensate.letnetwork.bean._User;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * 接口
 *
 * @author xiaobinghe
 */


public interface ApiService {
    /**
     * 请求登录
     *
     * @param login login of entity
     * @return Observable of User information
     */
    @POST("user/login")
    Observable<_User> login(@Body Login login);

    /**
     * 请求注销
     *
     * @param logout logout of entity
     * @return msg of success or fail
     */
    @POST("user/logout")
    Observable<OnlyMsg> logout(@Body Logout logout);

    /**
     * 上传头像
     *
     * @param file the path of avatar
     * @return
     */
    @Multipart
    @POST("upload/user/avatar")
    Observable<OnlyMsg> upLoadAvatar(@Part("file\";filename=\"head.jpg\"") RequestBody file);

    /**
     * 绑定头像
     *
     * @param userId user id
     * @param info   user info
     * @return UserInfo entity of observable object
     */
    @PUT("user/{userId}")
    Observable<UserInfo> bindAvatar(@Path("userId") long userId, @Body UserInfo.DataBean info);

    /**
     * 请求用户所在的组织结构
     *
     * @param userId user id
     * @return user organizations structures
     */
    @GET("user/{userId}/organizations")
    Observable<Organizations> getOrganizations(@Path("userId") long userId);

    /**
     * request motor overview pass by organizationId
     *
     * @param organizationId
     * @return
     */
    @GET("/motor/motorCount")
    Observable<OverviewMotor> getMotorOverview(@Query("organizationId") long organizationId);

    /**
     * mark or cancel important machine
     *
     * @param machine
     * @return
     */
    @POST("/wholeEquipment/markImportant")
    Observable postImportantMachine(@Body ImportantMachine machine);


    /**
     * 获取到概览页健康分析数据
     *
     * @param organizationId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/overview/organization/{organizationId}/healthAnalysis")
    Observable<OverviewHealthAnalysisEntity> getHealthyAnalysisData(@Path("organizationId") long organizationId, @Query("startTime") long startTime, @Query("endTime") long endTime);


    /**
     * 获取到概览页负载分析数据
     *
     * @param organizationId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/overview/organization/{organizationId}/loadAnalysis")
    Observable<OverviewLoadAnalysisEntity> getLoadAnalysisData(@Path("organizationId") long organizationId, @Query("startTime") long startTime, @Query("endTime") long endTime);

    /**
     * 获取到概览页能效分析数据
     *
     * @param organizationId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/overview/organization/{organizationId}/efficiencyAnalysis")
    Observable<OverviewEfficiencyAnalysisEntity> getEfficiencyAnalysisData(@Path("organizationId") long organizationId, @Query("startTime") long startTime, @Query("endTime") long endTime);

    /**
     * 获取概览页总体分析数据
     *
     * @param organizationId
     * @param startMills
     * @param endMills
     * @return
     */
    @GET("/overview/organization/{organizationId}/overallAnalysis")
    Observable<OverviewAllAnalysisEntity> getOverAllAnalysisData(@Path("organizationId") long organizationId, @Query("startTime") long startMills, @Query("endTime") long endMills);


    /**
     * 获取电机列表
     *
     * @param organizationId
     * @param startTime
     * @param endTime
     * @param pageNum
     * @param pageSize
     * @param ratedpowerorder
     * @return
     */
    @GET("/motor/organization/{organizationId}/list")
    Observable<MotorListEntity> getMotorList(@Path("organizationId") long organizationId, @Query("startTime") long startTime, @Query("endTime") long endTime,
                                             @Query("pageNum") int pageNum, @Query("pageSize") int pageSize, @Query("ratedpowerorder") String ratedpowerorder);


    /**
     * get filter tags of machines
     *
     * @return
     */
    @GET("/tags/filterTags")
    Observable<MachineFilterTag> getFilterTags();

    /**
     * 根据Id获取关键参数配置
     *
     * @param configKeyParamId
     * @return
     */
    @GET("/keyparam/{configKeyParamId} ")
    Observable<RemoteParamEntity> getKeyParamConfig(@Path("configKeyParamId") long configKeyParamId);

    /**
     * 获取远程参数列表
     *
     * @param deviceType
     * @param deviceId
     * @return
     */
    @GET("/keyparam/list ")
    Observable<RemoteParams> getRemoteParams(@Query("deviceType") long deviceType, @Query("deviceId") long deviceId);

    /**
     * 根据控制设备Id获取控制设备信息
     *
     * @param controlEquipment
     * @return
     */
    @GET("/controlEquipment/{controlEquipmentId}")
    Observable<ControlEquipmentEntity> getControlEquipment(@Path("controlEquipmentId") long controlEquipment);

    /**
     * 根据滤波补偿设备Id获取滤波补偿设备信息
     *
     * @param filterCompensationEquipmentId
     * @return
     */
    @GET("/filter-compensation-equipment/{filterCompensationEquipmentId}")
    Observable<FilterCompensationEntity> getFilterCompensation(@Path("filterCompensationEquipmentId") long filterCompensationEquipmentId);

    /**
     * 根据设备Id查看某一项数据的历史数据
     *
     * @param filterCompensationEquipmentId
     * @param tagName
     * @param rangType
     * @return
     */
    @GET("/filter-compensation-equipment/{filterCompensationEquipmentId}/historyData")
    Observable<FilterCompensationHistory> getFilterCompensationHistoryData(@Path("filterCompensationEquipmentId") long filterCompensationEquipmentId, @Query("tagName") String tagName, @Query("rangeType") String rangType
            , @Query("start") long start, @Query("end") long end);


    /**
     * 获取滤波补偿设备的最新数据
     *
     * @param filterCompensationEquipmentId
     * @return
     */
    @GET("/filter-compensation-equipment/{filterCompensationEquipmentId}/lastInfo")
    Observable<FilterCompensationLatestData> getFilterCompensationLatestData(@Path("filterCompensationEquipmentId") long filterCompensationEquipmentId);

    /**
     * 根据监测设备Id获取监测设备信息
     *
     * @param monitorEquipmentId
     * @return
     */
    @GET("/monitor-equipment/{monitorEquipmentId} ")
    Observable<MonitorEquipmentEntity> getMonitorEquipment(@Path("monitorEquipmentId") long monitorEquipmentId);


    /**
     * 监测设备历史数据
     *
     * @param motorId
     * @param tagName
     * @param start
     * @param end
     * @param aggregator
     * @param samplingValue
     * @param interpolationFrequency
     * @return
     */
    @GET("/motorDataInfo/motor/{motorId}/historyData")
    Observable<MonitorEquipmentHistoryData> getMonitorEquipmentHistoryData(@Path("motorId") long motorId, @Query("tagName") String tagName,
                                                                           @Query("start") long start, @Query("end") long end, @Query("aggregator") String aggregator,
                                                                           @Query("samplingValue") String samplingValue, @Query("interpolationFrequency") String interpolationFrequency);

    /**
     * 获取监测设备的最新数据
     *
     * @param monitorEquipmentId
     * @return
     */
    @GET("/monitor-equipment/{monitorEquipmentId}/lastInfo")
    Observable<MonitorEquipmentLatestData> getMonitorEquipmentLatestData(@Path("monitorEquipmentId") long monitorEquipmentId);

    /**
     * 根据设备Id获取设备信息
     *
     * @param wholeEquipmentId
     * @return
     */
    @GET("/wholeEquipment/{wholeEquipmentId}")
    Observable<DeviceInfoEntity> getDeviceInfoById(@Path("wholeEquipmentId") long wholeEquipmentId);

    /**
     * 获取控制设备的某项数据的历史数据
     *
     * @param controlEquipmentId
     * @param tagName
     * @param rangType
     * @param start
     * @param end
     * @return
     */
    @GET("/controlEquipment/{controlEquipmentId}/historyData ")
    Observable<ControlDeviceHistoryData> getControlEquipmentHistory(@Path("controlEquipmentId") long controlEquipmentId, @Query("tagName") String tagName, @Query("rangeType") String rangType, @Query("start") long start, @Query("end") long end);

    /**
     * 获取控制设备的最新数据
     *
     * @param controlEquipmentId
     * @return
     */
    @GET("/controlEquipment/{controlEquipmentId}/lastInfo")
    Observable<ControlDeviceLatest> getControlDeviceLatestData(@Path("controlEquipmentId") long controlEquipmentId);

    /**
     * 获取控制设备的可读取参数列表
     *
     * @param controlEquipmentId
     * @return
     */
    @GET("/controlEquipment/{controlEquipmentId}/readParams")
    Observable<ControlDeviceReadParams> getControlDeviceReadableParams(@Path("controlEquipmentId") long controlEquipmentId);

    /**
     * 获取设备信息健康管理数据
     *
     * @param motorId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/healthyManage/motor/{motorId}/healthyInfo")
    Observable<MachineInfoHealthyManagerEntity> getMachineInfoHealthyManagerData(@Path("motorId") long motorId, @Query("startTime") long startTime, @Query("endTime") long endTime);

    /**
     * 获取能效基本数据
     *
     * @param motorId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/energyManage/motor/{motorId}/efficiencyBasicData")
    Observable<MotorEfficiencyBaseEntity> getEfficiencyBaseData(@Path("motorId") long motorId, @Query("startTime") long startTime, @Query("endTime") long endTime);

    /**
     * 获取电机效率数据
     *
     * @param motorId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/energyManage/motor/{motorId}/efficiencyData")
    Observable<MotorEfficiencyData> getMotorEfficiencyData(@Path("motorId") long motorId, @Query("startTime") long startTime, @Query("endTime") long endTime);


    @GET("")
    Observable<MotorFgpData> getMotorFgpData();

    /**
     * 获取到电机能效管理负载数据
     *
     * @param motorId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/energyManage/motor/{motorId}/loadingData")
    Observable<MotorEfficiencyLoadEntity> getMotorEfficiencyLoadData(@Path("motorId") long motorId, @Query("startTime") long startTime, @Query("endTime") long endTime);

    /**
     * 获取到电机能效管理负载百分比数据
     *
     * @param motorId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/energyManage/motor/{motorId}/loadingPercent")
    Observable<MotorEfficiencyLoadPercentEntity> getMotorEfficiencyLoadPercentData(@Path("motorId") long motorId, @Query("startTime") long startTime, @Query("endTime") long endTime);


    /**
     * 获取设备信息页详情
     *
     * @param motorId
     * @return
     */
    @GET("/machine/{motorId}/machineInfo")
    Observable<MachineInfoEntity> getMachineInfoData(@Path("motorId") long motorId);

    /**
     * 获取温度超标数据
     *
     * @param motorId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/healthyManage/motor/{motorId}/temperaturelist")
    Observable<HealthOverDataEntity> getOverTempData(@Path("motorId") long motorId, @Query("startTime") long startTime, @Query("endTime") long endTime);

    /**
     * 获取振动超标数据
     *
     * @param motorId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/healthyManage/motor/{motorId}/vibrationlist")
    Observable<HealthOverDataEntity> getSharkData(@Path("motorId") long motorId, @Query("startTime") long startTime, @Query("endTime") long endTime);

    /**
     * 获取电子过热Q5数据
     *
     * @param motorId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/healthyManage/motor/{motorId}/shortElectricOverloadList")
    Observable<HealthOverDataEntity> getElectricHotterQ5(@Path("motorId") long motorId, @Query("startTime") long startTime, @Query("endTime") long endTime);

    /**
     * 获取电子过热Q30数据
     *
     * @param motorId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/healthyManage/motor/{motorId}/longElectricOverloadList")
    Observable<HealthOverDataEntity> getElectricHotterQ30(@Path("motorId") long motorId, @Query("startTime") long startTime, @Query("endTime") long endTime);

    /**
     * 获取最大启动次数数据
     *
     * @param motorId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/healthyManage/motor/{motorId}/maxStartList")
    Observable<HealthOverDataEntity> getStartCountData(@Path("motorId") long motorId, @Query("startTime") long startTime, @Query("endTime") long endTime);

    /**
     * 获取过流数据
     *
     * @param motorId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/healthyManage/motor/{motorId}/overCurrentList")
    Observable<HealthOverDataEntity> getOverCurrentData(@Path("motorId") long motorId, @Query("startTime") long startTime, @Query("endTime") long endTime);

    /**
     * 获取电机的最新数据
     *
     * @param motorId
     * @return
     */
    @GET("/motorDataInfo/motor/{motorId}/lastInfo")
    Observable<TestBean> getMotorLastData(@Path("motorId") long motorId);

    /**
     * 看板数据
     *
     * @param organizationId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GET("/board/organization/{organizationId}/boardList")
    Observable<KanBanDataEntity> getKanBanData(@Path("organizationId") long organizationId, @Query("pageNum") int pageNum, @Query("pageSize") int pageSize);
}
