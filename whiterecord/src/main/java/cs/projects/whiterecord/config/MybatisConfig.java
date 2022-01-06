package cs.projects.whiterecord.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value="cs.projects.whiterecord.Mapper")
public class MybatisConfig {

}
