package com.linzzxz.emos.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "检验用户姓名")
public class TestSayHelloForm {
    // @NotBlank(message = "姓名不能为空")
    // 规定姓名必须为数量为2-15之间的简体汉字
    // @Pattern(regexp = "^[\\u4e00-\\u9fa5]{2,15}$")
    @Schema(description = "姓名")
    private String name;
}
