package com.kingcar.rent.pro.utils;

/**
 * Created by cwj on 2017/2/7.
 */

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;

import com.kingcar.rent.pro.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import me.shaohui.advancedluban.Luban;
import me.shaohui.advancedluban.OnMultiCompressListener;

import static com.kingcar.rent.pro.Constant.CROP_IMAGES;


/**
 * * 实现文件上传的工具类
 */
public class FileImageUpload {
    private static final String TAG = "uploadFile";
    private static final int TIME_OUT = 10 * 10000000; //超时时间
    private static final String CHARSET = "utf-8"; //设置编码
    public static final String SUCCESS = "1";
    public static final String FAILURE = "0";

    /**
     * android上传文件到服务器
     *
     * @param file       需要上传的文件
     * @param RequestURL 请求的rul
     * @return 返回响应的内容
     */
    public static String uploadFile(File file, String RequestURL) {
        String BOUNDARY = UUID.randomUUID().toString();
        //边界标识 随机生成
        // String PREFIX = "--" , LINE_END = "\r\n";
        String LINE_END = "\r\n";
        String PREFIX = "--";
        String CONTENT_TYPE = "multipart/form-data"; //内容类型
        try {
            URL url = new URL(RequestURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(TIME_OUT);
            conn.setConnectTimeout(TIME_OUT);
            conn.setDoInput(true); //允许输入流
            conn.setDoOutput(true); //允许输出流
            conn.setUseCaches(false); //不允许使用缓存
            conn.setRequestMethod("POST"); //请求方式
            conn.setRequestProperty("Charset", CHARSET);
            //设置编码
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
            if (file != null) {
                /** * 当文件不为空，把文件包装并且上传 */
                OutputStream outputSteam = conn.getOutputStream();
                DataOutputStream dos = new DataOutputStream(outputSteam);
                StringBuffer sb = new StringBuffer();
                sb.append(PREFIX);
                sb.append(BOUNDARY);
                sb.append(LINE_END);
                /**
                 * 这里重点注意：
                 * name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
                 * filename是文件的名字，包含后缀名的 比如:abc.png
                 */
                sb.append("Content-Disposition: form-data; name=\"imageFile\"; filename=\"" + file.getName() + "\"" + LINE_END);
                sb.append("Content-Type: application/octet-stream; charset=" + CHARSET + LINE_END);
                sb.append(LINE_END);
                dos.write(sb.toString().getBytes());
                InputStream is = new FileInputStream(file);
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = is.read(bytes)) != -1) {
                    dos.write(bytes, 0, len);
                }
                is.close();
                dos.write(LINE_END.getBytes());
                byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
                dos.write(end_data);
                dos.flush();
                /**
                 * 获取响应码 200=成功
                 * 当响应成功，获取响应的流
                 */
                int res = conn.getResponseCode();
                Log.e(TAG, "response code:" + res);
                if (res == 200) {
                    String result = convertStreamToString(conn.getInputStream());
//                    return SUCCESS;
                    return result;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FAILURE;
    }
    public static void compressAndUploadFile(Context context, File file, OnUploadListener listener){
        Luban.compress(context, file)
                .setMaxSize(300)
                .setMaxHeight(1920)
                .setMaxWidth(1080)
                .putGear(Luban.CUSTOM_GEAR)
                .launch(new OnMultiCompressListener() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onSuccess(List<File> fileList) {
//                        String phone= BaseApplication.getInstance().userInfo.getPhone();
                        String url= Constant.BASE_URL+"file/header/upload";
                        String urls="";
                        for(int i=0;i<fileList.size();i++){
                            String message = uploadFile(fileList.get(i), url);
                            try {
                                JSONObject object=new JSONObject(message);
                                String upload=object.getJSONArray("result").getString(0);
                                urls+=upload;
                                if(i!=fileList.size()-1){
                                    urls+=",";
                                }
                            } catch (JSONException e) {
                            }
                        }
                        listener.onResult(urls);
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }
    public static String getFilePathFromContentUri(Uri uri, Context mContext) {
        if ( null == uri ) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if ( scheme == null )
            data = uri.getPath();
        else if ( ContentResolver.SCHEME_FILE.equals( scheme ) ) {
            data = uri.getPath();
        } else if ( ContentResolver.SCHEME_CONTENT.equals( scheme ) ) {
            Cursor cursor = mContext.getContentResolver().query( uri, new String[] { MediaStore.Images.ImageColumns.DATA }, null, null, null );
            if ( null != cursor ) {
                if ( cursor.moveToFirst() ) {
                    int index = cursor.getColumnIndex( MediaStore.Images.ImageColumns.DATA );
                    if ( index > -1 ) {
                        data = cursor.getString( index );
                    }
                }
                cursor.close();
            }
        }
        return data;
    }

    public static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        StringBuilder sb = new StringBuilder();

        String line = null;

        try {

            while ((line = reader.readLine()) != null) {

                sb.append(line + "/n");

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                is.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }
        return sb.toString();
    }
    public interface OnUploadListener{
        void onResult(String url);
    }

    public static File cropImage(String path,Activity mActivity){
        File file =createTmpFile(mActivity);
//        File file=new File(Environment.getExternalStorageDirectory(), "/"+System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists())file.getParentFile().mkdirs();

        Uri newUri = FileProvider.getUriForFile(mActivity,
                "com.dreamlife.pro.fileprovider",
                file);
        Uri dataUrl = FileProvider.getUriForFile(mActivity,
                "com.dreamlife.pro.fileprovider",
                new File(path));
        Intent intent = new Intent("com.android.camera.action.CROP");
//        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.setDataAndType(dataUrl, "image/*");

        List<ResolveInfo> resolvedIntentActivities = mActivity.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        for (ResolveInfo resolvedIntentInfo : resolvedIntentActivities) {
            String packageName = resolvedIntentInfo.activityInfo.packageName;

            mActivity.grantUriPermission(packageName, newUri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
            mActivity.grantUriPermission(packageName, dataUrl, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }

        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, newUri);
        intent.putExtra("outputX", 480);
        intent.putExtra("outputY", 480);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());

        intent.putExtra("noFaceDetection", true);

        mActivity.startActivityForResult(intent, CROP_IMAGES);

        return file;
    }

    public static File createTmpFile(Context context){

        String state = context.getExternalCacheDir().getAbsolutePath();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            // 已挂载
            File pic = context.getExternalCacheDir();
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date());
            String fileName = "multi_image_"+timeStamp+"";
            File tmpFile = new File(pic, fileName+".jpg");
            return tmpFile;
        }else{
            File cacheDir = context.getCacheDir();
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date());
            String fileName = "multi_image_"+timeStamp+"";
            File tmpFile = new File(cacheDir, fileName+".jpg");
            return tmpFile;
        }

    }
}
