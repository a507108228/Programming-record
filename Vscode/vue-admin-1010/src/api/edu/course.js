import request from '@/utils/request'
export default {
    // 添加课程信息
    addCourseInfo(courseInfo) {
        return request({
            url: '/eduservice/course/addCourseInfo',
            method: 'post',
            data: courseInfo
        })
    },
    // 查询所有讲师
    getListTeacher() {
        return request({
            url: '/eduservice/teacher/findAll',
            method: 'get'
        })
    },

    // 根据课程id查询课程基本信息
    getCourseInfoId(id) {
        return request({
            url: '/eduservice/course/getCourseInfo/' + id,
            method: 'get'
        })
    },
    // 修改课程信息
    updateCourseInfo(courseInfo) {
        return request({
            url: '/eduservice/course/updateCourseInfo',
            method: 'post',
            data: courseInfo
        })
    },

    // 课程确认信息显示
    getPublihCourseInfo(id) {
        return request({
            url: '/eduservice/course/getPublishCourseInfo/' + id,
            method: 'get'
        })
    },

    // 课程最终发布
    publihCourse(id) {
        return request({
            url: '/eduservice/course/publishCourse/' + id,
            method: 'post'
        })
    },

    // 课程列表     
    getListCourse() {
        return request({
            url: '/eduservice/course',
            method: 'get'
        })
    },

    // 课程信息删除
    deleteCourse(courseId){
        return request({
            url: '/eduservice/course/'+courseId,
            method: 'delete'
        })
    },

    // --------------------------

    // current当前页 limit每页记录数 teacherQuery条件对象
    getCourseListPage(current, limit, courseQuery) {
        return request({
            url: `/eduservice/course/pageCourseCondition/${current}/${limit}`,
            method: 'post',
            //data表示把对象转换json进行传递到接口里面
            data: courseQuery
        })
    },

}
