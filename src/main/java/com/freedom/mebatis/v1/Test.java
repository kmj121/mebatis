package com.freedom.mebatis.v1;

import com.freedom.mebatis.v1.mapper.BlogMapper;

/**
 * @author kanmeijie
 */
public class Test {
    public static void main(String[] args) {
        RSqlsession sqlSession = new RSqlsession(new RConfiguration(), new RExecutor());
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper.selectBlogById(1);
    }
}
