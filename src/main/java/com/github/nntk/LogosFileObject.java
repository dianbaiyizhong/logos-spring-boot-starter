package com.github.nntk;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogosFileObject {

    private String name;
    private Long lastModifiedTime;
    private Long size;
}
