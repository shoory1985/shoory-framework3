package com.shoory.framework.starter.api.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorizedRequest extends BaseRequest {
	@ApiModelProperty(hidden = true)
	private String _scene = "";
	
	//@NotBlank(message = BaseResponse.ERROR_INVALID_CREDENTIAL)
	@ApiModelProperty(hidden = true)
	private String _credential;
}
