package com.kingcar.rent.pro.http;


import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cwj on 16/7/17.
 */
public interface IDreamRetrofit {

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("user/regUser.dm")
    Observable<String> doRegister(@FieldMap Map<String, String> map);

    @Multipart
    @POST("system/uploadFile.dm")
    Observable<String> updateHeadPhoto(@Part MultipartBody.Part imageFile,
                                       @Query("userId") Integer userId,
                                       @Query("type") Integer type,
                                       @Query("contId") String contId);




}
