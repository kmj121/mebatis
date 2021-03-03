package com.freedom.mebatis.v1.mapper;

/**
 * @Author: qingshan
 */
public interface BlogMapper {
    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    public Blog selectBlogById(Integer bid);

}
