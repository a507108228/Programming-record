import request from '@/utils/request'

export default {
	// 课程分页
	getCourseList(page, limit, searchObj)
	{
		return request({
			url: `/eduservice/coursefront/getCourseFrontList/${page}/${limit}`,
			method: 'post',
			data: searchObj
		})
	},


	// 查询所有分类的方法
	getAllSubject() {
		return request({
			url: `/eduservice/subject/getAllSubject`,
			method: 'get'
		})
	},

	//课程详情的方法
	getCourseInfo(id) {
		return request({
			url: '/eduservice/coursefront/getFrontCourseInfo/' + id,
			method: 'get'
		})
	}



}