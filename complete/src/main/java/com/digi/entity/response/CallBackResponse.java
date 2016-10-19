package com.digi.entity.response;

import com.digi.entity.db.PhoneAuthLog;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
@Data
public class CallBackResponse extends SuccessResultResponse {
	@ApiModelProperty(value = "Account data")
	private PhoneAuthLog account;
	private Date callDate;

	public CallBackResponse (PhoneAuthLog account, boolean success) {
		this.account = account;
		this.callDate = Calendar.getInstance().getTime();
		this.setSuccess(Boolean.compare(success, false));
	}

	public MultiValueMap<String, String> toParams () {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.set("account", getAccount().getPhone());
		params.set("success", String.valueOf(getSuccess()));
		params.set("confirmDate", String.valueOf(getAccount().getConfirmDate()));
		params.set("callDate", String.valueOf(getCallDate()));
		return params;
	}
}
