package com.study.controller.view;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.model.Resources;
import com.study.service.ResourcesService;
@Api(value = "ResourcesViewController", description = "菜单展示操作API")
@Controller
public class ResourcesViewController {
  @Resource
  private ResourcesService resourcesService;
  /**
   * 菜单添加页面
   * @param request
   * @return
   */
  @ApiOperation(value="跳转页面",notes="跳转添加或者修改页面")
  @ApiImplicitParams({
    @ApiImplicitParam(name="id",value="菜单id",required=false,dataType="string",paramType="query")
  })
  @RequestMapping(value="/resources/add",method = RequestMethod.GET)
  public String resources_add(HttpServletRequest request,@RequestParam(value="id",required=false) Integer id){
    Resources resources=new Resources();
    resources.setType(1);
    List<Resources> resourcesList = resourcesService.queryByType(resources, null);
    request.setAttribute("resourcesList", resourcesList);
    if(id!=null){
      Resources reso = resourcesService.selectByKey(id);
      request.setAttribute("resources", reso);
      return "resources/resources_edit";
    }else{
      return "resources/resources_add";
    }
  }
  @ApiOperation(value="跳转菜单列表页",notes="跳转菜单列表页")
  @RequestMapping(value="/resourcesPage",method={RequestMethod.GET})
  public String resourcesPage() {
      return "resources/resources";
  }
}
