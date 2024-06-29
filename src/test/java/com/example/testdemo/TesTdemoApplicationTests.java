package com.example.testdemo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.testdemo.entity.Study;
import com.example.testdemo.entity.Study1;
import com.example.testdemo.entity.TUser;
import com.example.testdemo.mapper.TUserMapper;
import com.example.testdemo.service.TUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import testpo.ProcessVO;

import java.util.*;

@SpringBootTest
class TesTdemoApplicationTests {

    @Autowired
    private TUserService tUserService;

    @Autowired
    private TUserMapper tUserMapper;


    /**
     * 序列化对象
     */
    @Test
    void contextLoads() {
         List<TUser> list = tUserService.list();
         String s = JSON.toJSONString(list);
         System.out.println(s);
    }

    /**
     * mapper层封装的CRUD
     */
    @Test
    void lambdaQuery(){
        //mapper层封装的CRUD
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        List<TUser> tUsers = tUserMapper.selectList(queryWrapper);
        //service层封装的CRUD
        List<TUser> list1 = tUserService.lambdaQuery().eq(TUser::getEmail,"7777").list();
        System.out.println(list1);
    }


    @Test
    void test(){
        List<String> userList = new ArrayList<>();
        List<String> userList1 = new ArrayList<>();

        // 获取提前启动工序
        List<String> processIds = Arrays.asList("4ffee2b2d73911ec9f9e0242ac100002",
                "54f39816d73911ec9f9e0242ac100002",
                "5c491171d73a11ec9f9e0242ac100002",
                "61dcdbd4d73911ec9f9e0242ac100002",
                "6249e76dd73a11ec9f9e0242ac100002",
                "707c2b16d73a11ec9f9e0242ac100002",
                "7795ce1acf6c11edbb0c0242ac1f0004",
                "2baa623ccf6d11edbb0c0242ac1f0004",
                "b9eb8dfbcf6d11edbb0c0242ac1f0004",
                "196677a6cf6e11edbb0c0242ac1f0004",
                "710182fecf6e11edbb0c0242ac1f0004",
                "d8f339e2cf6e11edbb0c0242ac1f0004");
        List<ProcessVO> processVOs =  new ArrayList<>();
        processIds.forEach(e ->
                {
                    ProcessVO vo = new ProcessVO();
                    vo.setAssignee(e);
                    processVOs.add(vo);
                }
                );
        System.out.println(JSON.toJSONString(processVOs));
        if (CollectionUtil.isNotEmpty(processVOs)) {
            // 逗号拼接而成 解析为username列表
            processVOs.forEach(item -> {
                if (StrUtil.isNotEmpty(item.getAssignee())) {
                    userList.addAll(Arrays.asList(item.getAssignee().split(",")));
                    userList1.addAll(Arrays.asList(item.getAssignee()));
                }
            });
            System.out.println(userList);
            System.out.println(userList1);
        }
    }

    /**
     * 更新数据库的数据
     */
    @Test
    void updateType(){
        //更新单个实体对象的某个字段
        TUser tu = new TUser();
        tu.setId(1);
        //tUserMapper.updateById(tu);
        //更新多个实体对象的某个字段
        UpdateWrapper updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("type",2);
        //tUserMapper.update(null,updateWrapper);
        //更新多个实体对象的多个字段
        UpdateWrapper upList = new UpdateWrapper<>();
        upList.set("type",2);
        upList.set("gender",222);
        tUserMapper.update(null,upList);
    }

    /**
     * 新增数据库数据
     */
    @Test
    void testInster(){
        List<Map<String,Object>> listMap = new ArrayList<>();
        List<Integer> list =Arrays.asList(1,2,3,4);
        Map<String, Object> map = new HashMap<>();
        for (int a:list) {
                map.put("name",a);
                System.out.println(map);
            }
        listMap.add(map);
        System.out.println(listMap);

    }

    @Test
    void test1() {
        JSONObject json1 = new JSONObject();
        json1.put("a", "桃子");
        json1.put("b", "桃子");
        json1.put("c", "桃子");

        JSONObject json2 = new JSONObject();
        json2.put("a", "桃子");
        json2.put("b", "桃子");
        json2.put("c", "桃子");

        JSONObject json3 = new JSONObject();
        json3.put("a", "桃子");
        json3.put("b", "桃子");
        json3.put("c", "桃子");

        List<JSONObject> list = new ArrayList<>();
        list.add(json1);
        list.add(json2);
        list.add(json3);
        System.out.println(JSONUtil.toJsonStr(list));
        System.out.println(list);

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alice", 25));
        personList.add(new Person("Bob", 30));
        personList.add(new Person("Charlie", 35));

        // 使用 JSONUtil.toJsonStr 方法将 List 转换为 JSON 字符串
        String jsonStr = JSONUtil.toJsonStr(personList);
        // 打印转换后的 JSON 字符串
        System.out.println(jsonStr);
        Person person =  new Person("Charlie", 35);
        JSONObject json = (JSONObject)JSONObject.toJSON(person);
        System.out.println(json);
    }

    // 示例对象类
    class Person {
        private String name;
        private int age;

        // 构造函数
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // getter 和 setter 方法
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }

    /**
     * jsonObject转String
     */
    @Test
    void jsonObject(){

        JSONObject json = new JSONObject();
        json.put("name",1);
        json.put("age",15);
        //JSONObject转字符串
        String  s = JSONUtil.toJsonStr(json);
        System.out.println(s);
        //字符串转JSONObject
        final cn.hutool.json.JSONObject jsonObject = JSONUtil.parseObj(s);
        System.out.println(jsonObject);
        //字符串转对象
         Study study2 = JSONUtil.toBean(s, Study.class);
        System.out.println(study2);
        ////对象转JSONObject
        final cn.hutool.json.JSONObject jsonObject1 = JSONUtil.parseObj(study2);

        //浅拷贝，复制属性的引用，而不复制引用对象本身。
        Study study1 = new Study();
        study1.setName("23");
        study1.setAge("66");
        Study study5 = new Study();
        BeanUtil.copyProperties(study1,study5);
        study1.setName("5555");

        //深拷贝：使用 CloneUtil.clone 方法，递归地复制对象的所有字段，使新对象与原始对象完全独立，
        // 修改新对象不会影响原始对象

        System.out.println("第一次提交");
        System.out.println("第二次提交");
        System.out.println("第三次提交");

    }
}
