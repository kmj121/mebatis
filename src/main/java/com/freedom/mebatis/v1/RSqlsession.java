package com.freedom.mebatis.v1;

/**
 * @Description 提供一个可使用的接口给用户
 * @Author Roger
 * @Version V1.0.0
 * @Since 1.0
 * @Date 3/3/21
 */
public class RSqlsession {
    // 配置类，加载mybatis的配置，以及mapper.xml中的内容
    private RConfiguration configuration;
    // 执行器，执行sql语句
    private RExecutor executor;

    // 初始化配置类和执行器
    public RSqlsession(RConfiguration configuration, RExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    /**
     * 查询一条数据
     * @param statementId 类名+方法名 用来定位sql语句
     * @param param       填充到sql语句中的参数
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statementId, Object param) {
        // 获取sql语句
        String sql = RConfiguration.sqlMappers.getString(statementId);
        // 如果sql不为空，则交给执行器query方法执行
        if(null != sql && !"".equals(sql)) {
            return executor.query(sql, param);
        }
        return null;
    }

    public <T> T getMapper(Class clazz) {
        return configuration.getMapper(clazz, this);
    }

}
