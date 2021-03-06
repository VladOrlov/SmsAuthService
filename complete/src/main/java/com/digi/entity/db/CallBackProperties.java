package com.digi.entity.db;

import com.digi.entity.enums.CallbackHttpMethod;
import com.digi.entity.request.AccountToConfirm;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;


import static java.util.Objects.nonNull;

/**
 * Created by tymoshenkol on 05-Oct-16.
 */

@Data
@Embeddable
@NoArgsConstructor
public class CallBackProperties  {

	@Column(name = "callbackuri", length = 1000)
	private String callBackUri;

	@Column(name = "callbackmethod", length = 4)
	@Enumerated(EnumType.STRING)
	private CallbackHttpMethod callBackMethod;

	@Transient
	protected String callBackStatus;

	public CallBackProperties (String callBackUri, String callBackMethod) {
		setCallBackUri(callBackUri);
		initCallBackMethod(callBackMethod);
	}

	private void initCallBackMethod(String method){
		setCallBackMethod(CallbackHttpMethod.valueOf(method));
	}
	public CallbackHttpMethod toHttpMethod () {
		if (nonNull(callBackMethod)) {
			return callBackMethod;
		}
		return CallbackHttpMethod.POST;
	}

	public void validateCallBack (AccountToConfirm account) {
		if(nonNull(account.getCallBackUri()) ){
			setCallBackUri(account.getCallBackUri());
			if(nonNull(account.getCallBackMethod()) ){
				initCallBackMethod(account.getCallBackMethod());
			}
		}
	}
}
