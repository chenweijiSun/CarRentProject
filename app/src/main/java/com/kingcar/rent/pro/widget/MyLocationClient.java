package com.kingcar.rent.pro.widget;

import android.content.Context;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

public final class MyLocationClient {
	private LocationClient mLocationClient;
	private MyLocationListener locationListener;
	public MyLocationClient(Context context, MyLocationListener locationListener) {
		this.mLocationClient=new LocationClient(context);
		this.locationListener=locationListener;
		InitLocation();

	}
	private void InitLocation() {
		// 设置定位参数
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
		option.setCoorType("bd09ll"); // 设置坐标类型
		option.setScanSpan(10000); // 10分钟扫描1次
		// 需要地址信息，设置为其他任何值（string类型，且不能为null）时，都表示无地址信息。
		option.setAddrType("all");
		// 设置产品线名称。强烈建议您使用自定义的产品线名称，方便我们以后为您提供更高效准确的定位服务。
		option.setProdName("通过GPS定位我当前的位置");
		// 禁用启用缓存定位数据
		option.disableCache(true);
		// 设置定位方式的优先级。
		// 当gps可用，而且获取了定位结果时，不再发起网络请求，直接返回给用户坐标。这个选项适合希望得到准确坐标位置的用户。如果gps不可用，再发起网络请求，进行定位。
		option.setPriority(LocationClientOption.GpsFirst);
		option.setIgnoreKillProcess(true);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
		option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
		option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

		mLocationClient.setLocOption(option);
		mLocationClient.registerLocationListener(new MyListener());
		mLocationClient.start();
	}
	private class MyListener implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
//			saveLocation(location);
			locationListener.location(location);
			mLocationClient.stop();
		}
	}
	//全局保存定位信息
	private void saveLocation(BDLocation location){
		if(location.getAddrStr()!=null){
			String province = location.getProvince();
			String city = location.getCity();
			String district = location.getDistrict();
			double latitude = location.getLatitude();
			double longitude = location.getLongitude();
			String addrStr = location.getAddrStr();
		}
	}
	public interface MyLocationListener{
		void location(BDLocation arg0);
	}
	public void stopLocation(){
		if(mLocationClient!=null){
			mLocationClient.stop();
		}
	}
}
