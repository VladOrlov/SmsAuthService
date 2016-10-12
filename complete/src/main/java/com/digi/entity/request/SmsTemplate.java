package com.digi.entity.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Created by tymoshenkol on 12-Oct-16.
 */
@Data
@NoArgsConstructor
public class SmsTemplate {
	@ApiModelProperty(value = "Application Name", example = "TLV")
	private String applicationName;
	@ApiModelProperty(value = "Verification Text", required = true, example = "Your #appName# verification code is #authCode#")
	@NonNull  private String verificationText;

	public String customVerificationText(String inAuthCode){
		return customText(verificationText).replaceAll(TemplateNode.authCode.ft(), inAuthCode);
	}

	private String customText(String txt){
		return applicationName!=null ? txt.replaceAll(TemplateNode.appName.ft(), applicationName): txt;
	}

	public enum TemplateNode{
		authCode, appName;

		public String ft() {
			return String.format("#%1$s#", name());
		}
	}
}
