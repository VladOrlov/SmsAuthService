package com.digi.service;

import com.digi.entity.db.PhoneAuthLog;

import java.net.URI;

public interface CallBackService {

	URI getUri (String uri);

	boolean doCallBack (PhoneAuthLog account, boolean success);
}
