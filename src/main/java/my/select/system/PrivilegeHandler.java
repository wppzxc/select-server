package my.select.system;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.select.entity.Menu;
import my.select.entity.Role;
import my.select.entity.User;
import my.select.enums.ResponseMsgEnum;
import my.select.netData.down.DownBase;
import my.select.netData.down.privilege.RMenu;
import my.select.netData.down.privilege.RUser;
import my.select.netData.up.privilege.GetMenuUp;
import my.select.netData.up.privilege.GetRolesUp;
import my.select.netData.up.privilege.InsertRoleUserUp;
import my.select.netData.up.user.GetUserUp;
import my.select.service.MenuService;
import my.select.service.RoleService;
import my.select.service.UserService;
import my.select.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wpp on 2017/5/19.
 * 权限模块
 */
@Controller
@RequestMapping("/system")
public class PrivilegeHandler {

    @Resource
    private RoleService roleService;
    @Resource
    private MenuService menuService;
    @Resource
    private UserService userService;

    @RequestMapping("/getAllRoles")
    @ResponseBody
    public String getAllRoles(GetRolesUp up){
        DownBase down = new DownBase();
        List<Role> roles = roleService.getAllRoles(up);
        down.setData(roles);
        down.setState(ResponseMsgEnum.OK.getId());
        down.setMsg(ResponseMsgEnum.OK.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/insertRole")
    @ResponseBody
    public String insertRole(Role role){
        DownBase down = new DownBase();
        if(role != null){
            int rows = roleService.insertRole(role);
            if(rows <= 0){
                down.setState(ResponseMsgEnum.INNER_ERR.getId());
                down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
            }else {
                down.setState(ResponseMsgEnum.SUCCESS.getId());
                down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
            }
        }else {
            down.setState(ResponseMsgEnum.REQ_ERR.getId());
            down.setMsg(ResponseMsgEnum.REQ_ERR.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public String deleteRole(Integer id){
        DownBase down = new DownBase();
        int rows = roleService.deleteRole(id);
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setState(ResponseMsgEnum.SUCCESS.getId());
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/updateRole")
    @ResponseBody
    public String updateRole(Role role){
        DownBase down = new DownBase();
        if(role != null){
            int rows = roleService.updateRole(role);
            if(rows <= 0){
                down.setState(ResponseMsgEnum.INNER_ERR.getId());
                down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
            }else {
                down.setState(ResponseMsgEnum.SUCCESS.getId());
                down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
            }
        }else {
            down.setState(ResponseMsgEnum.REQ_ERR.getId());
            down.setMsg(ResponseMsgEnum.REQ_ERR.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/getAllMenus")
    @ResponseBody
    public String getAllMenus(GetMenuUp up){
        DownBase down = new DownBase();
        List<Menu> menus = menuService.getAllMenus(up);
        down.setData(menus);
        down.setState(ResponseMsgEnum.OK.getId());
        down.setMsg(ResponseMsgEnum.OK.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/insertMenu")
    @ResponseBody
    public String insertMenu(Menu menu){
        DownBase down = new DownBase();
        if(menu != null){
            int rows = menuService.insertMenu(menu);
            if(rows <= 0){
                down.setState(ResponseMsgEnum.INNER_ERR.getId());
                down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
            }else {
                down.setState(ResponseMsgEnum.SUCCESS.getId());
                down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
            }

        }else {
            down.setState(ResponseMsgEnum.REQ_ERR.getId());
            down.setMsg(ResponseMsgEnum.REQ_ERR.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/deleteMenu")
    @ResponseBody
    public String deleteMenu(Integer id){
        DownBase down = new DownBase();
        int rows = menuService.deleteMenu(id);
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setState(ResponseMsgEnum.SUCCESS.getId());
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/updateMenu")
    @ResponseBody
    public String updateMenu(Menu menu){
        DownBase down = new DownBase();
        if(menu != null){
            int rows = menuService.updateMenu(menu);
            if(rows <= 0){
                down.setState(ResponseMsgEnum.INNER_ERR.getId());
                down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
            }else {
                down.setState(ResponseMsgEnum.SUCCESS.getId());
                down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
            }

        }else {
            down.setState(ResponseMsgEnum.REQ_ERR.getId());
            down.setMsg(ResponseMsgEnum.REQ_ERR.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/getRoleUsers")
    @ResponseBody
    public String getRoleUsers(Integer roleId){
        DownBase down = new DownBase();
        GetUserUp up = new GetUserUp();
        up.setName("");
        up.setState(null);
        // 获取已经有该角色的用户
        List<RUser> roleUsers = roleService.getRoleUsers(roleId);
        // 获取所有用户
        List<User> list = userService.getAllUsers(up);
        List<RUser> allUsers = new ArrayList<RUser>();
        for(User u:list){
            allUsers.add(new RUser(u));
        }
        Map<String,Object> lists = new HashMap<String, Object>();
        lists.put("userList",allUsers);
        lists.put("resultList",roleUsers);
        down.setData(lists);
        down.setState(ResponseMsgEnum.OK.getId());
        down.setMsg(ResponseMsgEnum.OK.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/insertRoleUser")
    @ResponseBody
    public String insertRoleUser(InsertRoleUserUp up){
        DownBase down = new DownBase();
        ObjectMapper mapper = new ObjectMapper();
        try{
            List<Integer> list = mapper.readValue(up.getList(),new TypeReference<List<Integer>>() {});
            if(list != null){
                roleService.deleteRoleUser(up.getRoleId());
            }
            int rows = roleService.insertRoleUser(list,up.getRoleId());
            if(rows <= 0){
                down.setState(ResponseMsgEnum.REQ_ERR.getId());
                down.setMsg(ResponseMsgEnum.REQ_ERR.getMsg());
            }else {
                down.setState(ResponseMsgEnum.SUCCESS.getId());
                down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
            }
        }catch (Exception e){
            e.printStackTrace();
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/getRoleMenus")
    @ResponseBody
    public String getRoleMenus(Integer roleId){
        DownBase down = new DownBase();
        GetMenuUp up = new GetMenuUp();
        up.setState(null);
        up.setModule("");
        List<RMenu> menus = roleService.getRoleMenus(roleId);
        List<Menu> list = menuService.getAllMenus(up);
        List<RMenu> allMenus = new ArrayList<RMenu>();
        for(Menu m:list){
            allMenus.add(new RMenu(m));
        }
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("menuList",allMenus);
        map.put("resultList",menus);
        down.setData(map);
        down.setState(ResponseMsgEnum.OK.getId());
        down.setMsg(ResponseMsgEnum.OK.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/insertRoleMenu")
    @ResponseBody
    public String insertRoleMenu(InsertRoleUserUp up){
        DownBase down = new DownBase();
        ObjectMapper mapper = new ObjectMapper();
        try{
            List<Integer> list = mapper.readValue(up.getList(),new TypeReference<List<Integer>>() {});
            if(list != null){
                roleService.deleteRoleMenu(up.getRoleId());
            }
            int rows = roleService.insertRoleMenu(list,up.getRoleId());
            if(rows <= 0){
                down.setState(ResponseMsgEnum.REQ_ERR.getId());
                down.setMsg(ResponseMsgEnum.REQ_ERR.getMsg());
            }else {
                down.setState(ResponseMsgEnum.SUCCESS.getId());
                down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
            }
        }catch (Exception e){
            e.printStackTrace();
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }
}
