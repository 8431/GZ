package com.gz.medicine.yun.common.mapper;

import com.gz.medicine.yun.common.bean.FromBlob;

public interface FromBlobMapper {
    int deleteByPrimaryKey(String guid);

    int insert(FromBlob record);

    int insertSelective(FromBlob record);

    FromBlob selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(FromBlob record);

    int updateByPrimaryKeyWithBLOBs(FromBlob record);

    int updateByPrimaryKey(FromBlob record);
}