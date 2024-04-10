package com.lk.chat.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResListDto<T> {
    @Schema(description = "결과갯수")
    private int resultCnt;

    @Schema(description = "성공여부")
    private boolean success = false;

    @Schema(description = "결과데이터")
    private List<T> list;

    public ResListDto(List<T> list) {
        this.list = list;
        this.resultCnt = list.size();
        this.success = true;
    }
}
