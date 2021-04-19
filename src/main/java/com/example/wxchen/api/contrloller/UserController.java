//package com.example.wxchen.api.contrloller;
//
//import com.example.wxchen.api.entity.User;
//import com.example.wxchen.core.utils.ResultMsg;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//
///**
// * 2021/4/7 16:52
// * 作者:wxchen
// * 描述:
// */
//
//@Api(tags = {"用户接口"})
//@RestController
//@RequestMapping("/user")//系统模块名称 没有就不用写 具体看接口如何设计
//public class UserController {
//
//    @Resource
//    private UserService userService;
//
//    @PostMapping("/user")
//    @ApiOperation("增加用户")
//    public Object save(@RequestBody User user){
//        try{
//            return ResultMsg.success(userService.save(user));
//        }catch (Exception e){
//            return ResultMsg.fail(500,"操作失败");
//        }
//    }
////
////    @DeleteMapping("/user/{id}")
////    @ApiOperation("根据Id删除用户")
////    public ResultMsg removeById(@PathVariable Integer id){
////
////        try{
////            return ResultMsg.success(userService.removeById(userId));
////
////        }catch (Exception e){
////            return ResultMsg.fail(500,"操作失败");
////        }
////    }
////
////    @PutMapping("/user/{id}")
////    @ApiOperation("修改用户")
////    public ResultMsg update(@PathVariable Integer id,@RequestBody User user){
////
////        try{
////            user.setId(id);
////            return ResultMsg.success(userService.updateById(user));
////
////        }catch (Exception e){
////            return ResultMsg.fail();
////        }
////    }
//
//    @GetMapping("/users")
//    @ApiOperation("获取所有用户")
//    public Object listAll(){
//
//        try{
//            return ResultMsg.success(userService.list());
//        }catch (Exception e){
//            return ResultMsg.fail(500,"操作失败");
//        }
//    }
////
////    @GetMapping("/user/{id}")
////    @ApiOperation("根据Id查询用户")
////    public ResultMsg getById(@PathVariable Integer id){
////
////        try{
////            return ResultMsg.success(userService.selectById(userService.getUserId));
////        }catch (Exception e){
////            return ResultMsg.fail();
////        }
////    }
//
//}
