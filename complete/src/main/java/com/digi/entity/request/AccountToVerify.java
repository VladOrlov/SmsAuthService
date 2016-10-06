package com.digi.entity.request;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by tymoshenkol on 25-Aug-16.
 */
@Data
public class AccountToVerify implements Serializable {
	private String phone;
}
