package com.lk.chat.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResResultDto<T> {
    @Schema(description = "결과갯수")
    private int resultCnt;

    @Schema(description = "성공여부")
    private boolean success = false;

    @Schema(description = "결과데이터")
    private T result;

    public ResResultDto(T dto) {
        this.result = dto;
        this.resultCnt = dto == null ? 0 : 1;
        this.success = true;
    }
}
