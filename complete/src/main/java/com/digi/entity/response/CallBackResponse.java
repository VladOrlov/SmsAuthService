package com.digi.entity.response;

import com.digi.entity.db.PhoneAuthLog;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
		this.setSuccess(success ? 1 : 0);

	}
}
