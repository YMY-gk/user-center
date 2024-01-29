package com.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.result.PageResult;
import com.user.common.result.Result;
import com.user.domain.SysDictData;
import com.user.domain.SysDictType;
import com.user.dto.req.DictDataReq;
import com.user.dto.req.DictTypeReq;
import com.user.dto.resp.DictDataVo;
import com.user.service.user.impl.SysDictDataService;
import com.user.service.user.impl.SysDictTypeService;
import com.user.util.base.PageResultUtil;
import com.user.util.base.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 字典类型表 前端控制器
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-21
 */
@RestController
@RequestMapping("/dict")
public class SysDictTypeController {
    @Autowired
    SysDictTypeService sysDictTypeService;
    @Autowired
    SysDictDataService sysDictDataService;

    /**
     * 查询字典
     * @param req
     * @return
     */
    @PostMapping(value = "/page")
    public PageResult<SysDictType> getPageDictType(@RequestBody DictTypeReq req) {
        Page<SysDictType> sysMenus= sysDictTypeService.getPageDictType(req);
        return PageResultUtil.OK(sysMenus);
    }
    /**
     * 查询字典
     * @param req
     * @return
     */
    @PostMapping(value = "/list")
    public Result<List<SysDictType>> getListDictType(@RequestBody DictTypeReq req) {
        List<SysDictType> sysDictTypeList= sysDictTypeService.getListDictType(req);
        return ResultUtil.OK(sysDictTypeList);
    }
    /**
     * 获取数据
     * @param id
     * @return
     */
    @GetMapping(value = "/get")
    public Result<SysDictType> getDictTypeById(@RequestParam(required = true,value = "id") Long  id) {
        SysDictType  dictType= sysDictTypeService.getDictTypeById(id);
        return ResultUtil.OK(dictType);
    }
    /**
     * 新增字典
     */
    @PostMapping(value = "/add")
    public Result<Object> addDictType(@RequestBody SysDictType dictType) {
        sysDictTypeService.addDictType(dictType);
        return ResultUtil.OK();
    }
    /**
     * 修改字典类型
     */
    @PostMapping(value = "/edit")
    public Result<Object> editDictType(@RequestBody SysDictType dictType) {
        sysDictTypeService.editDictType(dictType);
        return ResultUtil.OK();
    }
    /**
     * 删除数据
     */
    @PostMapping(value = "/dels")
    public Result<Object> delDictType(@RequestParam(required = true,value = "ids") List<Long>  ids) {
        sysDictTypeService.delDictType(ids);
        return ResultUtil.OK();
    }
    /**
     * 删除数据
     */
    @PostMapping(value = "/data/page")
    public  PageResult<DictDataVo> getPageDicts(@RequestBody DictDataReq req) {
        Page<DictDataVo> sysDictTypePage = sysDictDataService.getPageDicts(req);
        return PageResultUtil.OK(sysDictTypePage);
    }
    /**
     * 获取数据
     * @param id
     * @return
     */
    @GetMapping(value = "/data/get")
    public Result<SysDictData> getDictDataById(@RequestParam(required = true,value = "id") Long  id) {
        SysDictData  dictType= sysDictDataService.getDictTypeById(id);
        return ResultUtil.OK(dictType);
    }
    /**
     * 新增字典
     */
    @PostMapping(value = "/data/add")
    public Result<Object> addDictData(@RequestBody SysDictData dictType) {
        sysDictDataService.addDictType(dictType);
        return ResultUtil.OK();
    }
    /**
     * 修改字典类型
     */
    @PostMapping(value = "/data/edit")
    public Result<Object> editDictData(@RequestBody SysDictData dictType) {
        sysDictDataService.editDictType(dictType);
        return ResultUtil.OK();
    }
    /**
     * 删除数据
     */
    @PostMapping(value = "/data/del")
    public Result<Object> delDictData(@RequestParam(required = true,value = "ids") List<Long>  ids) {
        sysDictDataService.delDictType(ids);
        return ResultUtil.OK();
    }
    /**
     * 获取字典
     */
    @PostMapping(value = "/data/list")
    public Result<List<SysDictData>> listDictData(@RequestBody DictDataReq req) {
        List<SysDictData> list  = sysDictDataService.listDictData(req);
        return ResultUtil.OK(list);
    }
    /**
     * 获取字典通过类型
     */
    @PostMapping(value = "/data/type")
    public Result<List<SysDictData>> getDictDataByType(@RequestParam(required = true,value = "type") String type) {
        List<SysDictData> list  = sysDictDataService.getDictDataByType(type);
        return ResultUtil.OK(list);
    }
}