package com.yanchun.controller.api;

import com.yanchun.jpa.entity.User;
import com.yanchun.utils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

@RestController
@Api(value = "用户测试模块")
public class UserTestController {

    // 创建线程安全的Map
    static Map<String, User> users = Collections.synchronizedMap(new HashMap<String, User>());

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<CommonResult> getUserById (@PathVariable(value = "id") String id){
        CommonResult commonResult = new CommonResult();
        try {
            User user = users.get(id);
            commonResult.setResult(user);
            commonResult.setCode(1000);
        } catch (Exception e) {
            commonResult.setResult(e.getClass().getName() + ":" + e.getMessage());
            commonResult.setCode(1000);
            e.printStackTrace();
        }
        return ResponseEntity.ok(commonResult);
    }

    /**
     * 查询用户列表
     * @return
     */
    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<CommonResult> getUserList (){
        CommonResult commonResult = new CommonResult();
        try {
            List<User> userList = new ArrayList<User>(users.values());
            commonResult.setResult(userList);
            commonResult.setCode(1000);
        } catch (Exception e) {
            commonResult.setResult(e.getClass().getName() + ":" + e.getMessage());
            commonResult.setCode(1000);
            e.printStackTrace();
        }
        return ResponseEntity.ok(commonResult);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<CommonResult> add (@RequestBody User user){
        CommonResult commonResult = new CommonResult();
        try {
            users.put(user.getId(), user);
            commonResult.setResult(user.getId());
            commonResult.setCode(1000);
        } catch (Exception e) {
            commonResult.setResult(e.getClass().getName() + ":" + e.getMessage());
            commonResult.setCode(1000);

            e.printStackTrace();
        }
        return ResponseEntity.ok(commonResult);
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResult> delete (@PathVariable(value = "id") String id){
        CommonResult commonResult = new CommonResult();
        try {
            users.remove(id);
            commonResult.setResult(id);
            commonResult.setCode(1000);
        } catch (Exception e) {
            commonResult.setResult(e.getClass().getName() + ":" + e.getMessage());
            commonResult.setCode(1000);

            e.printStackTrace();
        }
        return ResponseEntity.ok(commonResult);
    }

    /**
     * 根据id修改用户信息
     * @param user
     * @return
     */
    @ApiOperation(value="更新信息", notes="根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CommonResult> update (@PathVariable("id") String id, @RequestBody User user){
        CommonResult commonResult = new CommonResult();
        try {
            User user1 = users.get(id);
            user1.setUsername(user.getUsername());
            user1.setAge(user.getAge());
            users.put(id, user1);
            commonResult.setResult(user1);
            commonResult.setCode(1000);
        } catch (Exception e) {
            commonResult.setResult(e.getClass().getName() + ":" + e.getMessage());
            commonResult.setCode(1000);

            e.printStackTrace();
        }
        return ResponseEntity.ok(commonResult);
    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String  jsonTest() {
        return " hi you!";
    }
}
