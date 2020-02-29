package com.sxau.cs.file.man.service.mapper;

import com.sxau.cs.file.man.service.bean.FileIdQueryCondition;

import java.util.List;

/**
 * 文件关系映射
 */
public interface FileRelationMapper {

    /**
     * 按条件查询文件id
     *
     * @param fileIdQueryCondition 文件id的查询条件
     * @return 文件id
     */
    Long queryFileIdByCondition(FileIdQueryCondition fileIdQueryCondition);

    /**
     * 查询子文件
     *
     * @param parentId 父文件id
     * @return 子文件id列表
     */
    List<Long> queryFileIdListByParentId(long parentId);
}
