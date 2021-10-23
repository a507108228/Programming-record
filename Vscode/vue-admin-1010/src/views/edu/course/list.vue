<template>
  <div class="app-container">
    <h1 style="text-align: center">课程列表</h1>

    <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline">
      <el-form-item>
        <el-input v-model="courseQuery.title" placeholder="课程名称" />
      </el-form-item>

      <el-form-item>
        <el-select v-model="courseQuery.status" clearable placeholder="课程状态">
          <el-option value="Normal" label="已发布" />
          <el-option value="Draft" label="未发布" />
        </el-select>
      </el-form-item>

      <el-form-item label="添加时间">
        <el-date-picker v-model="courseQuery.begin" type="datetime" placeholder="选择开始时间"
          value-format="yyyy-MM-dd HH:mm:ss" default-time="00:00:00" />
      </el-form-item>

      <el-form-item>
        <el-date-picker v-model="courseQuery.end" type="datetime" placeholder="选择截止时间"
          value-format="yyyy-MM-dd HH:mm:ss" default-time="00:00:00" />
      </el-form-item>


      <el-button type="primary" icon="el-icon-search" @click="getList()">查询</el-button>
      <el-button type="default" @click="resetData()">清空</el-button>
    </el-form>

    <!-- 表格 -->
    <el-table :data="list" border fit highlight-current-row>

      <el-table-column label="序号" width="160" align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="title" label="课程名称" width="260" />

      <el-table-column label="课程状态" width="210">
        <template slot-scope="scope">
          {{ scope.row.status==='Normal'?'已发布':'未发布' }}
        </template>
      </el-table-column>

      <el-table-column prop="lessonNum" label="课时数" width="210" />

      <el-table-column prop="gmtCreate" label="添加时间" width="250" />

      <el-table-column prop="gmtModified" label="修改时间" width="250" />

      <el-table-column prop="viewCount" label="浏览数量" width="160" />

      <el-table-column label="操作" width="300" text-align="center">
        <template slot-scope="scope">
          <el-row>

            <el-col :span="12">
              <router-link :to="'/course/info/'+scope.row.id">
                <el-button type="primary" icon="el-icon-edit" size="mini">修改</el-button>
              </router-link>
            </el-col>

            <el-col :span="12">
              <el-button type="danger" icon="el-icon-delete" size="mini" @click="removeByDataId(scope.row.id)">删除
              </el-button>
            </el-col>

          </el-row>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <el-pagination :current-page="page" :page-size="limit" :total="total" style="padding: 30px 0; text-align: center;"
      layout="total, prev, pager, next, jumper" @current-change="getList" />

  </div>
</template>
<script>
  // 引入调用teacher.js文件
  import teacher from '@/api/edu/teacher'
  import course from '@/api/edu/course'

  export default {
    // 写核心代码位置
    // data:{
    // },
    data() { // 定义变量和初始值
      return {
        list: null, // 查询之后接口返回集合
        page: 1, // 当前页
        limit: 10, // 每页记录数
        total: 0, // 总记录数
        courseQuery: {} // 条件封装对象
      }
    },
    created() {  // 页面渲染之前执行，一般调用methods定义的方法
      // 调用
      this.getList()
    },
    methods: {  // 创建具体的方法，调用teacher.js定义的方法

      // 课程分页查询列表的方法
      getList(page = 1) {
        this.page = page
        course.getCourseListPage(this.page, this.limit, this.courseQuery)
          .then(response => {// 请求成功
            // response接口返回的数据
            console.log(response)
            this.list = response.data.rows
            this.total = response.data.total
            console.log(this.list)
            console.log(this.total)
          })
          .catch(response => {
            console.error("课程列表出错");
          })
      },

      // 清空的方法
      resetData() {
        // 表单输入项数据清空
        this.courseQuery = {}
        // 查询所有讲师数据
        this.getList()
      },

      // 删除课程
      removeDataById(courseId) {
        this.$confirm('此操作将删除该课程信息, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          course.deleteCourse(courseId)
            .then(response => {
              // 提示信息
              this.$message({
                type: 'success',
                message: '删除成功'
              });
              // 刷新页面
              this.getList()
            })
        })
      },


    }


  }
</script>