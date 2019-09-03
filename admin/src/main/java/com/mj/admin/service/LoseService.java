package com.mj.admin.service;

import com.mj.common.result.RestResult;
import com.mj.dao.entity.Lose;

import java.util.List;
import java.util.Map;

/**
 * @麦佳甘豆
 *
 * 流失管理service层
 */

public interface LoseService {

    //总记录，查询，分页
    RestResult selectLose(Map params) throws Exception;

    //增加流失
    RestResult addLose(Lose lose);

    //修改流失
    RestResult updateLose(Lose lose);

    //删除
    RestResult deleteLose(List<Integer> pkIds);

}
