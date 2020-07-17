package com.poppy.springcola.ext;

import com.alibaba.cola.extension.ExtensionPointI;
import com.poppy.springcola.dto.Department;

import java.util.List;

/**
 * 定义扩展点(类似于MVC三层架构中的接口)
 */
public interface OrganizationExtPt extends ExtensionPointI {

    /**
     * 根据corpId查询企业下所有部门
     *
     * @param corpId        企业编号
     * @param includeDelete 是否包含删除的部门
     * @return 部门
     */
    List<Department> getDepartmentsByCorpId(String corpId, Boolean includeDelete);


}
