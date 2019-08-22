package com.mj.admin.service.impl;

import com.mj.admin.exceptions.APIRunTimeException;
import com.mj.admin.service.ResourceService;
import com.mj.common.enums.ResultCodeEnum;
import com.mj.common.result.RestResult;
import com.mj.common.result.ResultUtils;
import com.mj.common.tools.StringUtil;
import com.mj.dao.entity.Resource;
import com.mj.dao.repository.AdminMapper;
import com.mj.dao.repository.AdminRoleMapper;
import com.mj.dao.repository.ResourceMapper;
import com.mj.dao.repository.RoleResourcesMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Mr.Dxs on 2018/7/27.
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {


    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private RoleResourcesMapper roleResourceMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public RestResult save(Map map) {

        // 格式化数据
        Resource resource = validatorResource(map,1);

        Resource target = resourceMapper.getResourceByUkName(resource.getUkName());
        if (null != target){
            return ResultUtils.error(ResultCodeEnum.MENU_EXIST.getCode(),ResultCodeEnum.MENU_EXIST.getMsg());
        }
        resourceMapper.insertSelective(resource);
        return ResultUtils.success(null);

    }

    @Override
    public RestResult delete(Integer pkId) {

        // 删除该菜单的 二级菜单
        List<Integer> childs = resourceMapper.selectChildpkIds(pkId);
        if (childs.size() > 0){
            for (Integer child:childs
                 ) {
                resourceMapper.deleteByPrimaryKey(child);
            }
        }

        // 删除指定的 菜单
        resourceMapper.deleteByPrimaryKey(pkId);

        // 删除 角色-菜单 关联关系
        roleResourceMapper.deleteByResourceId(pkId);
        return ResultUtils.success(null);

    }

    @Override
    public RestResult update(Map map) {

        Resource resource = validatorResource(map,2);
        resourceMapper.updateByPrimaryKeySelective(resource);
        return ResultUtils.success(null);

    }

    @Override
    public RestResult parentList() {
        return ResultUtils.success(resourceMapper.parentList());
    }


    @Override
    public RestResult getAll() {
        System.out.println("1111111111111111");
        List<Map> resources = resourceMapper.getAll();
        List<Map> results = new ArrayList<>();

        if (resources.size() > 0){
            for (Map one : resources) {
                // 一级菜单
                Integer pkId = (Integer) one.get("pkId");
                Integer parentId = (Integer) one.get("parentId");
                if (parentId == 0){
                    List<Map> children = new ArrayList<>();
                    for (Map two:resources
                            ) {
                        // 子 二级列表

                        Integer twoParentId = (Integer) two.get("parentId");
                        if (twoParentId == pkId){
                            children.add(two);
                        }
                    }
                    one.put("children", children);
                    results.add(one);
                }
            }
        }
        Map returnMap = new HashMap();
        returnMap.put("menus", results);
        return ResultUtils.success(returnMap);
    }

    @Override
    public RestResult getMenusByAdminId(Integer adminId) {
        System.out.println("2222222222222222222222");
        if (null == adminId){
            return ResultUtils.error(ResultCodeEnum.ILLEGAL_ARGUMENT.getCode(),ResultCodeEnum.ILLEGAL_ARGUMENT.getMsg());
        }

        // 获取角色列表ID
        List<Integer> roleIds = adminRoleMapper.getAdminRoles(adminId);
        // 获取所有角色 资源列表
        List<Resource> resources = resourceMapper.getResourcesByRoleId(roleIds);
        System.out.println(resources.size());

        List<JSONObject> results = new ArrayList<>();

        if (resources.size() > 0){
            for (Resource one : resources) {
                // 一级菜单
                if (one.getParentId() == 0){
                    List<Resource> children = new ArrayList<>();
                    for (Resource two:resources
                            ) {
                        // 子 二级列表
                        if (two.getParentId() == one.getPkId()){
                            children.add(two);
                        }
                    }
                    JSONObject result = JSONObject.fromObject(one);
                    result.put("children", children);
                    results.add(result);
                }

            }
        }

        Map returnMap = new HashMap();
        returnMap.put("menus", results);
        return ResultUtils.success(returnMap);
    }


    // 自定义

    /**
     * 参数验证与提取
     * @param map
     * @param operateType
     * @return
     */
    public Resource validatorResource(Map map, Integer operateType){

        Resource resource = new Resource();
        Date currentDate = new Date();

        if (1 == operateType){
            // save
            Integer parentId = (Integer) map.get("parentId");
            String ukName = (String) map.get("ukName");
            String path = (String) map.get("path");
            String perms = (String) map.get("perms");
            Integer type = (Integer) map.get("Type");
            Integer orderNum = (Integer) map.get("orderNum");

            if (parentId == null ||
                    StringUtil.isEmpty(ukName) ||
                    StringUtil.isEmpty(path) ||
                    StringUtil.isEmpty(perms) ||
                    type == null ||
                    orderNum == null){
                throw new APIRunTimeException(ResultCodeEnum.ILLEGAL_ARGUMENT.getCode(),ResultCodeEnum.ILLEGAL_ARGUMENT.getMsg());
            }

            resource.setParentId(parentId);
            resource.setUkName(ukName);
            resource.setPath(path);
            resource.setPerms(perms);
            resource.setType(Integer.valueOf(type));
            resource.setOrderNum(Integer.valueOf(orderNum));
            resource.setCreateTime(currentDate);
            resource.setDeleteFlag(0);
            resource.setUpdateTime(currentDate);


        }else if (2 == operateType){

            // update
            Integer pkId = (Integer) map.get("pkId");
            Integer parentId = (Integer) map.get("parentId");
            String ukName = (String) map.get("ukName");
            String path = (String) map.get("path");
            String perms = (String) map.get("perms");
            Integer type = (Integer) map.get("Type");
            Integer orderNum = (Integer) map.get("orderNum");


            if ( pkId == 0 || pkId == null || parentId == null ||
                    StringUtil.isEmpty(ukName) ||
                    StringUtil.isEmpty(path) ||
                    StringUtil.isEmpty(perms) ||
                    type == null ||
                    orderNum == null){
                throw new APIRunTimeException(ResultCodeEnum.ILLEGAL_ARGUMENT.getCode(),ResultCodeEnum.ILLEGAL_ARGUMENT.getMsg());
            }

            resource.setPkId(pkId);
            resource.setParentId(parentId);
            resource.setUkName(ukName);
            resource.setPath(path);
            resource.setPerms(perms);
            resource.setType(type);
            resource.setOrderNum(orderNum);
            resource.setUpdateTime(currentDate);
        }
        return resource;
    }


}
