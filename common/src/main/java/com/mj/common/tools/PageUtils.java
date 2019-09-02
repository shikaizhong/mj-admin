package com.mj.common.tools;

import com.github.pagehelper.PageInfo;
import com.mj.dao.vo.PageRequest;
import com.mj.dao.vo.PageResult;

/**
 * 将分页信息封装到统一的接口
 * @param pageRequest
 * @param
 * @return
 */
public class PageUtils {

        public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
            PageResult pageResult = new PageResult();
            pageResult.setPageNum(pageInfo.getPageNum());
            pageResult.setPageSize(pageInfo.getPageSize());
            pageResult.setTotalSize(pageInfo.getTotal());
            pageResult.setTotalPages(pageInfo.getPages());
            pageResult.setContent(pageInfo.getList());
            return pageResult;
        }
}
