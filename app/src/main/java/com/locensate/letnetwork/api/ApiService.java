package com.locensate.letnetwork.api;

import com.locensate.letnetwork.bean.ImportantMachine;
import com.locensate.letnetwork.bean.Login;
import com.locensate.letnetwork.bean.Logout;
import com.locensate.letnetwork.bean.MachineFilterTag;
import com.locensate.letnetwork.bean.OnlyMsg;
import com.locensate.letnetwork.bean.Organizations;
import com.locensate.letnetwork.bean.OverviewMotor;
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
     * request login
     *
     * @param login login of entity
     * @return Observable of User information
     */
    @POST("user/login")
    Observable<_User> login(@Body Login login);

    /**
     * request logout
     *
     * @param logout logout of entity
     * @return msg of success or fail
     */
    @POST("user/logout")
    Observable<OnlyMsg> logout(@Body Logout logout);

    /**
     * upload user avatar
     *
     * @param file the path of avatar
     * @return
     */
    @Multipart
    @POST("upload/user/avatar")
    Observable<OnlyMsg> upLoadAvatar(@Part("file\";filename=\"head.jpg\"") RequestBody file);

    /**
     * bind avatar
     *
     * @param userId user id
     * @param info   user info
     * @return UserInfo entity of observable object
     */
    @PUT("user/{userId}")
    Observable<UserInfo> bindAvatar(@Path("userId") long userId, @Body UserInfo.DataBean info);

    /**
     * request organizations of user
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
}
