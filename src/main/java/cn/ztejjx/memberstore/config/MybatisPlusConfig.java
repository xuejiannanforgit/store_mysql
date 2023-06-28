package cn.ztejjx.memberstore.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.ztejjx.memberstore.mapper")
public class MybatisPlusConfig {

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return  new PaginationInterceptor();
    }

    //注入拦截器
//    @Bean
//    public MyInterceptor myInterceptor(){
//        return new MyInterceptor();
//    }
//
//    @Bean //SQL分析插件
//    public SqlExplainInterceptor sqlExplainInterceptor(){
//        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
//        List<ISqlParser> list = new ArrayList<>();
//        list.add(new BlockAttackSqlParser()); //全表更新、删除的阻断器
//        sqlExplainInterceptor.setSqlParserList(list);
//        return sqlExplainInterceptor;
//    }
//
//    @Bean
//    public  MySqlInjector mySqlInjector()
//    {
//        return new MySqlInjector();
//    }
    //乐观锁插件-
//    @Bean
//     public OptimisticLockerInterceptor optimisticLockerInterceptor()
//    {
//        return new OptimisticLockerInterceptor();
//    }


}
