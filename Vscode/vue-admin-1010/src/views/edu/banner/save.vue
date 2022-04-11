<template>
    <div class="app-container">
        <el-form label-width="120px">
            <el-form-item label="Banner名称">
                <el-input v-model="banner.title" />
            </el-form-item>
            <el-form-item label="Banner排序">
                <el-input-number v-model="banner.sort" controls-position="right" min="0" />
            </el-form-item>
            
            </el-form-item>
            <el-form-item label="自定义Url">
                <el-input v-model="banner.linkUrl" />
            </el-form-item>

            <!-- 讲师头像：TODO -->
            <!-- 讲师头像 -->
            <el-form-item label="Banner图片">

                <!-- 头衔缩略图 -->
                <pan-thumb :image="banner.imageUrl" />
                <!-- 文件上传按钮 -->
                <el-button type="primary" icon="el-icon-upload" @click="imagecropperShow=true">更换头像
                </el-button>

                <!--
                    v-show：是否显示上传组件
                    :key：类似于id，如果一个页面多个图片上传控件，可以做区分
                    :url：后台上传的url地址
                    @close：关闭上传组件
                    @crop-upload-success：上传成功后的回调 
                        <input type="file" name="file"/>
                 -->
                <image-cropper v-show="imagecropperShow" :width="300" :height="300" :key="imagecropperKey"
                    :url="BASE_API+'/eduoss/fileoss'" field="file" @close="close" @crop-upload-success="cropSuccess" />
            </el-form-item>

            <el-form-item>
                <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate">保存</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>


<script>
    import bannerApi from '@/api/edu/banner'
    import ImageCropper from '@/components/ImageCropper'
    import PanThumb from '@/components/PanThumb'
    export default {
        components: { ImageCropper, PanThumb },
        data() {
            return {
                banner: {
                    title: '',
                    sort: 0,
                    linkUrl: '',
                    imageUrl: ''
                },
                // 上传弹框组件是否显示
                imagecropperShow: false,
                // 上传组件key值
                imagecropperKey: 0,
                // 获取dev.env.js里面地址
                BASE_API: process.env.BASE_API,
                // 保存按钮是否禁用,
                saveBtnDisabled: false
            }
        },

        created() {
            this.init()
        },

        watch: {  //监听
            $route(to, from) { //路由变化方式，路由发生变化，方法就会执行
                this.init()
            }
        },

        methods: {
            // 上传图片功能
            close() {
                this.imagecropperShow = false,
                    this.imagecropperKey = this.imagecropperKey + 1
            },
            cropSuccess(data) {
                this.imagecropperShow = false
                this.imagecropperKey = this.imagecropperKey + 1
                // 上传之后接口返回图片地址
                this.banner.imageUrl = data.url
            },

            init() {
                //判断路径有id值,做修改
                if (this.$route.params && this.$route.params.id) {
                    //从路径获取id值
                    const id = this.$route.params.id
                    //调用根据id查询的方法
                    this.getInfo(id)
                } else { //路径没有id值，做添加
                    //清空表单
                    this.banner = {}
                }
            },
            // 根据讲师id查询
            getInfo(id) {
                bannerApi. getListBanner(id)
                    .then(response => {
                        this.banner = response.data.bannerList
                    })
            },

            saveOrUpdate() {
                // 判断是修改还是添加
                if (!this.banner.id) {
                    this.saveBanner()
                } else {
                    this.updateBanner()
                }
            },

            // 修改讲师
            updateBanner() {
                bannerApi.updateBannerInfo(this.banner)
                    .then(response => {
                        // 提示信息
                        console.log("走到这里了吗？")
                        this.$message({
                            type: 'success',
                            meassage: '修改成功!'
                        })
                        // 回到列表
                        this.$router.push({ path: '/banner/table' })
                    })
            },
            // 添加讲师
            saveBanner() {
                bannerApi.addBannerInfo(this.banner)
                    .then(response => {
                        this.$message({
                            type: 'success',
                            meassage: '添加成功！'
                        });
                        //回到列表页面 路由跳转
                        this.$router.push({ path: '/banner/table' })
                    })
            }

        }
    }
</script>