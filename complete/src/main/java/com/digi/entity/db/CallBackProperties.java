package com.digi.entity.db;

import com.digi.entity.IdEntity;
import com.digi.entity.enums.CallbackHttpMethod;
import com.digi.entity.request.AccountToConfirm;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import static java.util.Objects.nonNull;

/**
 * Created by tymoshenkol on 05-Oct-16.
 */

@Data
@Embeddable
@NoArgsConstructor
public class CallBackProperties  {

	@Column(name = "callbackuri")
	private String callBackUri;

	@Column(name = "callbackmethod")
	@Enumerated(EnumType.STRING)
	private CallbackHttpMethod callBackMethod;

	public CallBackProperties (String callBackUri, String callBackMethod) {
		setCallBackUri(callBackUri);
		initCallBackMethod(callBackMethod);
	}

	private void initCallBackMethod(String method){
		setCallBackMethod(CallbackHttpMethod.valueOf(method));
	}
	public CallbackHttpMethod toHttpMethod () {
		if (callBackMethod != null) {
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
