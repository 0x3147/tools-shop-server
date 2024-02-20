package com.jump.toolsshop.config;

import com.github.yitter.contract.IdGeneratorException;
import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import com.jump.toolsshop.common.IdGeneratorProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class IdGeneratorConfig {

    private final IdGeneratorProperties idGeneratorProperties;

    public IdGeneratorConfig(IdGeneratorProperties idGeneratorProperties) {
        this.idGeneratorProperties = idGeneratorProperties;
    }

    @PostConstruct
    public void initIdGenerator() {
        IdGeneratorOptions options = new IdGeneratorOptions((short) idGeneratorProperties.getWorkerId());

        try {
            YitIdHelper.setIdGenerator(options);
        } catch (IdGeneratorException e) {
            // 处理异常，可能是日志记录或者重新抛出一个RuntimeException
            throw new RuntimeException("Failed to initialize ID Generator", e);
        }
    }
}
