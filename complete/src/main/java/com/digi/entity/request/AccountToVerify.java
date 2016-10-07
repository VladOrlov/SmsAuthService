package com.digi.entity.request;


import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by tymoshenkol on 25-Aug-16.
 */
@Data
@RequiredArgsConstructor
public class AccountToVerify implements Serializable {
	@NonNull private String phone;
}
