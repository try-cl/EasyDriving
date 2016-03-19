package com.easyDriving.mapper;

import com.easyDriving.pojo.Subject;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by hexing on 15-12-15.
 */
public interface SubjectMapper {
    //添加测试题
    @Insert("insert into subject(s_type,s_chapter,s_content,answer_a,answer_b,answer_c,answer_d,answer,s_analyze,s_image) values(#{s_type},#{s_chapter},#{s_content},#{answer_a},#{answer_b},#{answer_c},#{answer_d},#{answer},#{s_analyze},#{s_image})")
    public void addTest(Subject subject);
}
