package com.atguigu.mpdemo1010;

import com.atguigu.mpdemo1010.entity.User;
import com.atguigu.mpdemo1010.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class Mpdemo1010ApplicationTests{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList1(){
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectById(){

        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testSelectDemo(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L, 4L));
        System.out.println(users);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setId(2L);
        user.setName("阿卡丽");
        user.setAge(99);
        user.setEmail("9981@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testSelcetDemo2(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Helen Yao");
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectPage(){
        Page<User> page = new Page<>(1, 2);
        userMapper.selectPage(page, null);

        page.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }


    @Test
    public void testSelectMapsPage(){
        Page<User> page = new Page<>(1, 8);
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);

        //注意：此行必须使用 mapIPage 获取记录列表，否则会有数据类型转换错误
        mapIPage.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testUpdateById(){

        User user = new User();
        user.setId(1439496028318404609L);
        user.setAge(18);

        int result = userMapper.updateById(user);
        System.out.println(result);

    }


    /**
     * 测试 乐观锁插件
     */
    @Test
    public void testOptimisticLocker(){

        //查询
        User user = userMapper.selectById(1439496028318404609L);
        //修改数据
        user.setName("Helen Yao");
        user.setEmail("helen@qq.com");
        //执行更新
        userMapper.updateById(user);
    }

    /**
     * 测试乐观锁插件 失败
     */
    @Test
    public void testOptimisticLockerFail(){

        //查询
        User user = userMapper.selectById(1439496028318404609L);
        //修改数据
        user.setName("Helen Yao1");
        user.setEmail("helen@qq.com1");

        //模拟取出数据后，数据库中version实际数据比取出的值大，即已被其它线程修改并更新了version
        user.setVersion(user.getVersion() - 1);

        //执行更新
        userMapper.updateById(user);
    }

    @Test
    public void testDeleteBatchIds(){

        int result = userMapper.deleteBatchIds(Arrays.asList(8, 9, 10));
        System.out.println(result);
    }

    @Test
    public void testDeleteByMap(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Helen Yao");
        map.put("age", 18);

        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    /**
     * 测试 逻辑删除：不是真的删除 改变在数据库中的状态
     */
    @Test
    public void testLogicDelete(){

        int result = userMapper.deleteById(1439530008090542082L);
        System.out.println(result);
    }

    /**
     * 测试 逻辑删除后的查询：
     * 不包括被逻辑删除的记录
     */
    @Test
    public void testLogicDeleteSelect(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 测试 性能分析插件
     */
    @Test
    public void testPerformance(){
        User user = new User();
        user.setName("我是Helen");
        user.setEmail("helen@sina.com");
        user.setAge(18);
        userMapper.insert(user);
    }

    @Test
    public void testSelective(){
        List<User> users = userMapper.selectiveByDeleted(0);
        users.forEach(System.out::println);
    }

    /**
     * @author: a5071
     * @description: ge、gt、le、lt、isNull、isNotNull
     */
    @Test
    public void testDelete(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.gt("age", 10)
                .isNull("update_time")
                .isNotNull("id")
                .le("age", 30);

        List<User> users = userMapper.selectList(queryWrapper);

        for (User ab :
                users) {
            System.out.println(ab);
        }

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

    /**
     * @author: a5071
     * @description: eq、ne
     */
    @Test
    public void testSelectOne(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "Tom");

        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    /**
     * @author: a5071
     * @description: between、notBetween
     */
    @Test
    public void testSelectCount(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("age", 20, 30);

        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println(count);
    }

    /**
     * @author: a5071
     * @description: allEq
     */
    @Test
    public void testSelectList(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", 2);
        map.put("name", "阿卡丽");
        map.put("age", 99);

        queryWrapper.allEq(map);
        List<User> users = userMapper.selectList(queryWrapper);

        users.forEach(System.out::println);
    }

    /**
     * @author: a5071
     * @description: like、notLike、likeLeft、likeRight
     */
    @Test
    public void testSelectMaps(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .notLike("name", "e")
                .likeRight("email", "t");

        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);//返回值是Map列表
        maps.forEach(System.out::println);
    }

    /**
     * @author: a5071
     * @description: in、notIn、inSql、notInSql、exists、notExists
     */
    @Test
    public void testSelectObjs(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //queryWrapper.in("id", 1, 2, 3);
        queryWrapper.inSql("id", "select id from user where id < 20")
                    .notInSql("name","select name from user where name like '%e%'")
                    ;

        List<Object> objects = userMapper.selectObjs(queryWrapper);//返回值是Object列表
        objects.forEach(System.out::println);
    }

    /**
     * @author: a5071
     * @description: 嵌套or、嵌套and
     */
    @Test
    public void testUpdate1(){

        //修改值
        User user = new User();
        user.setAge(99);
        user.setName("Andy");

        //修改条件
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper
                .like("name", "h")
                .or()
                .between("age", 20, 30);

        int result = userMapper.update(user, userUpdateWrapper);

        System.out.println(result);
    }

    /**
     * @author: a5071
     * @description: orderBy、orderByDesc、orderByAsc 默认升序排列
     */
    @Test
    public void testSelectListOrderBy() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * @author: a5071
     * @description: 指定要查询的列
     */
    @Test
    public void testSelectListColumn() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "age");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * @author: a5071
     * @description: set、setSql
     */
    @Test
    public void testUpdateSet() {

        //修改值
        User user = new User();
        user.setAge(99);

        //修改条件
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper
                .like("name", "h")
                .set("name", "老李头")//除了可以查询还可以使用set设置修改的字段
                .setSql(" email = '123@qq.com'");//可以有子查询

        int result = userMapper.update(user, userUpdateWrapper);
    }
}