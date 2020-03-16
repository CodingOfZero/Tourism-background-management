package com.mydomain;

import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    //根据id信息查询会员
    @Select("select * from members where id=#{id}")
    public Members findById(int id);
}
