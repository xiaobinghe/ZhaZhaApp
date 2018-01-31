package com.locensate.letnetwork.api;

import com.locensate.letnetwork.bean.ControlDeviceLatest;
import com.locensate.letnetwork.bean.ControlDeviceReadParams;
import com.locensate.letnetwork.bean.ControlEquipmentEntity;
import com.locensate.letnetwork.bean.DeviceInfoEntity;
import com.locensate.letnetwork.bean.FilterCompensationEntity;
import com.locensate.letnetwork.bean.FilterCompensationHistory;
import com.locensate.letnetwork.bean.FilterCompensationLatestData;
import com.locensate.letnetwork.bean.HistoryData;
import com.locensate.letnetwork.bean.ImportantMachine;
import com.locensate.letnetwork.bean.Login;
import com.locensate.letnetwork.bean.Logout;
import com.locensate.letnetwork.bean.MachineFilterTag;
import com.locensate.letnetwork.bean.MonitorEquipment;
import com.locensate.letnetwork.bean.OnlyMsg;
import com.locensate.letnetwork.bean.Organizations;
import com.locensate.letnetwork.bean.OverviewMotor;
import com.locensate.letnetwork.bean.RemoteParamEntity;
import com.locensate.letnetwork.bean.RemoteParams;
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
    Observable<MonitorEquipment> getMonitorEquipment(@Path("monitorEquipmentId") long monitorEquipmentId);

    /**
     *
     * 获取监测设备历史数据
     * @param monitorEquipmentId
     * @param tagName
     * @param rangType
     * @param start
     * @param end
     * @return
     */
    @GET("/monitor-equipment/{monitorEquipmentId}/historyData")
    Observable<MonitorEquipmentHistoryData> getMonitorEquipmentHistoryData(@Path("monitorEquipmentId") long monitorEquipmentId, @Query("tagName") String tagName,
                                                @Query("rangType") String rangType, @Query("start") long start, @Query("end") long end);

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
    Observable<HistoryData> getControlEquipmentHistory(@Path("controlEquipmentId") long controlEquipmentId, @Query("tagName") String tagName, @Query("rangeType") String rangType, @Query("start") long start, @Query("end") long end);

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

}
