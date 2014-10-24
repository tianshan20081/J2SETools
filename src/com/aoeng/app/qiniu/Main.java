package com.aoeng.app.qiniu;

public class Main {

	public static void main(String[] args) {
		String upToken = QNApi.getUpToken();
		System.out.println(upToken);
		upToken = "sUp_H-7FJu_nie9pCBVoQ_dHxtIdXBWnU5nqnc7x:Zm8Xiz_sKdXkb-cyypPT8kvcL58=:eyJzY29wZSI6Im5va2VlIiwiZGVhZGxpbmUiOjE0MTQwMzk0NjN9";
		String bucket = QNApi.getBucketByUpToken(upToken);
		System.out.println(bucket);
	}

}
