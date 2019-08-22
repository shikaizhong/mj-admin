package com.mj.admin.controller;

import com.mj.admin.constants.ParamConstant;
import com.mj.admin.service.RoleService;
import com.mj.common.result.RestResult;
import com.mj.common.tools.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Mr.Dxs on 2018/7/26.
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {


    @Autowired
    private RoleService roleService;


    /**
     * 添加角色
     * @param params
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public RestResult saveRole(@RequestBody Map params){
        return roleService.add(params);
    }


    /**
     * 删除角色
     * @param map
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public RestResult deleteRole(@RequestBody Map map){
        List<Integer> roleIds = (List<Integer>) map.get("pkIds");
        return roleService.delete(roleIds);
    }


    /**
     * 修改角色信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public RestResult updateRole(@RequestBody Map map){
        return roleService.update(map);
    }


    /**
     * 角色分页数据
     * @param map
     * @return
     */
    @RequestMapping(value = "/listPage",method = RequestMethod.POST)
    public RestResult listPage(@RequestBody Map map){
        return roleService.listPage(formatPageParam(map));
    }


    /**
     * 获取角色列表
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public RestResult listRole(){
        return roleService.getAll();
    }


    /**
     * 获取角色所拥有的 资源 ID 列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/getResourceIds",method = RequestMethod.POST)
    public RestResult roleHaveResource(@RequestBody Map map){
        Integer roleId = (Integer) map.get("roleId");
        return roleService.getRoleHaveResource(roleId);
    }


    /**
     * 处理、分页请求参数
     * @param map
     * @return
     */
    public Map formatPageParam(Map map){
        Map queryMap = new HashMap();

        String keyword = (String) map.get(ParamConstant.KEY_WORD);
        Integer pageNum = (Integer) map.get(ParamConstant.PAGE_NUM);
        Integer pageSize = (Integer) map.get(ParamConstant.PAGE_SIZE);
        Integer type = (Integer) map.get("Type");

        if (!StringUtil.isEmpty(keyword)){
            queryMap.put(ParamConstant.KEY_WORD,keyword);
        }
        if (pageNum < 0){
            pageNum = 0;
        }
        if (pageSize <= 0){
            pageSize = 10;
        }
        // pageNum 为 1，返回数据集从第二条开始
        int n = pageNum == 1 ? pageNum = 0 : (pageNum = (pageNum-1)*pageSize);
        queryMap.put(ParamConstant.PAGE_NUM,pageNum);
        queryMap.put(ParamConstant.PAGE_SIZE,pageSize);

        if (null != type && type >= 0 ){
            queryMap.put("type",type);
        }

        return queryMap;
    }

}
