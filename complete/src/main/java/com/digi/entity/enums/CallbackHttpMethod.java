package com.digi.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by tymoshenkol on 17-Oct-16.
 */
@Getter
@RequiredArgsConstructor
public enum CallbackHttpMethod {
	GET,
	POST;
}
