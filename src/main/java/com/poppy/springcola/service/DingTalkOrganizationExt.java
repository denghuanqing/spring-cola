package com.poppy.springcola.service;

import com.alibaba.cola.extension.Extension;
import com.poppy.springcola.dto.Department;
import com.poppy.springcola.ext.OrganizationExtPt;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Extension(bizId = "organize", useCase = "getByCorpId", scenario = "dingTalk")
@Slf4j
public class DingTalkOrganizationExt implements OrganizationExtPt {

    @Override
    public List<Department> getDepartmentsByCorpId(String corpId, Boolean includeDelete) {

        log.info("在组织结构业务，通过企业编号获取部门列表的用例，在钉钉的场景下业务的实现处理方式");

        log.info("通过钉钉的配置信息和API获取得到组织信息，并组装成云枢识别的部门信息");

        Department department = new Department();

        department.setName("dingTalk");
        department.setCorpId(corpId);

        return Collections.singletonList(department);
    }
}
