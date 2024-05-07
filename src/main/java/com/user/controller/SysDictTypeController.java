package com.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.result.PageResult;
import com.user.common.result.Result;
import com.user.domain.SysDictData;
import com.user.domain.SysDictType;
import com.user.dto.req.DictDataReq;
import com.user.dto.req.DictTypeReq;
import com.user.dto.resp.DictDataVo;
import com.user.common.result.user.impl.SysDictDataService;
import com.user.common.result.user.impl.SysDictTypeService;
import com.user.util.base.PageResultUtil;
import com.user.util.base.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "字典管理",description = "字典管理数据")
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
    @ApiOperation("查询字典类型数据列表")
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
    @ApiOperation("查询字典类型数据不分页列表")
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
    @ApiOperation("获取字典类型详情")
    public Result<SysDictType> getDictTypeById(@RequestParam(required = true,value = "id") Long  id) {
        SysDictType  dictType= sysDictTypeService.getDictTypeById(id);
        return ResultUtil.OK(dictType);
    }
    /**
     * 新增字典
     */
    @PostMapping(value = "/add")
    @ApiOperation("删除部门数据")
    public Result<Object> addDictType(@RequestBody SysDictType dictType) {
        return  sysDictTypeService.addDictType(dictType);
    }
    /**
     * 修改字典类型
     */
    @PostMapping(value = "/edit")
    @ApiOperation("编辑字典类型数据")
    public Result<Object> editDictType(@RequestBody SysDictType dictType) {
        return sysDictTypeService.editDictType(dictType);
    }
    /**
     * 删除数据
     */
    @PostMapping(value = "/dels")
    @ApiOperation("删除字典类型")
    public Result<Object> delDictType(@RequestParam(required = true,value = "ids") List<Long>  ids) {
        sysDictTypeService.delDictType(ids);
        return ResultUtil.OK();
    }
    /**
     * 删除数据
     */
    @PostMapping(value = "/data/page")
    @ApiOperation("查询字典数据列表")
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
    @ApiOperation("查询字典数据详情")
    public Result<SysDictData> getDictDataById(@RequestParam(required = true,value = "id") Long  id) {
        SysDictData  dictType= sysDictDataService.getDictTypeById(id);
        return ResultUtil.OK(dictType);
    }
    /**
     * 新增字典
     */
    @PostMapping(value = "/data/add")
    @ApiOperation("新增字典数据")
    public Result<Object> addDictData(@RequestBody SysDictData dictType) {
        sysDictDataService.addDictType(dictType);
        return ResultUtil.OK();
    }
    /**
     * 修改字典类型
     */
    @PostMapping(value = "/data/edit")
    @ApiOperation("编辑字典数据")
    public Result<Object> editDictData(@RequestBody SysDictData dictType) {
        return   sysDictDataService.editDictType(dictType);
    }
    /**
     * 删除数据
     */
    @PostMapping(value = "/data/del")
    @ApiOperation("删除字典数据")
    public Result<Object> delDictData(@RequestParam(required = true,value = "ids") List<Long>  ids) {
        sysDictDataService.delDictType(ids);
        return ResultUtil.OK();
    }
    /**
     * 获取字典
     */
    @PostMapping(value = "/data/list")
    @ApiOperation("获取字典数据不分页")
    public Result<List<SysDictData>> listDictData(@RequestBody DictDataReq req) {
        List<SysDictData> list  = sysDictDataService.listDictData(req);
        return ResultUtil.OK(list);
    }
    /**
     * 获取字典通过类型
     */
    @PostMapping(value = "/data/type")
    @ApiOperation("根据字典类型查询字典数据")
    public Result<List<SysDictData>> getDictDataByType(@RequestParam(required = true,value = "type") String type,
                @RequestParam(required = false,value = "realm") Long realm) {
        List<SysDictData> list  = sysDictDataService.getDictDataByType(type,realm);
        return ResultUtil.OK(list);
    }
}
