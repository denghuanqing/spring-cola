package com.poppy.springcola.controller;

import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.poppy.springcola.dto.Department;
import com.poppy.springcola.ext.OrganizationExtPt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrganizationController {

    @Autowired
    private ExtensionExecutor extensionExecutor;

    @GetMapping(value = "/organization/getDepartmentsByCorpId/{corpId}/{scenario}")
    public List<Department> listCustomerByName(@PathVariable("corpId") String corpId, @PathVariable("scenario") String scenario){

        List<Department> execute = extensionExecutor.execute(OrganizationExtPt.class, BizScenario.valueOf(corpId,"getByCorpId",scenario), ex -> ex.getDepartmentsByCorpId(corpId, false));

        return execute;
    }


}
