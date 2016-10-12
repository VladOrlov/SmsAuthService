package com.digi.entity.db;

import com.digi.entity.IdEntity;
import com.digi.entity.enums.AuthStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by tymoshenkol on 05-Oct-16.
 */
@Entity
@Data
@Table(name = "dg_auth_phone")
@RequiredArgsConstructor
@NoArgsConstructor
public class PhoneAuthLog extends IdEntity {

	@NonNull
	@Column(name = "phone", length = 20, unique = true, nullable = false)
	private String phone;

	@NonNull
	@Column(name = "initdate", nullable = false)
	private Date initDate;

	@JsonIgnore
	@Column(name = "code", length = 20, nullable = false)
	private String code;

	@JsonIgnore
	@Column(name = "status", nullable = false)
	private Integer status;

	@Column(name = "confirmdate")
	private Date confirmDate;

	@Column(name = "sid")
	private String smsId;

	@Column(name = "callbackuri")
	private String callBackUri;



	public PhoneAuthLog (String phone, Date initDate, String code, AuthStatus status) {
		this(phone, initDate);
		setCode(code);
		setAuthStatus(status);
	}

	public AuthStatus getAuthStatus () {
		return AuthStatus.valueOf(status);
	}

	public void setAuthStatus (AuthStatus st) {
		setStatus(st.getId());
	}

}
