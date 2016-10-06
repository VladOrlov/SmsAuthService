package com.digi.entity.request;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by tymoshenkol on 25-Aug-16.
 */
@Getter
@Setter
public class MessageToSend implements Serializable {
	private String to;
	private String text;
}
