package zhong.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    这个自定义的Ribbon 不能放在 启动类 同级的包下
 */
@Configuration
public class ZhongRule {

    @Bean
    public IRule myRule(){
        return new ZhongRandomRule(); //调用自定义的Ribbon策略
    }



}
